package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "spedizione")
@Data
public class Shipping implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tratta")
    private String tratta;

    @Temporal(TemporalType.TIME)
    @Column(name = "data")
    private Date data;

    @Column(name = "id")
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


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Container container_id;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    @JsonIgnore
    private Truck truck;


    public Shipping() {
    }

    public Shipping(Date data, String id, String temp, Set<Hub> starts, Set<Hub> ends, Container container_id, Truck truck) {
        this.data = data;
        this.id = id;
        this.temp = temp;
        this.starts = starts;
        this.ends = ends;
        this.container_id = container_id;
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

    public Set<Hub> getStarts() {
        return starts;
    }

    public void setStarts(Set<Hub> starts) {
        this.starts = starts;
    }

    public Set<Hub> getEnds() {
        return ends;
    }

    public void setEnds(Set<Hub> ends) {
        this.ends = ends;
    }

    public Container getContainer_id() {
        return container_id;
    }

    public void setContainer_id(Container container_id) {
        this.container_id = container_id;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
