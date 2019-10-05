package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Hub")
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

    @OneToMany(mappedBy = "starts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    // @JsonBackReference(value = "shipping_starts")
    private Set<Shipping> shipping_starts = new HashSet<>();


    @OneToMany(mappedBy = "ends", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //  @JsonBackReference(value = "shipping_ends")
    @JsonIgnore
    private Set<Shipping> shipping_ends = new HashSet<>();


}
