import java.time.LocalDate;

public class Airline //maybe get rid of later
{
    private int flightNumber;
    private int departureTime; //24 hour clock ex: 0300 = 3am
    private int arrivalTime;

    public Flight(int flightNumber, int departureTime, int arrivalTime) //probably uneeded 
    {
        createAirplane();
        this.flightNumber = myAirplane.getFlightNumber();
    }
    //think to move airplane creation to reservation maybe?
    public void createAirplane()
    {
        Airplane myAirplane = new Airplane();
    }


}