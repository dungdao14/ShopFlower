/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;
import model.BillDAO;
import model.BillDetail;
import model.BillDetailDAO;
import model.Customer;
import model.CustomerDAO;
import model.Product;

/**
 *
 * @author Dinh Nam
 */
public class CheckoutServlet extends HttpServlet {

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
            String xCusName = request.getParameter("cusName");
            String xCusPhone = request.getParameter("cusPhone");
            String xCusAddress = request.getParameter("cusAddress");

            Date date = new Date(2022, 03, 04);

            CustomerDAO c = new CustomerDAO();
            Customer cus;
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("currUser");

            if (acc == null) {
                Customer cus2 = new Customer(0, xCusName, xCusPhone, xCusAddress, 0);
                c.insert(cus2);
                cus = c.getLast();
            } else {
                cus = c.getCustomer(acc.getCusID());
            }
            int xCusID = cus.getCusID();

            BillDAO bill = new BillDAO();
            Bill xBill = new Bill(0, date, xCusName, xCusPhone, xCusAddress, 0, xCusID, "");
            bill.insert(xBill);

            BillDetailDAO billDetail = new BillDetailDAO();

            java.util.Enumeration en = session.getAttributeNames();
            while (en.hasMoreElements()) {
                Bill b = bill.getLast();
                String xPrID = en.nextElement().toString();
                if (!xPrID.equals("currUser")) {
                    Product pro = (Product) session.getAttribute(xPrID);
                    BillDetail bd = new BillDetail(pro.getProID(), b.getOrderID(), pro.getQuantity(), pro.getPrice(), 0);
                    billDetail.insert(bd);
                    session.removeAttribute(xPrID);
                }
            }
            response.sendRedirect("homeController");
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
