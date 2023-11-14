import java.io.File;

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

    
}