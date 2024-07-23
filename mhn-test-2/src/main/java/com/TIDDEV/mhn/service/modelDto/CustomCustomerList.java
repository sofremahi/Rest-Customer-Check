package com.TIDDEV.mhn.service.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CustomCustomerList{
    private Long customerId;
    private String customerName;
 private Double avgAmount;
}
