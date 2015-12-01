package presentation;

import business.logic.LoanTypeLogic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchForDefinedLoanTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");


    }

    public static List searchLoanTypes() {
        return LoanTypeLogic.searchDefinedLoanTypeLogic();
    }
}
