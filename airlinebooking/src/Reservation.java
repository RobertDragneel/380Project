public class Reservation {


    String first_name, last_name, email, dob;
    int passportNum;
    public void createCustomer()
    {
        Customer newCustomer = new Customer(first_name, last_name, dob, passportNum, email);
    }
    
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