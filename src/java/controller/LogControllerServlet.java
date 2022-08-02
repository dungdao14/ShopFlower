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
import model.Account;
import model.AccountDAO;
import model.Customer;
import model.CustomerDAO;

/**
 *
 * @author Dinh Nam
 */
public class LogControllerServlet extends HttpServlet {

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
        try (PrintWriter pr = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("")) {
                response.sendRedirect("login.jsp");
            }

            if (action.equals("login")) {
                String xName = request.getParameter("username");
                String xPass = request.getParameter("password");

                Account a = null;
                AccountDAO v = new AccountDAO();

                a = v.getAccount(xName, xPass);
                request.getSession().setAttribute("currUser", a);

                if (a == null) {
                    request.setAttribute("mess", "Username or password is invalid!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    response.sendRedirect("homeController");
                }
            }

            if (action.equals("logout")) {
                request.getSession().setAttribute("currUser", null);
                response.sendRedirect("homeController");
            }

            if (action.equals("register")) {
                String xCusName = request.getParameter("cusName").trim();
                String xCusPhone = request.getParameter("cusPhone").trim();
                String xCusAddress = request.getParameter("cusAddress").trim();
                String xUsername = request.getParameter("username").trim();
                String xPassword = request.getParameter("password").trim();

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
                if (xUsername.length() == 0) {
                    pr.print("<h3> The username must not be empty!");
                    request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                    return;
                }
                if (xPassword.length() == 0) {
                    pr.print("<h3> The password must not be empty!");
                    request.getRequestDispatcher("updateCustomer.jsp").include(request, response);
                    return;
                }
                
                CustomerDAO c = new CustomerDAO();
                Customer cus = new Customer(0, xCusName, xCusPhone, xCusAddress, 1);
                c.insert(cus);
                Customer cus2 = c.getLast();
                
                AccountDAO a = new AccountDAO();
                Account acc = new Account(0, xUsername, xPassword, 2, cus2.getCusID());
                a.insert(acc);
                
                response.sendRedirect("login.jsp");
            }
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
