package br.com.ecommerce.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateDto {

  @NotBlank
  @NotNull
  private String name;

  @NotBlank
  @NotNull
  private String email;

  @NotBlank
  @NotNull
  private String phone;

  @NotBlank
  @NotNull
  private AddressCreateDto addresses;

}
