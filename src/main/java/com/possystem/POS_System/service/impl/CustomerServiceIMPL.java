package com.possystem.POS_System.service.impl;

import com.possystem.POS_System.dto.CustomerContactNumberDTO;
import com.possystem.POS_System.dto.CustomerDTO;
import com.possystem.POS_System.dto.request.CustomerUpdateDTO;
import com.possystem.POS_System.entity.Customer;
import com.possystem.POS_System.entity.CustomerContactNumber;
import com.possystem.POS_System.repo.CustomerContactNumberRepo;
import com.possystem.POS_System.repo.CustomerRepo;
import com.possystem.POS_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerContactNumberRepo customerContactNumberRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer (
                customerDTO.getId(),
                customerDTO.getActiveState(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic()

        );
        customerRepo.save(customer);

        List<CustomerContactNumberDTO> customerContactNumbersDtos = customerDTO.getCustomerContactNumbers();

        List<CustomerContactNumber> customerContactNumbers = new ArrayList<>();

        for (CustomerContactNumberDTO customerContactNumberDTO : customerContactNumbersDtos) {
            CustomerContactNumber customerContactNumber = new CustomerContactNumber();
            customerContactNumber.setContactNumber(customerContactNumberDTO.getContactNumber());

            customerContactNumber.setCustomer(customer);

            customerContactNumbers.add(customerContactNumber);
            customerContactNumberRepo.save(customerContactNumber);
        }


        customer.setCustomerContactNumbers(customerContactNumbers);
        //customerRepo.save(customer);
        System.out.println(customer);



        return customer.toString();

    }

    @Override
    public void updateCustomer(CustomerUpdateDTO customerupdateDTO) {

    }


}
