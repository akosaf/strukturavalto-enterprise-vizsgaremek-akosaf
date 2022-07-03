package com.codecool.warehouseapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @DateTimeFormat
    private LocalDate shipmentDate;

    @NotBlank
    @NumberFormat
    private int weight;

    @NotBlank
    @NumberFormat
    private int currency;

    @NotBlank
    @ManyToOne
    private Supplier supplier;

}
