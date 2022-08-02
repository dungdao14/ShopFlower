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
public class CategoryDAO extends MyDAO {

    public List<Category> getCategoryList() {
        List<Category> t = new ArrayList<Category>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xCateID, xCateName;
            Category x;
            while (rs.next()) {
                xCateID = rs.getString("cateID");
                xCateName = rs.getString("cateName");
                x = new Category(xCateID, xCateName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public Category getCategory(String xCateID) {
        if (xCateID == null || xCateID.trim().equals("")) {
            return (null);
        }
        Category x = null;
        xSql = "select * from Category where cateID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xCateID);
            rs = ps.executeQuery();
            String xCateName;
            if (rs.next()) {
                xCateID = rs.getString("cateID");
                xCateName = rs.getString("cateName");
                x = new Category(xCateID, xCateName);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
//        List<Category> list = dao.getCategoryList();
//         for (Category o : list) {
//            System.out.println(o);
//        } 
        Category x = dao.getCategory("AN");
        System.out.println(x);
    }
}
