package com.unisalento.move.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "spedizione")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shipping implements Serializable {

    private static final long serialVersionUID = -2543425088717298236L;


    @Column(name = "tratta")
    private String tratta;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "data")
    private Date data;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "starts_id", referencedColumnName = "id")

    private Hub starts;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ends_id", referencedColumnName = "id")
    private Hub ends;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Shipping_update",
            joinColumns = {@JoinColumn(name = "shipping_update_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "container_id", referencedColumnName = "id")})
    private Set<Container> container;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    private Truck truck;

    
}
