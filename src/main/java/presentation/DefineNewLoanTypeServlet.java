package presentation;

import business.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DefineNewLoanTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String typeName = request.getParameter("typeName");
        String interestRate = request.getParameter("interestRate");

        try {
            out.print("<html>" +
                    "<head>" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"Theme.css\" media=\"screen\"/>" +
                    "    <title></title>" +
                    "</head>" +
                    "" +
                    "<body>" +
                    "<h1>Dotin Internet Bank</h1>" +
                    "<h3>Real Customer</h3>" +
                    "<h3>" +  Logic.insertLoanTypeLogic(typeName, interestRate) + "</h3>" +
                    "</body>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
