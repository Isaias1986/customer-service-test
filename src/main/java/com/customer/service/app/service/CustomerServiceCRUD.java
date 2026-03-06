package com.customer.service.app.service;

import com.customer.service.app.domain.entity.Customer;
import com.customer.service.app.model.request.CustomerRequest;
import com.customer.service.app.model.response.CustomerResponse;
import org.springframework.data.domain.Page;

public interface CustomerServiceCRUD extends CustomerService{

    default Page<CustomerResponse> list(CustomerRequest u){
        throw new RuntimeException("Method Not Implement");
    }

}
