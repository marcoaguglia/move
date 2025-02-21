package com.unisalento.move.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // configurazione Cors per poter consumare le /api restful con richieste ajax
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.setAllowedMethods(Arrays.asList("POST, PUT, GET, OPTIONS, DELETE"));
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // non abbiamo bisogno di una sessione
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and()
                .authorizeRequests()
                .antMatchers(
                        //HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**",
                        "api"
                ).permitAll()
                .antMatchers(HttpMethod.GET, "/api/").permitAll()

                .antMatchers(HttpMethod.POST, "/api/login/**").permitAll()
/***************RASP******************/

                .antMatchers(HttpMethod.POST, "/api/containers/**").hasAuthority("ROLE_SMARTBOX")
/***************USERS******************/


/***************MANAGER******************/
                .antMatchers("/api/containers/**").hasAuthority("ROLE_MANAGER")
                .antMatchers("/api/hub/**").hasAuthority("ROLE_MANAGER")
                .antMatchers("/api/truck/**").hasAuthority("ROLE_MANAGER")

                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/users/**").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAuthority("ROLE_MANAGER")
/***************ADMIN******************/

                .antMatchers("/api/containers/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/containers/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/hub/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/truck/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/users/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/users/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/refresh-token").authenticated()
                .anyRequest().authenticated();

        // Filtro Custom JWT
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().cacheControl();
    }
}