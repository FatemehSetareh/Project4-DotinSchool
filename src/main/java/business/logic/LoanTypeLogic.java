package business.logic;

import business.LoanType;
import persistence.LoanTypeCRUD;

import java.sql.SQLException;
import java.util.List;

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
            return ("Error in loan type registration: All Fields Should Be filled " + "<br>" + errorMsg);
        } else {
            LoanType loanType = new LoanType();
            loanType.setTypeName(typeName);
            loanType.setInterestRate(interestRate);
            if (LoanTypeCRUD.loanTypeCheckExistence(loanType)) {
                return LoanTypeCRUD.insertLoanTypeToDatabase(loanType);
            } else {
                return ("Error in loan type registration: LoanType Registered Before");
            }
        }
    }

    public static List searchDefinedLoanTypeLogic(){
       return LoanTypeCRUD.searchDefinedLoanType();
    }
}
