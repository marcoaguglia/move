package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Hub")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope = Hub.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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

    @ManyToMany(mappedBy = "starts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "shipping_starts")
    private Set<Shipping> shipping_starts;


    @ManyToMany(mappedBy = "ends", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "shipping_ends")
    private Set<Shipping> shipping_ends;


}
