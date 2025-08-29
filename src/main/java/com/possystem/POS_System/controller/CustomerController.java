package com.possystem.POS_System.controller;

import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.dto.request.CustomerUpdateDTO;
import com.possystem.POS_System.entity.Customer;
import com.possystem.POS_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String customerdetails(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        String message = customerDTO.getCustomerAddress();
        customerService.saveCustomer(customerDTO);
        return message;
    }

    @PutMapping("/update")
    public String customerupdate(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        try{
            customerService.updateCustomer(customerUpdateDTO);
            String message = customerService.updateCustomer(customerUpdateDTO);
            return message;

        }catch(Exception exception){
            return exception.toString();
        }
    }

    @GetMapping(
            path= "/get-by-id",
            params= "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;

    }

    @GetMapping(
            path= "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allcustomers = customerService.getAllCustomers();
        return allcustomers;



    }

}
