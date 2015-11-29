package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class DefineNewGrantConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String typeName = request.getParameter("typeName");
        System.out.println(typeName);

        Enumeration parameterNames = request.getParameterNames();
        System.out.println(parameterNames);
        while (parameterNames.hasMoreElements()) {
            String paramName = (String) parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            System.out.println(Arrays.toString(paramValues));
            for (int i = 0; i < paramValues.length; i++) {
                String conditionName = paramValues[i];
                System.out.println(conditionName);
            }
        }
    }
}



