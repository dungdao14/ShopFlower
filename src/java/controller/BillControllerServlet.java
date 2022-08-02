/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.BillDAO;

/**
 *
 * @author Dinh Nam
 */
public class BillControllerServlet extends HttpServlet {

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

        if (action.equals("")) {
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("delete")) {
            String sOrderID = request.getParameter("orderID").trim();
            int xOrderID = Integer.parseInt(sOrderID);
            BillDAO u = new BillDAO();
            u.delete(xOrderID);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("update")) {
            String sOrderID, sDateCreate, xCusName, xCusPhone, xCusAddress, sTotal, sCusID, xVouID;
            double xTotal = 0;
            int xCusID, xOrderID;
            Date xDateCreate;

            sOrderID = request.getParameter("orderID").trim();
            xOrderID = Integer.parseInt(sOrderID);
            sDateCreate = request.getParameter("dateCreate").trim();
            xDateCreate = Date.valueOf(sDateCreate);
            xCusName = request.getParameter("cusName");
            xCusPhone = request.getParameter("cusPhone").trim();
            xCusAddress = request.getParameter("cusAddress").trim();
            sTotal = request.getParameter("total").trim();
            xTotal = Double.parseDouble(sTotal);
            sCusID = request.getParameter("cusID").trim();
            xCusID = Integer.parseInt(sCusID);
            xVouID = request.getParameter("vouID").trim();

            BillDAO u = new BillDAO();
            Bill x = new Bill(xOrderID, xDateCreate, xCusName, xCusPhone, xCusAddress, xTotal, xCusID, xVouID);
            u.update(x);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("insert")) {
            String sDateCreate, xCusName, xCusPhone, xCusAddress, sTotal, sCusID, xVouID;
            double xTotal = 0;
            int xCusID, xOrderID = 0;
            Date xDateCreate = null;

            sDateCreate = request.getParameter("dateCreate").trim();
            xDateCreate = Date.valueOf(sDateCreate);
            xCusName = request.getParameter("cusName");
            xCusPhone = request.getParameter("cusPhone").trim();
            xCusAddress = request.getParameter("cusAddress").trim();
            sCusID = request.getParameter("cusID").trim();
            xCusID = Integer.parseInt(sCusID);
            xVouID = request.getParameter("vouID").trim();

            BillDAO u = new BillDAO();
            Bill x = null;

            if (xCusName.length() == 0) {
                pr.print("<h3> The customer's name must not be empty!");
                request.getRequestDispatcher("insertBill.jsp").include(request, response);
                return;
            }
            if (xCusPhone.length() == 0) {
                pr.print("<h3> The customer's phone number must not be empty!");
                request.getRequestDispatcher("insertBill.jsp").include(request, response);
                return;
            }
            if (xCusAddress.length() == 0) {
                pr.print("<h3> The customer's address must not be empty!");
                request.getRequestDispatcher("insertBill.jsp").include(request, response);
                return;
            }

            x = new Bill(xOrderID, xDateCreate, xCusName, xCusPhone, xCusAddress, xTotal, xCusID, xVouID);
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
