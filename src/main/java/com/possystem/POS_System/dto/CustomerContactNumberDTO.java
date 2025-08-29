package com.possystem.POS_System.dto;

import com.possystem.POS_System.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CustomerContactNumberDTO {
    private Integer id;
   // private Customer customer;
    private String contactNumber;

    public CustomerContactNumberDTO() {
    }

    public CustomerContactNumberDTO(Integer id,  String contactNumber) {
        this.id = id;
        //this.customer = customer;
        this.contactNumber = contactNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "CustomerContactNumberDTO{" +
                "id=" + id +
                //", customer=" + customer +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
