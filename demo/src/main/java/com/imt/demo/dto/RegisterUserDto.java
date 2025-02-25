package com.imt.demo.dto;

import jakarta.validation.constraints.*;
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
public class RegisterUserDto {

    @NotBlank
    private String fullName;

    @Email @Size(max=100)
    private String email;

    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    @Pattern(regexp = ".*\\d.*", message = "Le mot de passe doit contenir au moins un chiffre")
    @Pattern(regexp = ".*[A-Z].*", message = "Le mot de passe doit contenir au moins une majuscule")
    private String password;

}
