package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Container")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Container implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "container_id")
    private String container_id;

    @Column(name = "contact_sensor")
    private String contact_sensor;

    @Column(name = "mems")
    private String mems;

    @Column(name = "pir")
    private String pir;

    @Column(name = "shock_sensor")
    private String shock_sensor;

    @Column(name = "brightness_sensor")
    private String brightness_sensor;

    @Column(name = "out_temp")
    private String out_temp;
    @Column(name = "ins_temp")
    private String ins_temp;
    @Column(name = "ins_rh")
    private String ins_rh;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Column(name = "temp_cell_1")
    private String temp_cell_1;
    @Column(name = "temp_cell_2")
    private String temp_cell_2;
    @Column(name = "temp_cell_3")
    private String temp_cell_3;
    @Column(name = "temp_cell_4")
    private String temp_cell_4;
    @Column(name = "temp_cell_5")
    private String temp_cell_5;
    @Column(name = "rh_cell_1")
    private String rh_cell_1;
    @Column(name = "rh_cell_2")
    private String rh_cell_2;
    @Column(name = "rh_cell_3")
    private String rh_cell_3;
    @Column(name = "rh_cell_4")
    private String rh_cell_4;
    @Column(name = "rh_cell_5")
    private String rh_cell_5;

    @ManyToMany(mappedBy = "container", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "shipping")
    private Set<Shipping> shipping;


}
