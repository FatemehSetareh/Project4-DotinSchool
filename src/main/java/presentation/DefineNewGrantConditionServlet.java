package presentation;

import business.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DefineNewGrantConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String typeName = request.getParameter("typeName");
        System.out.println(typeName);

        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println(parameterNames);
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            System.out.println(paramValues);
            for (int i = 0; i < paramValues.length; i++) {
                String conditionName = paramValues[i];
                System.out.println(conditionName);
                String minDuration = paramValues[i += 1];
                System.out.println(minDuration);
                String maxDuration = paramValues[i += 2];
                System.out.println(maxDuration);
                String minAmount = paramValues[i += 3];
                System.out.println(minAmount);
                String maxAmount = paramValues[i += 4];
                System.out.println(maxAmount);
                Logic.insertGrantConditionLogic(typeName, conditionName, minDuration, maxDuration, minAmount, maxAmount);
            }
        }
    }
}



