public class Customer {
    
    private String first_name;
    private String last_name;
    private String dob;
    private int passportNum;
    private String email;

    public Customer() //default constructor
    {
        this.first_name = "test";
        this.last_name = "test";
        this.dob = "test";
        this.passportNum = 0;
        this.email = "test";
        
    }
    public Customer(String first_name, String last_name, String dob, int passportNum, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.passportNum = passportNum;
        this.email = email;
    } //likely wont need this as customer will be created then variables set after (keeping incase)
    
    public String getfirst_name() 
    {
        return first_name;
    }

    public void setfirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getlast_name() 
    {
        return last_name;
    }

    public void setlast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getDob() 
    {
        return dob;
    }

    public void setDob(String dob)
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