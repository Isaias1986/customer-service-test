package com.customer.service.app.controller;

import com.customer.service.app.model.request.CustomerRequest;
import com.customer.service.app.model.response.CustomerResponse;
import com.customer.service.app.service.CustomerService;
import com.pantry.commons.model.BaseHttpResponse;
import com.pantry.commons.utils.BaseUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;


    @Operation(summary = "Customer", description = "Busqueda de registro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseHttpResponse<CustomerResponse>> findById(
            @PathVariable("id")
            @Parameter(name = "id", description = "customer id")Long id){
        return ResponseEntity.ok(BaseHttpResponse
                .<CustomerResponse>builder()
                .httpStatus(HttpStatus.OK)
                .message("success")
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .data(service.findById(id))
                .build());
    }


    @Operation(summary = "Customer", description = "Save")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully Save"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<BaseHttpResponse<CustomerResponse>> save(@RequestBody CustomerRequest request){
        CustomerResponse response = service.save(request);
        return ResponseEntity.created(BaseUtils.getUri("/api/customer/"+response.getId()))
                .body(BaseHttpResponse
                .<CustomerResponse>builder()
                .timeStamp(now())
                .statusCode(CREATED.value())
                .httpStatus(CREATED)
                .message("Customer saved")
                .data(response)
                .build());
    }

    @Operation(summary = "Customer", description = "Update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully Update"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<BaseHttpResponse<CustomerResponse>> update(
            @PathVariable("id")
            @Parameter(name = "id", description = "customer id")Long id,
            @RequestBody CustomerRequest request){

        return ResponseEntity.ok()
                .body(BaseHttpResponse
                        .<CustomerResponse>builder()
                        .timeStamp(now())
                        .statusCode(OK.value())
                        .httpStatus(OK)
                        .message("Customer updated")
                        .data(service.update(id,request))
                        .build());
    }



    @Operation(summary = "Delete a Customer", description = "Update a Customer status to DELETED")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Access Denied."),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "424", description = "Failed dependency"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("id") @Parameter(name = "id", description = "Customer id to delete", example = "1") Long id
    ) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
