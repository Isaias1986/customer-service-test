package com.customer.service.app.service;

import com.customer.service.app.domain.entity.Customer;
import com.customer.service.app.model.request.CustomerRequest;
import com.customer.service.app.model.response.CustomerResponse;
import com.pantry.commons.service.BaseService;

public interface CustomerService extends BaseService<CustomerResponse, CustomerRequest, Customer> {
}
