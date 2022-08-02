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
public class VoucherDAO extends MyDAO {

    public List<Voucher> getVoucherList() {
        List<Voucher> t = new ArrayList<Voucher>();
        xSql = "select * from Voucher";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xVouID;
            int xDiscount, xTotal, xStatus;
            Voucher x;
            while (rs.next()) {
                xVouID = rs.getString("vouID");
                xDiscount = rs.getInt("discount");
                xTotal = rs.getInt("total");
                xStatus = rs.getInt("status");
                x = new Voucher(xVouID, xDiscount, xTotal, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Voucher getVoucher(String xVouID) {
        Voucher x = null;
        xSql = "select * from Voucher where vouID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xVouID);
            rs = ps.executeQuery();
            int xDiscount, xTotal, xStatus;
            if (rs.next()) {
                xVouID = rs.getString("vouID");
                xDiscount = rs.getInt("discount");
                xTotal = rs.getInt("total");
                xStatus = rs.getInt("status");
                x = new Voucher(xVouID, xDiscount, xTotal, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void update(Voucher x) {
        xSql = "update Voucher set discount=?, total=?, status=? where vouID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getDiscount());
            ps.setInt(2, x.getTotal());
            ps.setInt(3, x.getStatus());
            ps.setString(4, x.getVouID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void delete(String xVouID) {
        xSql = "delete from Voucher where vouID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xVouID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Voucher x) {
        xSql = "insert into Voucher (vouID, discount, total, status) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getVouID());
            ps.setInt(2, x.getDiscount());
            ps.setInt(3, x.getTotal());
            ps.setInt(4, x.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
        VoucherDAO dao = new VoucherDAO();
//        Voucher x = dao.getVoucher("");
//        x.setStatus(0);
//        dao.update(x);
//        Voucher x = new Voucher("abc9", 5, 5, 0);
//        dao.insert(x);
//        dao.delete("abc9");
        List<Voucher> lst = dao.getVoucherList();
        for (Voucher o : lst) {
            System.out.println(o);
        }
//        System.out.println(x);
    }
}
