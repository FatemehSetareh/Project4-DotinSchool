package presentation;

import business.logic.LoanFileLogic;
import business.logic.LoanTypeLogic;

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
            if (LoanTypeLogic.insertLoanTypeLogic(typeName, interestRate).equals("Ok")) {
                String[] grantConditions = concatedGrantConditions.split("&");
                for (String grantCondition : grantConditions) {
                    String[] grantConditionElements = grantCondition.split("#");
                    String conditionName = grantConditionElements[0];
                    System.out.println(conditionName);
                    String minDuration = grantConditionElements[1];
                    System.out.println(minDuration);
                    String maxDuration = grantConditionElements[2];
                    System.out.println(maxDuration);
                    String minAmount = grantConditionElements[3];
                    System.out.println(minAmount);
                    String maxAmount = grantConditionElements[4];
                    System.out.println(maxAmount);
                    LoanFileLogic.insertGrantConditionLogic(typeName, conditionName, minDuration, maxDuration, minAmount, maxAmount);
                }

                response.sendRedirect("welcome-page.jsp");
            } else out.print(LoanTypeLogic.insertLoanTypeLogic(typeName, interestRate));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}



