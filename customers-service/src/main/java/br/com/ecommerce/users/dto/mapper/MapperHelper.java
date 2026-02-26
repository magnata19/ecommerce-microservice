package br.com.ecommerce.users.dto.mapper;

import br.com.ecommerce.users.dto.AddressCreateDto;
import br.com.ecommerce.users.dto.AddressResponseDto;
import br.com.ecommerce.users.dto.CustomerCreateDto;
import br.com.ecommerce.users.dto.CustomerResponseDto;
import br.com.ecommerce.users.entity.Address;
import br.com.ecommerce.users.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MapperHelper {

  public Customer toCustomer (CustomerCreateDto dto) {
    return new Customer(
            dto.getName(),
            dto.getEmail(),
            dto.getPhone(),
            new ArrayList<>()
            );
  }

  public static CustomerResponseDto customerResponseDto(Customer customer) {
    return new ModelMapper().map(customer, CustomerResponseDto.class);
  }

  public Address toAddress(AddressCreateDto address) {
    return new Address(
            address.getStreet(),
            address.getNeighborhood(),
            address.getCity(),
            address.getState(),
            address.getZipCode()
    );
  }

  public AddressResponseDto toAddressResponseDto(Address address) {
    return new AddressResponseDto(
            address.getStreet(),
            address.getNeighbourhood(),
            address.getCity(),
            address.getState(),
            address.getZipCode()
    );
  }

    public CustomerResponseDto toCustomerResponse(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddresses().stream().map(this::toAddressResponseDto).toList()
        );

    }
}
