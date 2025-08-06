package com.possystem.POS_System.dto;

import com.possystem.POS_System.entity.CustomerContactNumber;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomerDTO {
    private Integer id;
    private Byte activeState;
    private String customerAddress;
    private String customerName;
    private Double customerSalary;
    private String nic;
    private Set<CustomerContactNumber> customerContactNumbers = new LinkedHashSet<>();

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, Byte activeState, String customerAddress, String customerName, Double customerSalary, String nic, Set<CustomerContactNumber> customerContactNumbers) {
        this.id = id;
        this.activeState = activeState;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.customerContactNumbers = customerContactNumbers;
    }

    public Set<CustomerContactNumber> getCustomerContactNumbers() {
        return customerContactNumbers;
    }

    public void setCustomerContactNumbers(Set<CustomerContactNumber> customerContactNumbers) {
        this.customerContactNumbers = customerContactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Byte getActiveState() {
        return activeState;
    }

    public void setActiveState(Byte activeState) {
        this.activeState = activeState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
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
