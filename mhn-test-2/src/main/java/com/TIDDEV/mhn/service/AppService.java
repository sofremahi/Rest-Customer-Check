package com.TIDDEV.mhn.service;

import com.TIDDEV.mhn.service.Repositories.CheckRepository;
import com.TIDDEV.mhn.service.Repositories.CustomerRepository;
import com.TIDDEV.mhn.service.model.Customer;
import com.TIDDEV.mhn.service.modelDto.CustomersListByCheckListCount;
import com.fasterxml.jackson.core.PrettyPrinter;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppService {
    private CheckRepository checkRepository;

    private CustomerRepository customerRepository;

    @Autowired
    public void setCheckRepository(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomResponse<List<CustomersListByCheckListCount>> findCustomersByCheckListSizeToday(Integer size) {
        LocalDate sDate = LocalDate.now();
        LocalDate eDate = sDate.minusDays(1);
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.findCustomersByCheckListSize(size , sDate , eDate));
    }
    public CustomResponse<List<CustomersListByCheckListCount>> findCustomersByCheckListSize(Integer size) {
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.findCustomersByCheckListSize(size , null , null));
    }

    public CustomResponse<List<Customer>> customersByAccNoPrefix(String prefix) {
        List<Customer> customerList = customerRepository.findAll();
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerList.stream().filter(customer -> customer.getAccNo().startsWith(prefix)).
                collect(Collectors.toList()));
    }

    public CustomResponse<List<Customer>> havingChecksNotBetweenAmounts(Double a, Double b) {
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.havingChecksNotBetweenAmounts(a, b));
    }
    public CustomResponse<List<Customer>> havingChecksBetweenAmounts(Double a, Double b) {
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.havingChecksBetweenAmounts(a, b));
    }
    public CustomResponse<List<Customer>> customersStartingWith(String prefix) {
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.customersStartingWith(prefix));
    }
    public CustomResponse<List<Customer>> customersEndingWith(String suffix) {
        return new CustomResponse<>("operation successful",
                HttpStatus.OK, customerRepository.customersEndingWith(suffix));
    }
}
