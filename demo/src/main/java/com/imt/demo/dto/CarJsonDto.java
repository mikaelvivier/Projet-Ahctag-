package com.imt.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO (Data Transfer Object) est un objet utilisé
// pour transférer des données entre les couches d'une application.

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarJsonDto {
    
    @NotNull private Brand brand;
    @NotBlank private String color;
    @Min(50) private int horsePower;
}
