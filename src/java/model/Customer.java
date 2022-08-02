/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dinh Nam
 */
public class Customer {

    private int cusID;
    private String cusName, cusPhone, cusAddress;
    private int status;

    public Customer(int cusID, String cusName, String cusPhone, String cusAddress, int status) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.status = status;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusID=" + cusID + ", cusName=" + cusName + ", cusPhone=" + cusPhone + ", cusAddress=" + cusAddress + ", status=" + status + '}';
    }

}
