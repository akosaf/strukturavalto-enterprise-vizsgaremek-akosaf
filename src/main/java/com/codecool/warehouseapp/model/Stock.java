package com.codecool.warehouseapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate expiration;
    private int price;
    private String countryOfOrigin;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Shipment shipment;

    @ManyToOne
    @JsonBackReference
    private Location location;

}
