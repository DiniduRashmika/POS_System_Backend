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
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerContactNumberRepo customerContactNumberRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
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
    public String updateCustomer(CustomerUpdateDTO customerupdateDTO) {
//        if(customerRepo.existsById(customerUpdateDTO.getId())){

        Optional<Customer> byId = customerRepo.findById(customerupdateDTO.getId());

//        byId.ifPresent(customer -> {
//
//        });
//        byId.orElseThrow(() -> new RuntimeException("Customer not found"));
//
        if (!byId.isPresent()) {
            throw new RuntimeException("User not found");
        }
        Customer customer = byId.get();

        customer.setId(customerupdateDTO.getId());
        customer.setActiveState(customerupdateDTO.getActiveState());
        customer.setCustomerAddress(customerupdateDTO.getCustomerAddress());
        customer.setCustomerName(customerupdateDTO.getCustomerName());
        customerRepo.save(customer);
        return customerupdateDTO.getCustomerName() + " updated Successfully";


//        }else{
//            throw new RuntimeException("User not found");
//        }


    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Optional<Customer> optionlCustomer = customerRepo.findById(customerId);
//        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("No customer found"));

        if (!optionlCustomer.isPresent()) throw new RuntimeException("No customer found");


        //Customer customer = customerRepo.getReferenceById(customerId);
        //Optional<Customer> customer = customerRepo.findById(customerId);
        Customer customer = optionlCustomer.get();

        //System.out.println(customer);

        List<CustomerContactNumber> numbers = customerContactNumberRepo.findByCustomer_Id((customerId));
        //List<CustomerContactNumberDTO> customerContactNumbersDtos = customerDTO.getCustomerContactNumbers();

        List<CustomerContactNumberDTO> customerContactNumberDTOs = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            CustomerContactNumber number = numbers.get(i);
            //customerContactNumberDTO.setCustomer(customer);
            CustomerContactNumberDTO customerContactNumberDTO = new CustomerContactNumberDTO();
            customerContactNumberDTO.setContactNumber(number.getContactNumber());

            customerContactNumberDTOs.add(customerContactNumberDTO);
        }

        CustomerDTO customerDTO = new CustomerDTO(
                customer.getId(),
                customer.getActiveState(),
                customer.getCustomerAddress(),
                customer.getCustomerName(),
                customer.getCustomerSalary(),
                customer.getNic(),
                customerContactNumberDTOs
        );
        //customer.getCustomerContactNumbers());
        //customer.setCustomerContactNumbers(new ArrayList<>()));
        return customerDTO;

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers =customerRepo.findAll();
        //System.out.println(getAllCustomers.get(0));
        List<CustomerDTO> customerDTOList = new ArrayList<>();


        for (Customer customer : getAllCustomers){

            List<CustomerContactNumber> numbers = customerContactNumberRepo.findByCustomer_Id(customer.getId());
            List<CustomerContactNumberDTO> customerContactNumberDTOs = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                CustomerContactNumber number = numbers.get(i);
                CustomerContactNumberDTO customerContactNumberDTO = new CustomerContactNumberDTO(
                        number.getId(),
                        number.getContactNumber()
                );

                customerContactNumberDTOs.add(customerContactNumberDTO);

            }

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getId(),
                    customer.getActiveState(),
                    customer.getCustomerAddress(),
                    customer.getCustomerName(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customerContactNumberDTOs

            );

            customerDTOList.add(customerDTO);

        }

        return customerDTOList;
    }


}
