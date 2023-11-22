import java.time.LocalDate;

public class Customer {
    
    private String name;
    private LocalDate dob;
    private int passportNum;
    private String email;

    public Customer() //default constructor
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
    } //likely wont need this as customer will be created then variables set after (keeping incase)
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDob() 
    {
        return dob;
    }

    public void setDob(LocalDate dob)
    {
        this.dob = dob;
    }

    public int getPassportNum() 
    {
        return passportNum;
    }

    public void setPassportNum(int passportNum)
    {
        this.passportNum = passportNum;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
