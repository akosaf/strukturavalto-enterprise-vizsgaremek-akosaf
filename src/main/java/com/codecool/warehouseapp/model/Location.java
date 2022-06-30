package com.codecool.warehouseapp.model;

import com.codecool.warehouseapp.model.location.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JsonManagedReference
    private List<Stock> stock;

    @ManyToOne
//    @JsonBackReference
    private Bin bin;

    @ManyToOne
//    @JsonBackReference
    private Shelf shelf;

    @ManyToOne
//    @JsonBackReference
    private Rack rack;

    @ManyToOne
//    @JsonBackReference
    private Aisle aisle;

    @ManyToOne
//    @JsonBackReference
    private Zone zone;

}
