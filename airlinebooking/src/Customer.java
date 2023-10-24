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

}
