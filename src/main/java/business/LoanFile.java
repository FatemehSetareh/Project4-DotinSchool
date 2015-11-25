package business;

public class LoanFile {
    private Integer customerNumber;
    private String typeName;
    private String duration;
    private String amount;
    private String loanFileId;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLoanFileId() {
        return loanFileId;
    }

    public void setLoanFileId(String loanFileId) {
        this.loanFileId = loanFileId;
    }
}
