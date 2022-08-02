/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh Nam
 */
public class ProductDAO extends MyDAO {

    public List<Product> getProductList() {
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xProID, xProName, xImage, xCateID;
            int xQuantity, xPrice;
            Product x;
            while (rs.next()) {
                xProID = rs.getString("proID");
                xProName = rs.getString("proName");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getInt("price");
                xImage = rs.getString("image");
                xCateID = rs.getString("cateID");
                x = new Product(xProID, xProName, xQuantity, xPrice, xImage, xCateID);
                
                    
                t.add(x);
                
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Product getProduct(String xProID) {
        if (xProID == null || xProID.trim().equals("")) {
            return (null);
        }
        Product x = null;
        xSql = "select * from Product where proID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xProID);
            rs = ps.executeQuery();
            String xProName, xImage, xCateID;
            int xQuantity, xPrice;
            if (rs.next()) {
                xProID = rs.getString("proID");
                xProName = rs.getString("proName");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getInt("price");
                xImage = rs.getString("image");
                xCateID = rs.getString("cateID");
                x = new Product(xProID, xProName, xQuantity, xPrice, xImage, xCateID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Product> getProductIDList(String xCateID) {
        List<Product> t = new ArrayList<Product>();
        xSql = "select * from Product where cateID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xCateID);
            rs = ps.executeQuery();
            String xProID, xProName, xImage;
            int xQuantity, xPrice;
            Product x;
            while (rs.next()) {
                xProID = rs.getString("proID");
                xProName = rs.getString("proName");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getInt("price");
                xImage = rs.getString("image");
                xCateID = rs.getString("cateID");
                x = new Product(xProID, xProName, xQuantity, xPrice, xImage, xCateID);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void update(Product x) {
        xSql = "update Product set proName=?, quantity=?, price=?, image=?, cateID=? where proID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getProName());
            ps.setInt(2, x.getQuantity());
            ps.setDouble(3, x.getPrice());
            ps.setString(4, x.getImage());
            ps.setString(5, x.getCateID());
            ps.setString(6, x.getProID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void delete(String xProID) {
        xSql = "delete from Product where proID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xProID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Product x) {
        xSql = "insert into Product (proID, proName, quantity, price, image, cateID) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getProID());
            ps.setString(2, x.getProName());
            ps.setInt(3, x.getQuantity());
            ps.setDouble(4, x.getPrice());
            ps.setString(5, x.getImage());
            ps.setString(6, x.getCateID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        List<Product> list = dao.getProductList();
//        List<Product> list = dao.getProductIDList("AN");
//        List<Product> list = dao.getProductIDList("AN");
//        Product x = dao.getProduct("P01");
//        x.setQuantity(x.getQuantity() + 1);
//        x.setProID("P16");
//        dao.update(x);
//        dao.insert(x);
//        dao.delete("P16");
        List<Product> list = dao.getProductList();
         for (Product o : list) {
            System.out.println(o);
        } 
//        System.out.println(x);
    }
}
