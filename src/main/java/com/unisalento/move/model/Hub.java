package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Hub")
@Data
public class Hub implements Serializable{

    private static final long serialVersionUID = -2543425088717298236L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "lon")
    private String lon;
    @Column(name = "lat")
    private String lat;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    @ManyToMany(mappedBy = "starts", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Shipping> shipping_starts;


    @ManyToMany(mappedBy = "ends", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Shipping> shipping_ends;

    public Hub() {
    }

    public Hub(String lon, String lat, String city, String country, Set<Shipping> shipping_starts, Set<Shipping> shipping_ends) {
        this.lon = lon;
        this.lat = lat;
        this.city = city;
        this.country = country;
        this.shipping_starts = shipping_starts;
        this.shipping_ends = shipping_ends;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Shipping> getShipping_starts() {
        return shipping_starts;
    }

    public void setShipping_starts(Set<Shipping> shipping_starts) {
        this.shipping_starts = shipping_starts;
    }

    public Set<Shipping> getShipping_ends() {
        return shipping_ends;
    }

    public void setShipping_ends(Set<Shipping> shipping_ends) {
        this.shipping_ends = shipping_ends;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
