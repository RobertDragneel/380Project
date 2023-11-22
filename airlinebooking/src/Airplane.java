public class Airplane 
{
    private int flightNumber;
    private int departureTime;
    private int arrivalTime;

    public Airplane() //default constructor
    {
        this.flightNumber = -1;
        this.departureTime = -1;
        this.arrivalTime = -1;
    }

    public Airplane(int flightNumber, int departureTime, int arrivalTime)
    {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    
    /** 
     * @return int
     */
    public int getFlightNumber()
    {
        return flightNumber;
    }

    
    /** 
     * @param flightNumber
     */
    public void setFlightNumber(int flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public int getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(int departureTime)
    {
        this.departureTime = departureTime;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

}
