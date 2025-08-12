package com.possystem.POS_System.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer_contact_numbers")
public class CustomerContactNumber {

    @Id//not null unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_customer_id")
    @JsonBackReference
    private Customer customer;

    @Column(name = "contact_number", nullable = false, length = 15)
    private String contactNumber;

    public CustomerContactNumber() {
    }

    public CustomerContactNumber(Integer id, Customer customer, String contactNumber) {
        this.id = id;
        this.customer = customer;
        this.contactNumber = contactNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "CustomerContactNumber{" +
                "id=" + id +
                ", customer=" + customer +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
