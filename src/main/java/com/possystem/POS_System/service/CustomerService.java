package com.possystem.POS_System.service;

import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerupdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();
}
