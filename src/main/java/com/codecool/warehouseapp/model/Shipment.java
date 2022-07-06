package com.codecool.warehouseapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @DateTimeFormat
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipmentDate;

    @Min(value=0, message="must be equal or greater than 0")
    @NumberFormat
    private int weight;

    @Min(value=0, message="must be equal or greater than 0")
    @NumberFormat
    private int currency;

    @ManyToOne
    private Supplier supplier;

}
