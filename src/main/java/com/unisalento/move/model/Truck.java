package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Truck")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope = Truck.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


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


    @OneToMany(mappedBy = "truck", cascade = CascadeType.ALL)
    private Set<Shipping> shippingsList = new HashSet<>();
    
}
