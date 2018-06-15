package br.com.springBoot.service;

import java.util.List;

import br.com.springBoot.web.rest.dto.CustomerDTO;

public interface CustomerService {
	
	List<CustomerDTO> getAllCustomers();
	
	CustomerDTO createCustomer(CustomerDTO customer);
	
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	
	void deleteCustomer(Long id);
	
	void deleteAllCustomer();
	

}
