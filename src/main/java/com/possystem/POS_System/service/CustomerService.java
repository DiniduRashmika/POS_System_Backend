package com.possystem.POS_System.service;

import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.dto.request.CustomerUpdateDTO;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerUpdateDTO customerupdateDTO);
}
