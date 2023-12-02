<<<<<<< HEAD
public class Customer {
    
    private String first_name;
    private String last_name;
=======

public class Customer {
    
    private String name;
>>>>>>> main
    private String dob;
    private int passportNum;
    private String email;

    public Customer() //default constructor
    {
<<<<<<< HEAD
        this.first_name = "test";
        this.last_name = "test";
        this.dob = "test";
=======
        this.name = "N/A";
        this.dob = "00/00";
>>>>>>> main
        this.passportNum = 0;
        this.email = "test";
        
    }
<<<<<<< HEAD
    public Customer(String first_name, String last_name, String dob, int passportNum, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
=======
    public Customer(String name, String dob, int passportNum, String email) {
        this.name = name;
>>>>>>> main
        this.dob = dob;
        this.passportNum = passportNum;
        this.email = email;
    }
    
    public String getfirst_name() 
    {
        return first_name;
    }

    public void setfirst_name(String first_name)
    {
        this.first_name = first_name;
    }

<<<<<<< HEAD
    public String getlast_name() 
    {
        return last_name;
    }

    public void setlast_name(String last_name)
    {
        this.last_name = last_name;
    }

=======
>>>>>>> main
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
