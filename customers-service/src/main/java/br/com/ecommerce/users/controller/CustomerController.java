package br.com.ecommerce.users.controller;

import br.com.ecommerce.users.dto.AddressCreateDto;
import br.com.ecommerce.users.dto.CustomerCreateDto;
import br.com.ecommerce.users.dto.CustomerResponseDto;
import br.com.ecommerce.users.dto.mapper.MapperHelper;
import br.com.ecommerce.users.entity.Customer;
import br.com.ecommerce.users.service.AddressService;
import br.com.ecommerce.users.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;
  private final AddressService addressService;
  private final MapperHelper mapperHelper;

  @PostMapping
  public ResponseEntity<CustomerResponseDto> createUser(@RequestBody CustomerCreateDto customerCreateDto) {
    Customer customer = customerService.createUser(mapperHelper.toCustomer(customerCreateDto));
    return ResponseEntity.ok(mapperHelper.toCustomerResponse(customer));
  }

  @PostMapping("/{id}/add-address")
  public ResponseEntity<Map<String, String>> addAddressToCustomer(@RequestBody AddressCreateDto dto, @PathVariable UUID id){
    var response = addressService.addAddressToCustomer(mapperHelper.toAddress(dto), id);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<Page<CustomerResponseDto>> getAllUsers(@PageableDefault(size = 10, page = 0) Pageable pageable) {
    Page<CustomerResponseDto> mappedUsers = customerService.getAllUsers(pageable).map(
            customer -> MapperHelper.customerResponseDto(customer));
    return ResponseEntity.ok(mappedUsers);
  }
}
