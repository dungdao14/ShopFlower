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
import javax.servlet.http.HttpSession;
import model.Product;
import model.ProductDAO;

/**
 *
 * @author Dinh Nam
 */
public class CheckCartServlet extends HttpServlet {

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
        String xProID = request.getParameter("proID").trim();

        HttpSession session = request.getSession();
            Object value = session.getAttribute(xProID);
        Product x = (Product) session.getAttribute(xProID);

        ProductDAO u = new ProductDAO();
        Product p = u.getProduct(xProID);

        if (action.equals("") || action == null) {
            response.sendRedirect("abc");
        }

        if (action.equals("sub")) {
            if (x.getQuantity() > 1) {
                x.setQuantity(x.getQuantity() - 1);
            }
            session.setAttribute(xProID, x);
            response.sendRedirect("showCart.jsp");
        }

        if (action.equals("add")) {
            if (x.getQuantity() < p.getQuantity()) {
                x.setQuantity(x.getQuantity() + 1);
            }
            session.setAttribute(xProID, x);
            response.sendRedirect("showCart.jsp");
        }

        if (action.equals("delete")) {
            session.removeAttribute(xProID);
            response.sendRedirect("showCart.jsp");
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
