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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Stock name cannot be blank!")
    private String name;

    @NotBlank(message = "Stock description cannot be blank!")
    private String description;

    @DateTimeFormat
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiration;

    @Min(value=0, message="must be equal or greater than 0")
    @NumberFormat
    private int price;

    @Min(value=0, message="must be equal or greater than 0")
    @NumberFormat
    private int quantity;

    @NotBlank(message = "Country of origin cannot be blank!")
    private String countryOfOrigin;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Shipment shipment;

}
