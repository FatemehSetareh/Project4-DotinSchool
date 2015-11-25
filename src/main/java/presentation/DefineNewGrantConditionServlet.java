package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DefineNewGrantConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String grantConditions[] = request.getParameterValues("grantConditions");
//        String conditionName = request.getParameter("conditionName");
//        String minDuration = request.getParameter("minDuration");
//        String maxDuration = request.getParameter("maxDuration");
//        String minAmount = request.getParameter("minAmount");
//        String maxAmount = request.getParameter("maxAmount");
//
//        System.out.println(conditionName + minDuration + maxDuration + minAmount + maxAmount);
//        if (Logic.insertGrantConditionLogic(conditionName, minDuration, maxDuration, minAmount, maxAmount)) {
//
//        } else {
//            out.print(Logic.getGrantConditionStatus());
//        }

        System.out.println(grantConditions);
    }
}
