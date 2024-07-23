package com.TIDDEV.mhn.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Table(name = "CUSTOMER_CHECK")
@Entity
public class CustomerCheck {
    @Id
    @Column(name = "ID" ,nullable = false)
    private Long Id;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "CHECK_DATE")
    private LocalDate checkDate;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonBackReference
    private Customer customer;
}
