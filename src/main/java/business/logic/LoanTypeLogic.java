package business.logic;

import business.LoanType;
import persistence.LoanTypeCRUD;

import java.sql.SQLException;

public class LoanTypeLogic {
    public static String insertLoanTypeLogic(String typeName, String interestRate) throws SQLException {
        String errorMsg = "";
        if (typeName.equals("")) {
            errorMsg += "Type Name is already empty" + "<br>";
        }
        if (interestRate.equals("")) {
            errorMsg += "Interest Rate is already empty";
        }
        if (typeName.equals("") || interestRate.equals("")) {
            return ("All Fields Should Be filled " + "<br>" + errorMsg);
        } else {
            LoanType loanType = new LoanType();
            loanType.setTypeName(typeName);
            loanType.setInterestRate(interestRate);
            if (LoanTypeCRUD.loanTypeCheckExistence(loanType)) {
                return LoanTypeCRUD.insertLoanTypeToDatabase(loanType);
            } else {
                return ("This Loan Type Is Registered Before.");
            }
        }
    }
}
