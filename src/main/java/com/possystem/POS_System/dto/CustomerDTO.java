package com.possystem.POS_System.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO {
    private Integer id;
    private Boolean activeState;
    private String customerAddress;
    private String customerName;
    private Double customerSalary;
    private String nic;
    private List<CustomerContactNumberDTO> customerContactNumbers = new ArrayList();

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, Boolean activeState, String customerAddress, String customerName, Double customerSalary, String nic, List<CustomerContactNumberDTO> customerContactNumbers) {
        this.id = id;
        this.activeState = activeState;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.customerContactNumbers = customerContactNumbers;
    }


//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Boolean getActiveState() {
//        return activeState;
//    }
//
//    public void setActiveState(Boolean activeState) {
//        this.activeState = activeState;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public Double getCustomerSalary() {
//        return customerSalary;
//    }
//
//    public void setCustomerSalary(Double customerSalary) {
//        this.customerSalary = customerSalary;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    public List<CustomerContactNumberDTO> getCustomerContactNumberDTOs() {
//        return customerContactNumbers;
//    }
//
//    public void setCustomerContactNumberDTOs(List<CustomerContactNumberDTO> customerContactNumbers) {
//        this.customerContactNumbers = customerContactNumbers;
//    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", activeState=" + activeState +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                //", customerContactNumbers=" + customerContactNumbers +
                '}';
    }
}
