package com.codecool.warehouseapp.model;

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
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Supplier name cannot be blank!")
    private String name;

    @NotBlank(message = "Country cannot be blank!")
    private String country;

    @DateTimeFormat
    private LocalDate registrationDate;

    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=100, message="must be equal or less than 100")
    @NumberFormat
    private int discount;
}
