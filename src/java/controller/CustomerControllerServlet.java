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
import model.Customer;
import model.CustomerDAO;

/**
 *
 * @author Dinh Nam
 */
public class CustomerControllerServlet extends HttpServlet {

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
            String xCusID = request.getParameter("cusID").trim();
            CustomerDAO u = new CustomerDAO();
            int sCusID = Integer.parseInt(xCusID);
            u.delete(sCusID);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("update")) {
            String sCusID, xCusName, xCusPhone, xCusAddress, sStatus;
            int xCusID = 0, xStatus = 0;

            sCusID = request.getParameter("cusID").trim();
            xCusID = Integer.parseInt(sCusID);
            xCusName = request.getParameter("cusName").trim();
            xCusPhone = request.getParameter("cusPhone").trim();
            xCusAddress = request.getParameter("cusAddress").trim();
            sStatus = request.getParameter("status").trim();
            xStatus = Integer.parseInt(sStatus);

            CustomerDAO u = new CustomerDAO();
            Customer x = null;

            if (xCusName.length() == 0) {
                pr.print("<h3> The customer's name must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            if (xCusPhone.length() == 0) {
                pr.print("<h3> The customer's phone number must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            if (xCusAddress.length() == 0) {
                pr.print("<h3> The customer's address must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            x = new Customer(xCusID, xCusName, xCusPhone, xCusAddress, xStatus);
            u.update(x);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("insert")) {
            String xCusName, xCusPhone, xCusAddress;
            int xCusID = 0, xStatus = 0;

            xCusName = request.getParameter("cusName").trim();
            xCusPhone = request.getParameter("cusPhone").trim();
            xCusAddress = request.getParameter("cusAddress").trim();

            CustomerDAO u = new CustomerDAO();
            Customer x;

            if (xCusName.length() == 0) {
                pr.print("<h3> The customer's name must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            if (xCusPhone.length() == 0) {
                pr.print("<h3> The customer's phone number must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            if (xCusAddress.length() == 0) {
                pr.print("<h3> The customer's address must not be empty!");
                request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                return;
            }
            x = new Customer(xCusID, xCusName, xCusPhone, xCusAddress, xStatus);
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
