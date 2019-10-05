package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "spedizione")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Departure",
            joinColumns = {@JoinColumn(name = "shipping_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id", referencedColumnName = "id")})
    private Set<Hub> starts;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Arrival",
            joinColumns = {@JoinColumn(name = "shipping_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id", referencedColumnName = "id")})
    private Set<Hub> ends;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Shipping_update",
            joinColumns = {@JoinColumn(name = "shipping_update_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "container_id", referencedColumnName = "id")})
    private Set<Container> container;
    /*
        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Container.class, cascade = CascadeType.ALL)
        @JoinColumn(name = "container_id", referencedColumnName = "id")
        @JsonBackReference(value = "cont")
        private Container container;
    */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    private Truck truck;

}
