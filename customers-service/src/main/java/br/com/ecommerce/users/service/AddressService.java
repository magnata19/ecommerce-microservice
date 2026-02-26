package br.com.ecommerce.users.service;

import br.com.ecommerce.users.entity.Address;
import br.com.ecommerce.users.entity.Customer;
import br.com.ecommerce.users.repository.AddressRepository;
import br.com.ecommerce.users.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomersRepository customersRepository;

    public AddressService(AddressRepository addressRepository, CustomersRepository customersRepository) {
        this.addressRepository = addressRepository;
        this.customersRepository = customersRepository;
    }

    public Map<String, String> addAddressToCustomer(Address address, UUID id) {
        Optional<Customer> customer = customersRepository.findById(id);
        if(customer.isEmpty()) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }
        customer.get().getAddresses().add(address);
        address.setCustomer(customer.get());
        addressRepository.save(address);
        return Map.of("message", "Address added successfully to customer with id: " + id);
    }
}
