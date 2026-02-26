package br.com.ecommerce.users.repository;

import br.com.ecommerce.users.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
