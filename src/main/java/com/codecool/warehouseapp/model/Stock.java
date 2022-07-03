package com.codecool.warehouseapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    @DateTimeFormat
    private LocalDate expiration;

    @NotBlank
    @NumberFormat
    private int price;

    @NotBlank
    @NumberFormat
    private int quantity;

    @NotBlank
    private String countryOfOrigin;

    @NotBlank
    @ManyToOne
    private Category category;

    @NotBlank
    @ManyToOne
    private Shipment shipment;

}
