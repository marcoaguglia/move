package com.unisalento.move.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Container")
@Data
public class Container implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;

    @Column(name = "date")
    private String date;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "container_id")
    private String container_id;
    @Column(name = "cell_number")
    private String cell_number;
    @Column(name = "shipping_id")
    private String shipping_id;
    @Column(name = "temp")
    private String temp;
    @Column(name = "lat")
    private String lat;
    @Column(name = "lon")
    private String lon;
    @Column(name = "rh")
    private String rh;

    public Container() {
    }

    public Container(String date, String cell_number, String shipping_id, String temp, String lat, String lon, String rh) {
        this.date = date;
        this.cell_number = cell_number;
        this.shipping_id = shipping_id;
        this.temp = temp;
        this.lat = lat;
        this.lon = lon;
        this.rh = rh;
    }

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getCell_number() {
        return cell_number;
    }

    public void setCell_number(String cell_number) {
        this.cell_number = cell_number;
    }

    public String getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(String shipping_id) {
        this.shipping_id = shipping_id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }


// @ManyToMany(mappedBy = "container")
    //   private Set<Spedizione> spedizionesList = new HashSet<>();






 /*   @Override
    public String toString() {
        return "Block{" +
                "ora='" + System.currentTimeMillis() + '\'' +
                "id='" + id + '\'' +
                ", temp='" + "test" + '\'' +
                ", rh='" + "valore" + '\'' +
                ", lat='" + "valore" + '\'' +
                ", lon='" + "valore" + '\'' +
                '}';
    }
*/

}
