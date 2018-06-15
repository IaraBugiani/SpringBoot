package br.com.springBoot.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springBoot.service.CustomerService;
import br.com.springBoot.web.rest.dto.CustomerDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<CustomerDTO>> getFindAllCustomer(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllCustomers());
	}
	
	@PostMapping("/created")
	public ResponseEntity<CustomerDTO> createdCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		return ResponseEntity.status(HttpStatus.OK).body(service.createCustomer(customerDTO));
	}
	
	@PutMapping("/updateFindById")
	public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(customerDTO));
	}
	
	@GetMapping("/deleteFindById/{id}")
	public ResponseEntity<Void> deleteFindById(@PathVariable("id") Long id){
		service.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Void> deleteAll(){
		service.deleteAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
