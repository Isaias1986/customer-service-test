package com.customer.service.app.exception;

import com.pantry.commons.exception.BaseExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class CustomerException extends BaseExceptionHandler {
    protected CustomerException(){}
}
