package presentation;

import business.logic.RealCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterRealCustomerServlet extends HttpServlet {
    PrintWriter out;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        Integer nationalCode = Integer.valueOf(request.getParameter("nationalCode"));
        String birthDate = request.getParameter("birthDate");

        //**get output and show result to user
        request.setAttribute("output", RealCustomerLogic.insertRealCustomerLogic(firstName, lastName, fatherName, nationalCode, birthDate));
        request.getRequestDispatcher("/register-real-customer-page.jsp").forward(request, response);


    }
}