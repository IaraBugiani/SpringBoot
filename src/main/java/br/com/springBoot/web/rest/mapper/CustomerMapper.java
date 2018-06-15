package br.com.springBoot.web.rest.mapper;

import org.mapstruct.Mapper;

import br.com.springBoot.domain.Customer;
import br.com.springBoot.web.rest.dto.CustomerDTO;
import br.com.springBoot.web.rest.mapper.entityMapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper  extends EntityMapper<CustomerDTO, Customer>{

	default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
