package presentation;

import business.Logic;

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

        String customerNumber = request.getParameter("customerNumber");
        String typeName = request.getParameter("typeName");
        String duration = request.getParameter("duration");
        String amount = request.getParameter("amount");
        System.out.println(customerNumber + " " + typeName + " " + duration + " " + amount);


        out.print("<html>" +
                "<head>" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"Theme.css\" media=\"screen\"/>" +
                "    <title></title>" +
                "</head>" +
                "" +
                "<body>" +
                "<h1>Dotin Internet Bank</h1>" +
                "<h3>Real Customer</h3>" +
                "<h3>" + Logic.loanFileExistenceLogic(typeName, duration, amount, customerNumber) + "</h3>" +
                "</body>");
    }
}
