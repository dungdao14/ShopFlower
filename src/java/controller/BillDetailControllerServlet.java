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
import model.BillDetail;
import model.BillDetailDAO;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author Dinh Nam
 */
public class BillDetailControllerServlet extends HttpServlet {

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
        String action = request.getParameter("action");

        if (action == null || action.equals("")) {
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("delete")) {
            String xProID = request.getParameter("proID").trim();
            String sOrderID = request.getParameter("orderID").trim();
            int xOrderID = Integer.parseInt(sOrderID);
            BillDetailDAO u = new BillDetailDAO();
            u.delete(xProID, xOrderID);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("update")) {
            String xProID, sOrderID, sQuantity, sPrice, sTotal;
            int xQuantity, xOrderID;
            double xPrice, xTotal;

            xProID = request.getParameter("proID");
            sOrderID = request.getParameter("orderID").trim();
            xOrderID = Integer.parseInt(sOrderID);
            sQuantity = request.getParameter("quantity");
            xQuantity = Integer.parseInt(sQuantity);
            sPrice = request.getParameter("price");
            xPrice = Double.parseDouble(sPrice);
            sTotal = request.getParameter("amount");
            xTotal = Double.parseDouble(sTotal);

            BillDetailDAO u = new BillDetailDAO();
            BillDetail x = new BillDetail(xProID, xOrderID, xQuantity, xPrice, xTotal);
            u.update(x);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("insert")) {
            String xProID, sOrderID, sQuantity;
            int xQuantity, xOrderID;
            double xPrice, xTotal;

            xProID = request.getParameter("proID");
            sOrderID = request.getParameter("orderID").trim();
            xOrderID = Integer.parseInt(sOrderID);
            sQuantity = request.getParameter("quantity");
            xQuantity = Integer.parseInt(sQuantity);
            
            ProductDAO p = new ProductDAO();
            Product pro = p.getProduct(xProID);
            
            xPrice = pro.getPrice();
            xTotal = xQuantity * xPrice;

            BillDetailDAO u = new BillDetailDAO();
            BillDetail x = new BillDetail(xProID, xOrderID, xQuantity, xPrice, xTotal);
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
