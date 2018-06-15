package br.com.springBoot.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springBoot.domain.Customer;
import br.com.springBoot.repository.CustomerRepository;
import br.com.springBoot.service.CustomerService;
import br.com.springBoot.web.rest.dto.CustomerDTO;
import br.com.springBoot.web.rest.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		return mapper.toDto(repository.findAll());
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDto) {
		
		Customer dadosCustomer = mapper.toEntity(customerDto);
		
		return mapper.toDto(repository.save(dadosCustomer));
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		
		Optional<Customer> customerFindBy = repository.findById(customerDTO.getId());
		
		if(customerFindBy == null) {
			throw new EntityNotFoundException("Não existem dados para serem alterados!");
		}
			Customer dadosUpdate = mapper.toEntity(customerDTO);
			dadosUpdate.setActive(customerDTO.isActive());
			dadosUpdate.setAge(customerDTO.getAge());
			dadosUpdate.setNome(customerDTO.getNome());
			
		return mapper.toDto(repository.save(dadosUpdate));
	}

	@Override
	public void deleteCustomer(Long id) {
			repository.deleteById(id);
	}

	@Override
	public void deleteAllCustomer() {
		repository.deleteAll();
	}

}
