package com.possystem.POS_System.controller;

import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.dto.request.CustomerUpdateDTO;
import com.possystem.POS_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String customerdetails(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        String message = customerDTO.getCustomerAddress();
        customerService.saveCustomer(customerDTO);
        return message;
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerupdateDTO) {

        customerService.updateCustomer(customerupdateDTO);

    }
}
