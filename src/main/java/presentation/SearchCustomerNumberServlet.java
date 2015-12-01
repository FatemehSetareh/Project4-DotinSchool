package presentation;

import business.logic.RealCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchCustomerNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String customerNumber = request.getParameter("customerNumber");
        System.out.println(customerNumber);
        RealCustomerLogic.searchCustomerNumberLogic(customerNumber);
        response.sendRedirect("welcome-page.jsp");
    }
}
