package com.unisalento.move.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Container")
@JsonIgnoreProperties("shipping")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

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


    @OneToMany(mappedBy = "container", targetEntity = Shipping.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cont")
    private Set<Shipping> shipping = new HashSet<>();

    public Container() {
    }

    public Container(String container_id, Date date, String contact_sensor, String mems, String pir, String shock_sensor, String brightness_sensor, String out_temp, String ins_temp, String ins_rh, String lat, String lon, String temp_cell_1, String temp_cell_2, String temp_cell_3, String temp_cell_4, String temp_cell_5, String rh_cell_1, String rh_cell_2, String rh_cell_3, String rh_cell_4, String rh_cell_5, Set<Shipping> shipping) {
        this.date = date;
        this.contact_sensor = contact_sensor;
        this.mems = mems;
        this.pir = pir;
        this.shock_sensor = shock_sensor;
        this.brightness_sensor = brightness_sensor;
        this.out_temp = out_temp;
        this.ins_temp = ins_temp;
        this.ins_rh = ins_rh;
        this.lat = lat;
        this.lon = lon;
        this.temp_cell_1 = temp_cell_1;
        this.temp_cell_2 = temp_cell_2;
        this.temp_cell_3 = temp_cell_3;
        this.temp_cell_4 = temp_cell_4;
        this.temp_cell_5 = temp_cell_5;
        this.rh_cell_1 = rh_cell_1;
        this.rh_cell_2 = rh_cell_2;
        this.rh_cell_3 = rh_cell_3;
        this.rh_cell_4 = rh_cell_4;
        this.rh_cell_5 = rh_cell_5;
        this.shipping = shipping;
        this.container_id = container_id;
    }

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact_sensor() {
        return contact_sensor;
    }

    public void setContact_sensor(String contact_sensor) {
        this.contact_sensor = contact_sensor;
    }

    public String getMems() {
        return mems;
    }

    public void setMems(String mems) {
        this.mems = mems;
    }

    public String getPir() {
        return pir;
    }

    public void setPir(String pir) {
        this.pir = pir;
    }

    public String getShock_sensor() {
        return shock_sensor;
    }

    public void setShock_sensor(String shock_sensor) {
        this.shock_sensor = shock_sensor;
    }

    public String getBrightness_sensor() {
        return brightness_sensor;
    }

    public void setBrightness_sensor(String brightness_sensor) {
        this.brightness_sensor = brightness_sensor;
    }

    public String getOut_temp() {
        return out_temp;
    }

    public void setOut_temp(String out_temp) {
        this.out_temp = out_temp;
    }

    public String getIns_temp() {
        return ins_temp;
    }

    public void setIns_temp(String ins_temp) {
        this.ins_temp = ins_temp;
    }

    public String getIns_rh() {
        return ins_rh;
    }

    public void setIns_rh(String ins_rh) {
        this.ins_rh = ins_rh;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTemp_cell_1() {
        return temp_cell_1;
    }

    public void setTemp_cell_1(String temp_cell_1) {
        this.temp_cell_1 = temp_cell_1;
    }

    public String getTemp_cell_2() {
        return temp_cell_2;
    }

    public void setTemp_cell_2(String temp_cell_2) {
        this.temp_cell_2 = temp_cell_2;
    }

    public String getTemp_cell_3() {
        return temp_cell_3;
    }

    public void setTemp_cell_3(String temp_cell_3) {
        this.temp_cell_3 = temp_cell_3;
    }

    public String getTemp_cell_4() {
        return temp_cell_4;
    }

    public void setTemp_cell_4(String temp_cell_4) {
        this.temp_cell_4 = temp_cell_4;
    }

    public String getTemp_cell_5() {
        return temp_cell_5;
    }

    public void setTemp_cell_5(String temp_cell_5) {
        this.temp_cell_5 = temp_cell_5;
    }

    public String getRh_cell_1() {
        return rh_cell_1;
    }

    public void setRh_cell_1(String rh_cell_1) {
        this.rh_cell_1 = rh_cell_1;
    }

    public String getRh_cell_2() {
        return rh_cell_2;
    }

    public void setRh_cell_2(String rh_cell_2) {
        this.rh_cell_2 = rh_cell_2;
    }

    public String getRh_cell_3() {
        return rh_cell_3;
    }

    public void setRh_cell_3(String rh_cell_3) {
        this.rh_cell_3 = rh_cell_3;
    }

    public String getRh_cell_4() {
        return rh_cell_4;
    }

    public void setRh_cell_4(String rh_cell_4) {
        this.rh_cell_4 = rh_cell_4;
    }

    public String getRh_cell_5() {
        return rh_cell_5;
    }

    public void setRh_cell_5(String rh_cell_5) {
        this.rh_cell_5 = rh_cell_5;
    }

    public Set<Shipping> getShipping() {
        return shipping;
    }

    public void setShipping(Set<Shipping> shipping) {
        this.shipping = shipping;
    }
}
