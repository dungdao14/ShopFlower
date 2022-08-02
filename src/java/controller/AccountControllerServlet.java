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

/**
 *
 * @author Dinh Nam
 */
public class AccountControllerServlet extends HttpServlet {

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

        if (action.equals("update")) {
            String sAccID, xUsername, xPassword, sRole, sCusID;
            int xAccID, xRole, xCusID;
            
            sAccID = request.getParameter("accID").trim();
            xAccID = Integer.parseInt(sAccID);
            xUsername = request.getParameter("username").trim();
            xPassword = request.getParameter("password").trim();
            sRole = request.getParameter("role").trim();
            xRole = Integer.parseInt(sRole);
            sCusID = request.getParameter("cusID").trim();
            xCusID = Integer.parseInt(sCusID);

            AccountDAO u = new AccountDAO();
            Account x = null;

            if (xUsername.length() == 0) {
                pr.print("<h3> The username must not be empty!");
                request.getRequestDispatcher("updateAccount.jsp").include(request, response);
                return;
            }
            if (xPassword.length() == 0) {
                pr.print("<h3> The password must not be empty!");
                request.getRequestDispatcher("updateAccount.jsp").include(request, response);
                return;
            }
            x = new Account(xAccID, xUsername, xPassword, xRole, xCusID);
            u.update(x);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("delete")) {
            String sAccID;
            int xAccID;
            sAccID = request.getParameter("accID").trim();
            xAccID = Integer.parseInt(sAccID);

            AccountDAO u = new AccountDAO();
            Account x = u.getAccount(xAccID);
            u.delete(xAccID);
            response.sendRedirect("adminView.jsp");
        }

        if (action.equals("insert")) {
            String xUsername, xPassword, sRole, sCusID;
            int xAccID = 0, xRole, xCusID;
            
            xUsername = request.getParameter("username").trim();
            xPassword = request.getParameter("password").trim();
            sRole = request.getParameter("role").trim();
            xRole = Integer.parseInt(sRole);
            sCusID = request.getParameter("cusID").trim();
            xCusID = Integer.parseInt(sCusID);

            AccountDAO u = new AccountDAO();
            Account x = null;

            if (xUsername.length() == 0) {
                pr.print("<h3> The username must not be empty!");
                request.getRequestDispatcher("updateAccount.jsp").include(request, response);
                return;
            }

            if (xPassword.length() == 0) {
                pr.print("<h3> The password must not be empty!");
                request.getRequestDispatcher("updateAccount.jsp").include(request, response);
                return;
            }

            x = new Account(xAccID, xUsername, xPassword, xRole, xCusID);
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
