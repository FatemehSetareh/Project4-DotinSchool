package business;

import persistence.Crud;

import java.sql.SQLException;
import java.util.ArrayList;

public class Logic {
    public static String grantConditionStatus;

    public static void insertLoanTypeLogic(String typeName, String interestRate) throws SQLException {
        String errorMsg = "";
        if (typeName.equals("")) {
            errorMsg += "Type Name is already empty" + "<br>";
        }
        if (interestRate.equals("")) {
            errorMsg += "Interest Rate is already empty";
        }
        if (typeName.equals("") || interestRate.equals("")) {
            Crud.setLoanTypeInsertionMsg("All Fields Should Be filled " + "<br>" + errorMsg);
        } else {
            LoanType loanType = new LoanType();
            loanType.setTypeName(typeName);
            loanType.setInterestRate(interestRate);
            if (Crud.loanTypeCheckExistence(loanType)) {
                Crud.insertLoanTypeToDatabase(loanType);
            } else {
                Crud.setLoanTypeInsertionMsg("This Loan Type Is Registered Before.");
            }
        }
    }

    public static boolean insertGrantConditionLogic(String conditionName, String minDuration, String maxDuration, String minAmount, String maxAmount) {
        String errorMsg = "";
        ArrayList<GrantCondition> grantConditions = new ArrayList<GrantCondition>();
        if (conditionName.equals("")) {
            errorMsg += "Condition Name is already empty";
        }
        if (minDuration.equals("")) {
            errorMsg += "Minimum Duration is already empty";
        }
        if (maxDuration.equals("")) {
            errorMsg += "Maximum Duration is already empty";
        }
        if (minAmount.equals("")) {
            errorMsg += "Minimum Amount is already empty";
        }
        if (maxAmount.equals("")) {
            errorMsg += "Maximum Amount is already empty";
        }
        if (conditionName.equals("") || minDuration.equals("") || maxDuration.equals("") || minAmount.equals("") || maxAmount.equals("")) {
            setGrantConditionStatus("Please Fill The Form Correctly " + errorMsg);
            return false;
        } else {
            GrantCondition grantCondition = new GrantCondition(conditionName, minDuration, maxDuration, minAmount, maxAmount, null);
            grantConditions.add(grantCondition);
            //Crud.insertToDatabase(grantCondition);
            System.out.println("send to crud");
            return true;
        }
    }

    public static String getGrantConditionStatus() {
        return grantConditionStatus;
    }

    public static void setGrantConditionStatus(String grantConditionStatus) {
        Logic.grantConditionStatus = grantConditionStatus;
    }
}

