package com.customer.service.app.model.response;


import com.customer.service.app.enums.PaymentType;
import com.pantry.commons.model.BaseResponseDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponse extends BaseResponseDTO {

    private Long id;
    private String name;
    private String movil;
    private String direction;
    private PaymentType paymentType;
}
