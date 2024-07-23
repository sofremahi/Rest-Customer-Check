package com.TIDDEV.mhn.service.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CustomersListByCheckListCount{
    private Long customerId;
    private String customerName;
    private Long checkCounts;
    private LocalDate date;
}
