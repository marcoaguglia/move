package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "spedizione")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Shipping implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;


    @Column(name = "tratta")
    private String tratta;

    @Temporal(TemporalType.TIME)
    @Column(name = "data")
    private Date data;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "temp")
    private String temp;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Departure",
            joinColumns = {@JoinColumn(name = "shipping_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id", referencedColumnName = "id")})
    private Set<Hub> starts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Arrival",
            joinColumns = {@JoinColumn(name = "shipping_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id", referencedColumnName = "id")})
    private Set<Hub> ends;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Container.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id", referencedColumnName = "id")
    @JsonBackReference(value = "cont")
    private Container container;

    @ManyToOne()
    @JoinColumn(name = "truck_id")
    @JsonIgnore
    private Truck truck;


    public Shipping() {
    }

    public Shipping(Date data, String id, String temp, Set<Hub> starts, Set<Hub> ends, Container container, Truck truck) {
        this.data = data;
        this.id = id;
        this.temp = temp;
        this.starts = starts;
        this.ends = ends;
        this.container = container;
        this.truck = truck;
    }

    public String getTratta() {
        return tratta;
    }

    public void setTratta(String tratta) {
        this.tratta = tratta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getStarts() {
        return starts.iterator().next().getId();
    }

    public void setStarts(Set<Hub> starts) {
        this.starts = starts;
    }

    public String getEnds() {
        return ends.iterator().next().getId();
    }

    public void setEnds(Set<Hub> ends) {
        this.ends = ends;
    }

    public Container getContainer_id() {
        return container;
    }

    public void setContainer_id(Container container) {
        this.container = container;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
