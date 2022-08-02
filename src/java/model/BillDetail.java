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
public class BillDetail {

    private String proID;
    private int orderID, quantity;
    private double price, amount;

    public BillDetail(String proID, int orderID, int quantity, double price, double amount) {
        this.proID = proID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "proID=" + proID + ", orderID=" + orderID + ", quantity=" + quantity + ", price=" + price + ", amount=" + amount + '}';
    }

}
