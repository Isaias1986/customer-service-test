package com.customer.service.app.model.request;


import com.customer.service.app.enums.PaymentType;
import com.pantry.commons.model.BaseRequestDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerRequest extends BaseRequestDTO {

    private String name;
    private String movil;
    private String direction;
    private PaymentType paymentType;
}
