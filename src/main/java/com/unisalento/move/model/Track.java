package com.unisalento.move.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Track")
@Data
public class Track implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "data")
    private String time;



    @OneToMany(mappedBy = "track")
    private Set<Spedizione> spedizionesList = new HashSet<>();



    public Track() {
    }

    public Track(String id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

}
