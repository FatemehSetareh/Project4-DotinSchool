package presentation;

import business.logic.LoanFileLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DefineNewGrantConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String typeName = request.getParameter("typeName");
        String interestRate = request.getParameter("interestRate");
        System.out.println(typeName + " " + interestRate);

        String concatedGrantConditions = request.getParameter("concatedGrantConditions");
        System.out.println(concatedGrantConditions);

        try {
            request.setAttribute("output", LoanFileLogic.insertGrantConditionLogic(concatedGrantConditions, typeName, interestRate));
            request.getRequestDispatcher("define-new-grant-condition-page.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}



