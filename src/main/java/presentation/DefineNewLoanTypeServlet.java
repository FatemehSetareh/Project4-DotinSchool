package presentation;

import business.Logic;
import persistence.Crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DefineNewLoanTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String typeName = request.getParameter("typeName");
        String interestRate = request.getParameter("interestRate");
        try {
            Logic.insertLoanTypeLogic(typeName, interestRate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print("<html>" +
                "<head>" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"Theme.css\" media=\"screen\"/>" +
                "    <title></title>" +
                "</head>" +
                "" +
                "<body>" +
                "<h1>Dotin Internet Bank</h1>" +
                "<h3>Real Customer</h3>" +
                "<h3>" + Crud.getLoanTypeInsertionMsg() + "</h3>" +
                "</body>");

    }
}
