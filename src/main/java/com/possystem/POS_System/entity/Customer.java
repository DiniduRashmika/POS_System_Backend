package com.possystem.POS_System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "active_state")
    private Byte activeState;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Column(name = "customer_name", length = 100)
    private String customerName;

    @Column(name = "customer_salary",  length = 100)
    private Double customerSalary;

    @Column(name = "nic")
    private String nic;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerContactNumber> customerContactNumbers = new LinkedHashSet<>();

    public Customer()  {
    }

    public Customer(Integer id, Byte activeState, String customerAddress, String customerName, Double customerSalary, String nic, Set<CustomerContactNumber> customerContactNumbers) {
        this.id = id;
        this.activeState = activeState;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.customerContactNumbers = customerContactNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getActiveState() {
        return activeState;
    }

    public void setActiveState(Byte activeState) {
        this.activeState = activeState;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Set<CustomerContactNumber> getCustomerContactNumbers() {
        return customerContactNumbers;
    }

    public void setCustomerContactNumbers(Set<CustomerContactNumber> customerContactNumbers) {
        this.customerContactNumbers = customerContactNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", activeState=" + activeState +
                ", customerAddress=" + customerAddress +
                ", customerName='" + customerName + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", customerContactNumbers=" + customerContactNumbers +
                '}';
    }
}