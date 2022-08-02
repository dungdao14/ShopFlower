/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.CategoryDAO;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author Dinh Nam
 */
public class ProductControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String action = request.getParameter("action").trim();

        if (action.equals("")) {
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("update")) {

            String xProID, xProName, xImage, xCateID, sQuantity, sPrice;
            int xQuantity = 0;
            double xPrice = 0;

            xProID = request.getParameter("proID").trim();
            xProName = request.getParameter("proName").trim();
            sQuantity = request.getParameter("quantity").trim();
            xQuantity = Integer.parseInt(sQuantity);
            sPrice = request.getParameter("price").trim();
            xPrice = Double.parseDouble(sPrice);
            xImage = request.getParameter("image").trim();

            xCateID = request.getParameter("cateID").trim();
            ProductDAO u = new ProductDAO();
            Product x = u.getProduct(xProID);

            if (xProName.length() == 0) {
                pr.print("<h3> The product name must not be empty!");
                request.getRequestDispatcher("updateProduct.jsp").include(request, response);
                return;
            }
            x = new Product(xProID, xProName, xQuantity, xPrice, xImage, xCateID);
            u.update(x);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("delete")) {
            String xProID = request.getParameter("proID").trim();
            ProductDAO u = new ProductDAO();
            u.delete(xProID);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("insert")) {
            String xProID, xProName, xImage, xCateID, sQuantity, sPrice;
            int xQuantity = 0;
            double xPrice = 0;

            xProID = request.getParameter("proID").trim();
            if (xProID.length() == 0) {
                pr.print("<h3> The id must not be empty!");
                request.getRequestDispatcher("insertProduct.jsp").include(request, response);
                return;
            }
            ProductDAO u = new ProductDAO();
            Product x = u.getProduct(xProID);
            if (x != null) {
                pr.print("<h3> The id " + xProID + " already exists!");
                request.getRequestDispatcher("insertProduct.jsp").include(request, response);
                return;
            }

            xCateID = request.getParameter("cateID").trim();

            xProName = request.getParameter("proName").trim();
            if (xProName.length() == 0) {
                pr.print("<h3> The name cannot be empty!");
                request.getRequestDispatcher("insertProduct.jsp").include(request, response);
                return;
            }

            sQuantity = request.getParameter("quantity").trim();
            if (sQuantity.length() == 0) {
                xQuantity = 0;
            } else {
                xQuantity = Integer.parseInt(sQuantity);
            }

            sPrice = request.getParameter("price").trim();
            if (sPrice.length() == 0) {
                xPrice = 0;
            } else {
                xPrice = Double.parseDouble(sPrice);
            }

            xImage = request.getParameter("image").trim();
            
            if (xCateID.equals("RO") && xProName.equals("X")) {
                xQuantity = 1000;
            }
            x = new Product(xProID, xProName, xQuantity, xPrice, xImage, xCateID);
            u.insert(x);
            response.sendRedirect("adminView.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
