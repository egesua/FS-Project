package com.workintech.ECommerce.Backend.api.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {

    @NotNull
    @NotBlank
    @Min(3)
    @Max(255)
    private String username;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Min(6)
    @Max(255)
    private String password;
    @NotNull
    @NotBlank
    @Min(3)
    @Max(255)
    private String firstName;
    @NotNull
    @NotBlank
    @Min(3)
    @Max(255)
    private String lastName;
}
