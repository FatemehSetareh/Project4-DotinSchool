package presentation;

import business.GrantCondition;
import business.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DefineNewGrantConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ArrayList<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

        int counter = Integer.parseInt(request.getParameter("counter"));
        while (counter != 0) {
            for (int j = 0; j < 5; j++) {
                String conditionName = request.getParameter("grant" + counter);
                String minDuration = request.getParameter("grant" + counter);
                String maxDuration = request.getParameter("grant" + counter);
                String minAmount = request.getParameter("grant" + counter);
                String maxAmount = request.getParameter("grant" + counter);
                out.print(Logic.insertGrantConditionLogic("maskan", conditionName, minDuration, maxDuration, minAmount, maxAmount));
            }

        }
    }
}

