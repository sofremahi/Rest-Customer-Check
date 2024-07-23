package com.TIDDEV.mhn.web;

import com.TIDDEV.mhn.service.AppService;
import com.TIDDEV.mhn.service.CustomResponse;
import com.TIDDEV.mhn.service.model.Customer;
import com.TIDDEV.mhn.service.modelDto.CustomersListByCheckListCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/customer")
public class Controller {
    private AppService service ;
@Autowired
    public void setService(AppService service) {
        this.service = service;
    }


    @GetMapping("/customers/by/checklist/size/today/{size}")
    public CustomResponse<List<CustomersListByCheckListCount>> customersByCheckListSizeToday(@PathVariable("size") Integer size){
        return service.findCustomersByCheckListSizeToday(size);
    } @GetMapping("/customers/by/checklist/size/{size}")
    public CustomResponse<List<CustomersListByCheckListCount>> customersByCheckListSize(@PathVariable("size") Integer size){
        return service.findCustomersByCheckListSize(size);
    }

    @GetMapping("/customers/by/accNo/prefix/{prefix}")
    public CustomResponse<List<Customer>> customersByAccNoPrefix(@PathVariable("prefix") String prefix){
    return service.customersByAccNoPrefix(prefix);
    }
    @GetMapping("/customers/having/checks/not/between/{a}/{b}")
    public CustomResponse<List<Customer>> customersHavingChecksNotBetweenAmounts(@PathVariable("a") Double a,
                                                                     @PathVariable("b") Double b){
        return service.havingChecksNotBetweenAmounts(a , b);
    }
    @GetMapping("/customers/having/checks/between/{a}/{b}")
    public CustomResponse<List<Customer>> customersHavingChecksBetweenAmounts(@PathVariable("a") Double a,
                                                                              @PathVariable("b") Double b){
        return service.havingChecksBetweenAmounts(a , b);
    }
    @GetMapping("/customers/starting/with/{prefix}")
    public CustomResponse<List<Customer>> customersStartingWith(@PathVariable("prefix") String prefix){
        return service.customersStartingWith(prefix);
    }
    @GetMapping("/customers/ending/with/{suffix}")
    public CustomResponse<List<Customer>> customersEndingWith(@PathVariable("suffix") String suffix){
        return service.customersEndingWith(suffix);
    }
    @GetMapping("/customers/avgAmount/per/customer/chart")
    public ResponseEntity<byte []> getCustomChart() throws Exception{
       byte[] image = service.chart();
        HttpHeaders headers = new HttpHeaders(); headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image , headers, HttpStatus.OK);
    }
}
