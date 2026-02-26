package br.com.ecommerce.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.users.entity.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CustomersRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findById(UUID id);
}
