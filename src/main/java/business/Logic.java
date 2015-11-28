package business;

import persistence.Crud;

import java.sql.SQLException;

public class Logic {

    public static String insertRealCustomerLogic(String firstName, String lastName, String fatherName, Integer nationalCode, String birthDate) {
        String errorMsg = "";
        if (firstName.equals("")) {
            firstName = null;
            errorMsg += "First Name Field Is Empty" + "<br>";
        }
        if (lastName.equals("")) {
            lastName = null;
            errorMsg += "Last Name Field Is Empty" + "<br>";
        }
        if (fatherName.equals("")) {
            fatherName = null;
            errorMsg += "Father Name Field Is Empty" + "<br>";
        }
        if (nationalCode.equals("")) {
            nationalCode = null;
            errorMsg += "National Code Field Is Empty" + "<br>";
        }
        if (birthDate.equals("")) {
            birthDate = null;
            errorMsg += "Birth Date Field Is Empty" + "<br>";
        }
        if (firstName != null && lastName != null && fatherName != null && nationalCode != null && birthDate != null) {
            if (Crud.realCustomerCheckExistence(nationalCode)) {
                RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, nationalCode, birthDate, null);
                return Crud.insertRealCustomerToDatabase(realCustomer);
            } else return errorMsg += "This National Code Registered Before";

        } else {
            return errorMsg;
        }
    }

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

    public static String insertGrantConditionLogic(String typeName, String conditionName, String minDuration, String maxDuration, String minAmount, String maxAmount) {
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
            return ("Please Fill The Form Correctly " + errorMsg);
        } else {
            GrantCondition grantCondition = new GrantCondition(typeName, conditionName, minDuration, maxDuration, minAmount, maxAmount, null);
            Crud.insertGrantConditionToDatabase(grantCondition);
            return "ok";
        }
    }

    public static String searchCustomerNumberLogic(String customerNumber) {
        System.out.println("avvale logic");
        if (customerNumber.equals("")) {
            return "Please Enter Customer Number, This Field Can Not Be Empty.";
        }
        return Crud.searchCustomerNumber(Integer.valueOf(customerNumber));
    }

}


