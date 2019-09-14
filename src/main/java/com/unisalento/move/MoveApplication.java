package com.unisalento.move;

import com.unisalento.move.repository.AuthorityRepository;
import com.unisalento.move.repository.UserRepository;
import com.unisalento.move.model.Authority;
import com.unisalento.move.model.AuthorityName;
import com.unisalento.move.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


@EnableJpaRepositories
@SpringBootApplication
public class MoveApplication {


    @Autowired
    private DataSource datasource;
    @Autowired
    private ApplicationContext webApplicationContext;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, AuthorityRepository authorityRepository) {
        return (args) -> {

            User user=userRepository.findByUsername("admin");

            if(user == null){

                /**
                 * Inizializzo i dati del mio test
                 */


                Authority authorityAdmin=new Authority();
                authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
                authorityAdmin=authorityRepository.save(authorityAdmin);

                Authority authorityUser=new Authority();
                authorityUser.setName(AuthorityName.ROLE_USER);
                authorityUser=authorityRepository.save(authorityUser);


                List<Authority> authorities = Arrays.asList(authorityAdmin,authorityUser);


                user = new User();
                user.setAuthorities(authorities);
                user.setEnabled(true);
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));

                user = userRepository.save(user);

            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(MoveApplication.class, args);

    }



}

