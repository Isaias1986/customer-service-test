package com.customer.service.app.service.impl;

import com.customer.service.app.domain.entity.Customer;
import com.customer.service.app.enums.EnumBadRequest;
import com.customer.service.app.facade.CustomerFacade;
import com.customer.service.app.mapper.CustomerMapper;
import com.customer.service.app.model.request.CustomerRequest;
import com.customer.service.app.model.response.CustomerResponse;
import com.customer.service.app.service.CustomerServiceCRUD;
import com.pantry.commons.exception.BaseCustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceCRUD {

    private final CustomerFacade facade;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse save(CustomerRequest request) {

        return customerMapper
                .toResponse(facade
                        .save(customerMapper
                                .toEntity(request)));

    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
       Customer up = facade.findById(id)
                .orElseThrow( () -> new BaseCustomException(null, EnumBadRequest.RECORD_NOT_FOUND));
       up.setName(request.getName());
       up.setDirection(request.getDirection());
       up.setMovil(request.getMovil());
       up.setPaymentType(request.getPaymentType());
       return customerMapper
                .toResponse(facade.update(up));
    }


    @Override
    public CustomerResponse findById(Long id) {
        return customerMapper.toResponse(facade.findById(id)
                .orElseThrow( () -> new BaseCustomException(null, EnumBadRequest.RECORD_NOT_FOUND)));
    }


    public void deleteById(Long id) {
        this.findById(id);
        facade.delete(id);
    }
}
