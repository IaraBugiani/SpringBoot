package br.com.springBoot.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springBoot.domain.Customer;
import br.com.springBoot.service.CustomerService;
import br.com.springBoot.web.rest.dto.CustomerDTO;


@RestController
@RequestMapping(value="/customer")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping(value="findAll",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDTO>> getFindAllCustomer(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllCustomers());
	}
	
	@GetMapping(value="/findByNome/{nome}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> findByNome(@Valid @PathVariable("nome") String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNomeContains(nome));
	}
	
	@PostMapping(value="/created" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> createdCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		return ResponseEntity.status(HttpStatus.OK).body(service.createCustomer(customerDTO));
	}
	
	@PutMapping(value = "/updateFindById", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(customerDTO));
	}
	
	@GetMapping(value = "/deleteFindById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteFindById(@Valid @PathVariable("id") Long id){
		service.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping(value = "/deleteAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAll(){
		service.deleteAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
