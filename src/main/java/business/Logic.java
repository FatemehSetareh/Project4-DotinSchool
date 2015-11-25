package business;

import persistence.Crud;

import java.sql.SQLException;

public class Logic {
    public static void checkNull(String name, String minTime, String maxTime, String minAmount, String maxAmount) {
//        int counter = 0;
//        if(name.equals("")){
//            name = null;
//            counter += 1;
//        }
//        if(minTime.equals("")){
//            minTime = null;
//            counter += 1;
//        }
//        if(maxTime.equals("")){
//            maxTime = null;
//            counter += 1;
//        }
//        if(minAmount.equals("")){
//            minAmount = null;
//            counter += 1;
//        }
//        if(maxAmount.equals("")){
//            maxAmount = null;
//            counter += 1;
//        }
//        if(name.equals(null) && minTime.equals(null) && maxTime.equals(null) && minAmount.equals(null) && maxAmount.equals(null)){
//            //report that all condition is empty plz set one condition at least
//        } else {
        System.out.println("ghable crud");
        GrantCondition grantCondition = new GrantCondition(name, minTime, maxTime, minAmount, maxAmount, null);
        //Crud.insertToDatabase(grantCondition);
        System.out.println("send to crud");

        //}
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
}
