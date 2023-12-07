import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class flightdata {
    
    public static List<String>[] readExcelData() {
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream("C:\\Users\\alonn\\OneDrive\\Desktop\\380\\380Project\\flight_list.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the first sheet in the workbook (you can specify a different sheet if needed)
            Sheet sheet = workbook.getSheetAt(0);

            // Get the number of rows and columns in the sheet
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Create an array list for each column
            List<String>[] columns = new ArrayList[numCols];
            for (int i = 0; i < numCols; i++) {
                columns[i] = new ArrayList<>();
            }

            // Create a date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            // Iterate through the rows and columns to populate the arrays
            for (int row = 1; row < numRows; row++) {
                Row currentRow = sheet.getRow(row);
                for (int col = 0; col < numCols; col++) {
                    Cell cell = currentRow.getCell(col);
                    if (cell != null) {
                        if (col == 4 || col == 6) {
                            // Format date and time values
                            Date dateValue = cell.getDateCellValue();
                            columns[col].add(dateFormat.format(dateValue));
                        } else {
                            columns[col].add(cell.toString());
                        }
                    } else {
                        columns[col].add(""); // Empty cell
                    }
                }
            }

            // Close the input stream
            fis.close();

            return columns;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //reads through the given array in the list to find the traget item
    public static List<Integer> findLocation(List<String>[] dataColumns, String substring, int num) {

        List<Integer> indices = new ArrayList<>();
        substring = substring.toLowerCase();

        for (int i = 0; i < dataColumns[num].size(); i++) {
            String str = dataColumns[num].get(i);
            str = str.toLowerCase();
            if (str.contains(substring)) {
                indices.add(i);
            }
        }
            
        return indices;
    }
   
    public static List<String> searchorigin(String origin){
        //setting vars and lists
        String input1 = origin;
        List<String> searchdata = new ArrayList<>();
        
        //calling the methods that are needed
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences = findLocation(dataColumns, input1, 1);

        //if the input is not found nothing will return
        if (occurrences.isEmpty()) {
            return null;
        }
        //if found start putting the found data into a list
        else{

            //input search
            for (int i = 0; i < occurrences.size(); i++) {   
                String combString = ""; 
                for(int j = 6; j >= 0; j--){
                    combString = dataColumns[j].get(occurrences.get(i)) + " " + combString;
                }
                searchdata.add(combString);
            } 
        }

        return searchdata;
    }

    public static List<String> searchdestination(String destination){
        //setting vars and lists
        String input1 = destination;
        List<String> searchdata = new ArrayList<>();
        
        //calling the methods that are needed
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences = findLocation(dataColumns, input1 , 2);

        //if the input is not found nothing will return
        if (occurrences.isEmpty()) {
            return null;
        }
        //if found start putting the found data into a list
        else{

            //input search
            for (int i = 0; i < occurrences.size(); i++) {   
                String combString = ""; 
                for(int j = 6; j >= 0; j--){
                    combString = dataColumns[j].get(occurrences.get(i)) + " " + combString;
                }
                searchdata.add(combString);
            } 
        }

        return searchdata;
    }

    public static List<String> filter(String origin, String destination){

        List<String> samedata = new ArrayList<>();
        List<String> results1 = searchorigin(origin);
        List<String> results2 = searchdestination(destination);

        if (results1 == null || results2 == null){
            samedata.add("No matching flights found");
        }

        else{
            //checks if input1 and 2 had any of the same flights if input 1 has more or they have an equal number flights
            if(results1.size() >= results2.size()){
                for(int i = 0; i < results1.size(); i ++){
                    for(int j = 0; j < results2.size(); j++){
                        if (results1.get(i).equals(results2.get(j))) {
                            samedata.add(results1.get(i));
                        }
                    }
                }   
            }
            //checks if input1 and 2 had any of the same flights if input 2 has more flights
            else if(results1.size() < results2.size()){
                for(int i = 0; i < results2.size(); i ++){
                    for(int j = 0; j < results1.size(); j++){
                        if (results2.get(i).equals(results1.get(j))) {
                            samedata.add(results2.get(i));
                        }
                    }
                }
            }
        }

        if(samedata.isEmpty()){
            samedata.add("No matching flights found");
        }

        return samedata;
    }

    public static List<String> flightnumbersearch(String flightnumber){
        //setting vars and lists
        List<String> searchdata = new ArrayList<>();
        
        //calling the methods that are needed
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences = findLocation(dataColumns, flightnumber , 0);

        //if the input is not found nothing will return
        if (occurrences.isEmpty()) {
            return null;
        }
        //if found start putting the found data into a list
        else{

            //input search
            for (int i = 0; i < occurrences.size(); i++) {   
                String combString = ""; 
                for(int j = 7; j >= 0; j--){
                    combString = dataColumns[j].get(occurrences.get(i)) + " " + combString;
                }
                searchdata.add(combString);
            } 
        }

        return searchdata;
    }

    //this is used for testing
    
    public static void main(String[] args) {

        List<String> test = filter("jfk", "lax");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }/*

        
        List<String> test2 = flightnumbersearch("WN789");
        for (int i = 0; i < test2.size(); i++) {
            System.out.println(test2.get(i));
        }
  
         List<String>[] dataColumns = readExcelData();

        String targetItem = "Los Angeles International Airport (LAX)";
        List<Integer> occurrences = findIndices(dataColumns, targetItem, 2);
        if (occurrences.isEmpty()) {
            System.out.println("Item not found in the list.");
        } else {
            System.out.println("The item '" + targetItem + "' is found at indices: " + occurrences);
        }

        for(int i = 0; i < occurrences.size(); i++){
            for(int j = 0; j < 8; j++){
                System.out.println(dataColumns[j].get(occurrences.get(i)));
            }
        }*/
    }
    
}