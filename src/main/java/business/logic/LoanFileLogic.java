package business.logic;

import business.GrantCondition;
import persistence.LoanFileCRUD;

public class LoanFileLogic {
    public static String checkLoanFileExistenceLogic(String typeName, String duration, String amount, String customerNumber) {
        String errorMsg = "";
        if (typeName.equals("")) {
            errorMsg += "Please Select LoanType From Menu";
        }
        if (duration.equals("")) {
            errorMsg += " Duration is already empty";
        }
        if (amount.equals("")) {
            errorMsg += "Amount is already empty";
        }
        if (customerNumber.equals("")) {
            errorMsg += "Customer Number is already empty";
        }
        if (typeName.equals("") || duration.equals("") || amount.equals("") || customerNumber.equals("")) {
            return ("Please Fill The Form Correctly " + errorMsg);
        } else {
            return LoanFileCRUD.searchGrantCondition(Integer.valueOf(customerNumber), typeName, duration, amount);
        }
    }

    public static void insertGrantConditionLogic(String typeName, String conditionName, String minDuration, String maxDuration, String minAmount, String maxAmount) {
        String errorMsg = "";
        if (typeName.equals("")) {
            errorMsg += "Type Name is already empty";
        }
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
        if (typeName.equals("") || conditionName.equals("") || minDuration.equals("") || maxDuration.equals("") || minAmount.equals("") || maxAmount.equals("")) {
            System.out.println("Please Fill The Form Correctly " + errorMsg);
        } else {
            GrantCondition grantCondition = new GrantCondition(typeName, conditionName, minDuration, maxDuration, minAmount, maxAmount, null);
            LoanFileCRUD.insertGrantConditionToDatabase(grantCondition);
        }
    }
}
