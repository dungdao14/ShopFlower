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
public class Product {

    private String proID, proName;
    private int quantity;
    private double price;
    private String image, cateID;

    public Product(String proID, String proName, int quantity, double price, String image, String cateID) {
        this.proID = proID;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.cateID = cateID;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    @Override
    public String toString() {
        return "Product{" + "proID=" + proID + ", proName=" + proName + ", quantity=" + quantity + ", price=" + price + ", image=" + image + ", cateID=" + cateID + '}';
    }

}
