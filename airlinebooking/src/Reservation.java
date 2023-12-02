public class Reservation {

    String name, email, dob;
    int passportNum;
    public void createCustomer()
    {
        
        Customer newCustomer = new Customer(name, dob, passportNum, email);
    }
    
    /* public void setCustomerInfo(String name)
    {
        createCustomer();
        newCustomer.setName()=name;
    } */

    public void search() {
        //For searching flights
    }

    public void reserve() {
        //For reserving flights
    }

    public void cancel() {
        //For canceling flights
    }

    public void review() {
        //For reviewing flight details
    }
    
}
