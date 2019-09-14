package com.unisalento.move.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Hub")
@Data
public class Hub implements Serializable{

    private static final long serialVersionUID = -2543425088717298236L;


    @Id
    @GeneratedValue
    @Column(name = "")
    private String id;
    @Column(name = "")
    private String lon;
    @Column(name = "")
    private String lat;


    public Hub() {
    }

    public Hub(String id, String lon, String lat) {
        this.id = id;
        this.lon = lon;
        this.lat = lat;
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
