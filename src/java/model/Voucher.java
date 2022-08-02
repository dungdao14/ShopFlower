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
public class Voucher {

    private String vouID;
    private int discount, total, status;

    public Voucher(String vouID, int discount, int total, int status) {
        this.vouID = vouID;
        this.discount = discount;
        this.total = total;
        this.status = status;
    }

    public String getVouID() {
        return vouID;
    }

    public void setVouID(String vouID) {
        this.vouID = vouID;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voucher{" + "vouID=" + vouID + ", discount=" + discount + ", total=" + total + ", status=" + status + '}';
    }

}
