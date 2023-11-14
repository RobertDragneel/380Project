import java.time.LocalDate;

public class Customer {
    
    private String name;
    private LocalDate dob;
    private int passportNum;
    private String email;

    public Customer()
    {
        this.name = "N/A";
        this.dob = dob.now();
        this.passportNum = 0;
        this.email = "N/A";
        
    }
    public Customer(String name, LocalDate dob, int passportNum, String email) {
        this.name = name;
        this.dob = dob;
        this.passportNum = passportNum;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }


    public int getPassportNum() {
        return passportNum;
    }


    public String getEmail() {
        return email;
    }

}
