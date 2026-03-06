package com.customer.service.app.facade;

import com.customer.service.app.domain.entity.Customer;
import com.customer.service.app.domain.repository.CustomerRepository;
import com.pantry.commons.facade.BaseFacade;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade extends BaseFacade<Customer> {

    private final CustomerRepository repository;

    protected CustomerFacade(CustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
