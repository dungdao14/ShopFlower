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
public class CustomerDAO extends MyDAO {

    public List<Customer> getCustomerList() {
        List<Customer> t = new ArrayList<Customer>();
        xSql = "select * from Customer";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xCusID, xStatus;
            String xCusName, xCusPhone, xCusAddress;
            Customer x;
            while (rs.next()) {
                xCusID = rs.getInt("cusID");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xStatus = rs.getInt("status");
                x = new Customer(xCusID, xCusName, xCusPhone, xCusAddress, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Customer getCustomer(int xCusID) {
        Customer x = null;
        xSql = "select * from Customer where cusID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xCusID);
            rs = ps.executeQuery();
            String xCusName, xCusPhone, xCusAddress;
            int xStatus;
            if (rs.next()) {
                xCusID = rs.getInt("cusID");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xStatus = rs.getInt("status");
                x = new Customer(xCusID, xCusName, xCusPhone, xCusAddress, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void update(Customer x) {
        xSql = "update Customer set cusName=?, cusPhone=?, cusAddress=?, status=? where cusID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getCusName());
            ps.setString(2, x.getCusPhone());
            ps.setString(3, x.getCusAddress());
            ps.setInt(4, x.getStatus());
            ps.setInt(5, x.getCusID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void delete(int xCusID) {
        xSql = "delete from Customer where cusID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xCusID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Customer x) {
        xSql = "insert into Customer (cusName, cusPhone, cusAddress, status) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getCusName());
            ps.setString(2, x.getCusPhone());
            ps.setString(3, x.getCusAddress());
            ps.setInt(4, x.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer getLast() {
        xSql = "select * from Customer where cusID = (select max(cusID) from Customer)";
        Customer x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xCusID, xStatus;
            String xCusName, xCusPhone, xCusAddress;
            if (rs.next()) {
                xCusID = rs.getInt("cusID");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xStatus = rs.getInt("status");
                x = new Customer(xCusID, xCusName, xCusPhone, xCusAddress, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
//        Customer x = dao.getCustomer(0);
//        Customer x = new Customer(0, "abc", "09797", "jfjhgcjhgc", 0);
//        x.setStatus(1);
//        dao.update(x);
//        dao.insert(x);
//        dao.delete(4);
//        List<Customer> list = dao.getCustomerList();
//        for (Customer o : list) {
//            System.out.println(o);
//        }
//        Customer x = dao.getLast();
//        System.out.println(x);
    }
}
