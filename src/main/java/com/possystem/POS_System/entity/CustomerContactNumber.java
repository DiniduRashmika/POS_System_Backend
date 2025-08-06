package com.possystem.POS_System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer_contact_numbers")
public class CustomerContactNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "contact_number", nullable = false, length = 15)
    private String contactNumber;

//    public CustomerContactNumber() {
//    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
