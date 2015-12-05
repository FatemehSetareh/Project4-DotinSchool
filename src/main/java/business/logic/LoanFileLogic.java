package business.logic;

import business.GrantCondition;
import persistence.LoanFileCRUD;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoanFileLogic {
    public static String insertNewLoanFileLogic(String typeName, String duration, String amount, String customerNumber) {
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

    public static String insertGrantConditionLogic(String concatedGrantConditions, String typeName, String interestRate) throws SQLException {
        if (concatedGrantConditions.equals("")) {
            return "At Least One Grant Condition Is Needed To Register A New Loan Type.";
        } else {
            String[] grantConditions = concatedGrantConditions.split("&");

            ArrayList<GrantCondition> grantConditionObjectsArray = new ArrayList<GrantCondition>();

            for (String grantCondition : grantConditions) {
                String[] grantConditionElements = grantCondition.split("#");
                int grantConditionElementSize = grantConditionElements.length;
                String conditionName = null;
                String minDuration = null;
                String maxDuration = null;
                String minAmount = null;
                String maxAmount = null;
                if (0 < grantConditionElementSize) {
                    if (!grantConditionElements[0].equals("")) {
                        conditionName = grantConditionElements[0];
                        System.out.println(conditionName);
                    }
                    if (1 < grantConditionElementSize) {
                        if (!grantConditionElements[1].equals("")) {
                            minDuration = grantConditionElements[1];
                            System.out.println(minDuration);
                        }
                        if (2 < grantConditionElementSize) {
                            if (!grantConditionElements[2].equals("")) {
                                maxDuration = grantConditionElements[2];
                                System.out.println(maxDuration);
                            }
                            if (3 < grantConditionElementSize) {
                                if (!grantConditionElements[3].equals("")) {
                                    minAmount = grantConditionElements[3];
                                    System.out.println(minAmount);
                                }
                                if (4 < grantConditionElementSize) {
                                    if (!grantConditionElements[4].equals("")) {
                                        maxAmount = grantConditionElements[4];
                                        System.out.println(maxAmount);
                                    }

                                    if (conditionName != null && minDuration != null && maxDuration != null && minAmount != null && maxAmount != null) {
                                        GrantCondition grantConditionObject = new GrantCondition(typeName, conditionName, minDuration, maxDuration, minAmount, maxAmount, null);
                                        grantConditionObjectsArray.add(grantConditionObject);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(grantConditionObjectsArray.toString());
            //**ebteda check mikonad agar grant conditioni mojood nabashad az sabte loan type
            //** jologiry mikonad.
            if (grantConditionObjectsArray.size() == 0) {
                return "Grant Conditions You Entered Are Unacceptable, Please Try Again.";
            } else {
                if (!LoanTypeLogic.insertLoanTypeLogic(typeName, interestRate).equals("Ok")) {
                    //**agar loan type sabt nashod error haye sabte loan type ra namayesh midahad
                    //**va grant condition ha ra ham sabt nemikonad.
                    return LoanTypeLogic.insertLoanTypeLogic(typeName, interestRate);

                } else {
                    return LoanFileCRUD.insertGrantConditionToDatabase(grantConditionObjectsArray);
                }
            }
        }
    }
}
