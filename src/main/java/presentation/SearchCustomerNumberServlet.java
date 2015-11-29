package presentation;

import business.Logic;

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
        response.getWriter().write(Logic.searchCustomerNumberLogic(customerNumber));
    }
}