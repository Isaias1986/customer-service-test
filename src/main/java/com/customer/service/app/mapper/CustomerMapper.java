package com.customer.service.app.mapper;

import com.customer.service.app.domain.entity.Customer;
import com.customer.service.app.model.request.CustomerRequest;
import com.customer.service.app.model.response.CustomerResponse;
import com.pantry.commons.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<CustomerResponse, CustomerRequest, Customer> {
}
