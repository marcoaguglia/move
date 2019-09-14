package com.unisalento.move.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spedizione")
@Data
public class Spedizione implements Serializable{

    private static final long serialVersionUID = -2543425088717298236L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "temp")
    private String temp;
    @Column(name = "Container_id")
    private String parent;

   @ManyToOne
    private Track track;

 /*    @OneToMany(mappedBy = "spedizione")
    private Set<Track> hubsList = new HashSet<>();
   @OneToMany(mappedBy = "spedizione")
    private Set<Track>containersList = new HashSet<>();*/


    public Spedizione() {
    }

    public Spedizione(String id, String name, String description, String parent) {
        this.id = id;
        this.temp = name;
        this.parent = parent;
    }
    
}
