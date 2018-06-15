package br.com.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springBoot.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
