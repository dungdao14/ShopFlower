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
public class BillDetailDAO extends MyDAO {

    public List<BillDetail> getBillDetailList() {
        List<BillDetail> t = new ArrayList<BillDetail>();
        xSql = "select * from BillDetail";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xProID;
            int xQuantity, xOrderID;
            double xPrice, xAmount;
            BillDetail x;
            while (rs.next()) {
                xProID = rs.getString("proID");
                xOrderID = rs.getInt("orderID");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                xAmount = rs.getDouble("amount");
                x = new BillDetail(xProID, xOrderID, xQuantity, xPrice, xAmount);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public BillDetail getBillDetail(String xProID, int xOrderID) {
        if (xProID == null || xProID.trim().equals("")) {
            return (null);
        }
        BillDetail x = null;
        xSql = "select * from BillDetail where (proID = ? and orderID = ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xProID);
            ps.setInt(2, xOrderID);
            rs = ps.executeQuery();
            int xQuantity;
            double xPrice, xAmount;
            if (rs.next()) {
                xProID = rs.getString("proID");
                xOrderID = rs.getInt("orderID");
                xQuantity = rs.getInt("quantity");
                xPrice = rs.getDouble("price");
                xAmount = rs.getDouble("amount");
                x = new BillDetail(xProID, xOrderID, xQuantity, xPrice, xAmount);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public void delete(String xProID, int xOrderID) {
        xSql = "delete from BillDetail where (proID = ? and orderID=?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xProID);
            ps.setInt(2, xOrderID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(BillDetail x) {
        xSql = "update BillDetail set quantity=?, price = ? where (proID = ? and orderID=?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getQuantity());
            ps.setDouble(2, x.getPrice());
            ps.setString(3, x.getProID());
            ps.setInt(4, x.getOrderID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    
    public void insert(BillDetail x) {
        xSql = "insert into BillDetail (proID, orderID, quantity, price) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getProID());
            ps.setInt(2, x.getOrderID());
            ps.setInt(3, x.getQuantity());
            ps.setDouble(4, x.getPrice());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        BillDetailDAO dao = new BillDetailDAO();
//        BillDetail x = new BillDetail("P07", 2, 2, 250, 500);
//        dao.insert(x);
//        dao.delete("P07", 2);
//        BillDetail x = dao.getBillDetail("P03", 1);
//        x.setQuantity(x.getQuantity() - 1);
//        dao.update(x);
        List <BillDetail> list = dao.getBillDetailList();

        for(BillDetail o : list){
            System.out.println(o);
        }
//        System.out.println(x);
    }
}
