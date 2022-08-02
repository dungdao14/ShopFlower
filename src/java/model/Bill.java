/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Dinh Nam
 */
public class Bill {

    private int orderID;
    private Date dateCreate;
    private String cusName, cusPhone, cusAddress;
    private double total;
    private int cusID;
    private String vouID;

    public Bill(int billID, Date dateCreate, String cusName, String cusPhone, String cusAddress, double total, int cusID, String vouID) {
        this.orderID = billID;
        this.dateCreate = dateCreate;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.total = total;
        this.cusID = cusID;
        this.vouID = vouID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getVouID() {
        return vouID;
    }

    public void setVouID(String vouID) {
        this.vouID = vouID;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + orderID + ", dateCreate=" + dateCreate + ", cusName=" + cusName + ", cusPhone=" + cusPhone + ", cusAddress=" + cusAddress + ", total=" + total + ", cusID=" + cusID + ", vouID=" + vouID + '}';
    }

}
