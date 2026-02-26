package br.com.ecommerce.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private List<AddressResponseDto> addresses;
}
