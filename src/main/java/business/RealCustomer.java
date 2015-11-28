package business;


public class RealCustomer {
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer nationalCode;
    private String birthDate;
    private Integer customerNumber;

    public RealCustomer(String firstName, String lastName, String fatherName, Integer nationalCode, String birthDate, Integer customerNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.customerNumber = customerNumber;
    }

    public RealCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Integer getNationalCode() {
        return nationalCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

}
