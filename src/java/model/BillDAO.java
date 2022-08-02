/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh Nam
 */
public class BillDAO extends MyDAO {
    public List<Bill> getBillList() {
        List<Bill> t = new ArrayList<Bill>();
        xSql = "select * from Bill";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xOrderID;
            String xCusName, xCusPhone, xCusAddress, xVouID;
            Date xDateCreate;
            double xTotal;
            int xCusID;
            Bill x;
            while (rs.next()) {
                xOrderID = rs.getInt("orderID");
                xDateCreate = rs.getDate("dateCreate");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xTotal = rs.getDouble("total");
                xCusID = rs.getInt("cusID");
                xVouID = rs.getString("vouID");
                x = new Bill(xOrderID, xDateCreate, xCusName, xCusPhone, xCusAddress, xTotal, xCusID, xVouID);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public Bill getBill(int xOrderID) {
        Bill x = null;
        xSql = "select * from Bill where orderID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xOrderID);
            rs = ps.executeQuery();
            String xCusName, xCusPhone, xCusAddress, xVouID;
            Date xDateCreate;
            double xTotal;
            int xCusID;
            if (rs.next()) {
                xOrderID = rs.getInt("orderID");
                xDateCreate = rs.getDate("dateCreate");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xTotal = rs.getDouble("total");
                xCusID = rs.getInt("cusID");
                xVouID = rs.getString("vouID");
                x = new Bill(xOrderID, xDateCreate, xCusName, xCusPhone, xCusAddress, xTotal, xCusID, xVouID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public void update(Bill x) {
        xSql = "update Bill set cusName=?, cusPhone=?, cusAddress=?, vouID=? where orderID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getCusName());
            ps.setString(2, x.getCusPhone());
            ps.setString(3, x.getCusAddress());
            ps.setString(4, x.getVouID());
            ps.setInt(5, x.getOrderID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    
    public void delete(int xOrderID) {
        xSql = "delete from Bill where orderID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xOrderID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insert(Bill x) {
        xSql = "insert into Bill (cusName, cusPhone, cusAddress, total, cusID, vouID) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
//            ps.setInt(1, x.getOrderID());
//            ps.setDate(2, (java.sql.Date) x.getDateCreate());
            ps.setString(1, x.getCusName());
            ps.setString(2, x.getCusPhone());
            ps.setString(3, x.getCusAddress());
            ps.setDouble(4, x.getTotal());
            ps.setInt(5, x.getCusID());
            ps.setString(6, x.getVouID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Bill getLast(){
        xSql = "select * from Bill where orderID = (select max(orderID) from Bill)";
        Bill x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xCusName, xCusPhone, xCusAddress, xVouID;
            Date xDateCreate;
            double xTotal;
            int xOrderID, xCusID;
            if (rs.next()) {
                xOrderID = rs.getInt("orderID");
                xDateCreate = rs.getDate("dateCreate");
                xCusName = rs.getString("cusName");
                xCusPhone = rs.getString("cusPhone");
                xCusAddress = rs.getString("cusAddress");
                xTotal = rs.getDouble("total");
                xCusID = rs.getInt("cusID");
                xVouID = rs.getString("vouID");
                x = new Bill(xOrderID, xDateCreate, xCusName, xCusPhone, xCusAddress, xTotal, xCusID, xVouID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public static void main(String[] args) {
        BillDAO dao = new BillDAO();
//        Bill x = new Bill(4, new Date(2022, 03, 04), "abc", "09876", "jhgfjhg", 200, 3, "");
//        dao.insert(x);
//        Bill x = dao.getBill(4);
//        x.setCusPhone("12345678901");
//        dao.update(x);
//        dao.delete(4);
//        List<Bill> list = dao.getBillList();
//         for (Bill o : list) {
//            System.out.println(o);
//        } 
//        Bill x = dao.getBill(1);
            Bill x = dao.getLast();
        System.out.println(x);
    }
}
