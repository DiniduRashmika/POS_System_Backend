package com.possystem.POS_System.dto.request;

public class CustomerUpdateDTO {
    private Integer id;
    private Boolean activeState;
    private String customerAddress;
    private String customerName;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(Integer id, Boolean activeState, String customerAddress, String customerName) {
        this.id = id;
        this.activeState = activeState;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActiveState() {
        return activeState;
    }

    public void setActiveState(Boolean activeState) {
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

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "id=" + id +
                ", activeState=" + activeState +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}


