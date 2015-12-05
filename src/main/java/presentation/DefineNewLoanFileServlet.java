package presentation;

import business.logic.LoanFileLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DefineNewLoanFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String customerNumber = request.getParameter("customerNumber1");
        String typeName = request.getParameter("typeName");
        String duration = request.getParameter("duration");
        String amount = request.getParameter("amount");

        System.out.println(customerNumber + " " + typeName + " " + duration + " " + amount);

        request.setAttribute("output", LoanFileLogic.insertNewLoanFileLogic(typeName, duration, amount, customerNumber));
        request.getRequestDispatcher("define-new-loan-file-page.jsp").forward(request, response);
    }
}
