package com.TIDDEV.mhn.service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "CUSTOMER")
@Entity
public class Customer {
    @Id
    @Column(name = "ID" , nullable = false)
private Long ID ;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "CUSTOMER_NATIONAL")
    private String customerNational;

    @Column(name = "ACC_NO")
    private String accNo ;


}
