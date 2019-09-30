package com.unisalento.move.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Truck")
@Data
public class Truck implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.TIME)
    @Column(name = "data")
    private Date time;


    @OneToMany(mappedBy = "truck")
    private Set<Shipping> shippingsList = new HashSet<>();


    public Truck() {
    }

    public Truck(String id, String name, Date time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

}
