package br.com.ecommerce.users.service;

import br.com.ecommerce.users.entity.Address;
import br.com.ecommerce.users.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.users.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomersRepository customersRepository;

  @Transactional
  public Customer createUser(Customer customer) {
    List<Address> address = new ArrayList<>();
    customer.setAddresses(address);
    return customersRepository.save(customer);
  }

  public Customer getUserById(String id) {
    return findById(id);
  }

  public Page<Customer> getAllUsers(Pageable pageable) {
    return customersRepository.findAll(pageable);
  }

  private Customer findById(String id) {
    return customersRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }
}
