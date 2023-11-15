import java.io.File;
import java.io.FileWriter;

public class Report
{
    File Report = new File("report.txt");
    if (Report.createNewFile()) 
    {
      System.out.println("File created: " + Report.getName());
    } 
    else 
    {
      System.out.println("File already exists.");
    }

    Report.write("Name: " + Customer.name + "\n");
    Report.append("DOB: " + Customer.dob + "\n");
    Report.append("Passport Number: " + Customer.passportNum + "\n");
    Report.append("Email: " + Customer.email + "\n");

    Report.append("Flight Number: " + Airplane.flightNumber + "\n");
    Report.append("Departure Time: " + Airplane.departureTime + "\n");
    Report.append("Arrival Time: " + Airplane.arrivalTime + "\n");
    
    Report.close();

}

