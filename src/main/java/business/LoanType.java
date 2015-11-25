package business;

import java.util.ArrayList;

public class LoanType {
    private String typeName;
    private String interestRate;
    private ArrayList<GrantCondition> grantConditions;

    public LoanType(String typeName, String interestRate) {
        this.typeName = typeName;
        this.interestRate = interestRate;
    }

    public LoanType(String typeName, String interestRate, ArrayList<GrantCondition> grantConditions) {
        this.typeName = typeName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
    }

    public LoanType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public ArrayList<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(ArrayList<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
