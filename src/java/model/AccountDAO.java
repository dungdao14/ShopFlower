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
public class AccountDAO extends MyDAO {

    public List<Account> getAccountList() {
        List<Account> t = new ArrayList<Account>();
        xSql = "select * from Account";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xAccID;
            String xUsername, xPassword;
            int xRole, xCusID;
            Account x;
            while (rs.next()) {
                xAccID = rs.getInt("accountID");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                xRole = rs.getInt("role");
                xCusID = rs.getInt("cusID");
                x = new Account(xAccID, xUsername, xPassword, xRole, xCusID);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Account getAccount(int xAccID) {
        Account x = null;
        xSql = "select * from Account where accountID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xAccID);
            rs = ps.executeQuery();
            String xUsername, xPassword;
            int xRole, xCusID;
            if (rs.next()) {
                xAccID = rs.getInt("accountID");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                xRole = rs.getInt("role");
                xCusID = rs.getInt("cusID");
                x = new Account(xAccID, xUsername, xPassword, xRole, xCusID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public Account getAccount(String xUsername, String xPassword) {
        Account x = null;
        xSql = "select * from Account where (username = ? and password = ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUsername);
            ps.setString(2, xPassword);
            rs = ps.executeQuery();
            int xAccID, xRole, xCusID;
            if (rs.next()) {
                xAccID = rs.getInt("accountID");
                xUsername = rs.getString("username");
                xPassword = rs.getString("password");
                xRole = rs.getInt("role");
                xCusID = rs.getInt("cusID");
                x = new Account(xAccID, xUsername, xPassword, xRole, xCusID);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void update(Account x) {
        xSql = "update Account set username=?, password=? where accountID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getUsername());
            ps.setString(2, x.getPassword());
            ps.setInt(3, x.getAccID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void delete(int xAccID) {
        xSql = "delete from Account where accountID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xAccID);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Account x) {
        xSql = "insert into Account (username, password, role, cusID) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getUsername());
            ps.setString(2, x.getPassword());
            ps.setInt(3, x.getRole());
            ps.setInt(4, x.getCusID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
//        Account x = new Account(7, "abc", "a0989999999", 1, 3);
//        dao.insert(x);
//        Account x = dao.getAccount(10);
//        dao.delete(10);

        List<Account> lst = dao.getAccountList();
        for (Account o : lst) {
            System.out.println(o);
        }
//        x.setPassword("12345678");
//        dao.update(x);
//        System.out.println(x);
    }
}
