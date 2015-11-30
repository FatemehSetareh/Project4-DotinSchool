package business.logic;

import business.RealCustomer;
import persistence.RealCustomerCRUD;

public class RealCustomerLogic {
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
            if (RealCustomerCRUD.realCustomerCheckExistence(nationalCode)) {
                RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, nationalCode, birthDate, null);
                return RealCustomerCRUD.insertRealCustomerToDatabase(realCustomer);
            } else return "This National Code Registered Before";

        } else {
            return errorMsg;
        }
    }

    public static String searchCustomerNumberLogic(String customerNumber) {
        if (customerNumber.equals("")) {
            return "Please Enter Customer Number, This Field Can Not Be Empty.";
        }
        return RealCustomerCRUD.searchCustomerNumber(Integer.valueOf(customerNumber));
    }
}
