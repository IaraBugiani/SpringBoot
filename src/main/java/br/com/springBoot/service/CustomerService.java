package br.com.springBoot.service;

import java.util.List;

import br.com.springBoot.domain.Customer;
import br.com.springBoot.web.rest.dto.CustomerDTO;

public interface CustomerService {
	
	List<CustomerDTO> getAllCustomers();
	
	List<Customer> findByNomeContains(String nome);
	
	CustomerDTO createCustomer(CustomerDTO customer);
	
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	
	void deleteCustomer(Long id);
	
	void deleteAllCustomer();
	

}
