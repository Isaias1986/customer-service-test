package com.customer.service.app.domain.entity;

import com.customer.service.app.enums.PaymentType;
import com.pantry.commons.domain.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "name",  length = 100, nullable = false)
    private String name;
    @Column(name = "movil", length = 10, nullable = false)
    private String movil;
    @Column(name = "direction", length = 150, nullable = false)
    private String direction;
    @Column(name = "payment_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
