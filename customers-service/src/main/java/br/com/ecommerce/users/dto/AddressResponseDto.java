package br.com.ecommerce.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {

    private String id;
    private String street;
    private String neighbourhood;
    private String city;
    private String state;
    private String zipCode;

    public AddressResponseDto(String street, String neighbourhood, String city, String state, String zipCode) {
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
