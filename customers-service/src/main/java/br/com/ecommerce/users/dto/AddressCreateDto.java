package br.com.ecommerce.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressCreateDto {
    @NotBlank
    @NotNull
    private String street;

    @NotBlank
    @NotNull
    private String neighborhood;

    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
    private String state;

    @NotBlank
    @NotNull
    private String zipCode;
}
