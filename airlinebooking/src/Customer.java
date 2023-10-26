import java.time.LocalDate;

public class Customer {
    
    private String name;
    private LocalDate dob;
    private int passportNum;
    private String email;

    public Customer(String name, LocalDate dob, int passportNum, String email) {
        this.name = name;
        this.dob = dob;
        this.passportNum = passportNum;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName()
    {

    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob()
    {

    }

    public int getPassportNum() {
        return passportNum;
    }

    public void setPassportNum()
    {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail()
    {
        
    }

}
