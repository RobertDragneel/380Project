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
            FileInputStream fis = new FileInputStream("C:\\\\Users\\\\alonn\\\\OneDrive\\\\Desktop\\\\380\\\\380Project\\\\flight_list.xlsx");
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
                        if (col == 5 || col == 7) {
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
    public static List<Integer> findIndices(List<String>[] dataColumns, String target, int col) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < dataColumns[col].size(); i++) {
            if (dataColumns[col].get(i).equals(target)) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static List<String> search1(String string1){
        //setting vars and lists
        String input1 = string1;
        List<String> searchdata = new ArrayList<>();
        
        //calling the methods that are needed
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences = findIndices(dataColumns, input1 , 2);

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

    public static List<String> search2(String string2){
        //setting vars and lists
        String input1 = string2;
        List<String> searchdata = new ArrayList<>();
        
        //calling the methods that are needed
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences = findIndices(dataColumns, input1 , 3);

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

    public static List<String> combine(String string1, String string2){

        List<String> samedata = new ArrayList<>();
        List<String> results1 = search1(string1);
        List<String> results2 = search2(string2);

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
        else{
            for(int i = 0; i < results2.size(); i ++){
                for(int j = 0; j < results1.size(); j++){
                    if (results2.get(i).equals(results1.get(j))) {
                        samedata.add(results2.get(i));
                    }
                }
            }
        }

        return samedata;
    }

    //this is used for testing
    /*public static void main(String[] args) {
        
        List<String> test = combine("Los Angeles International Airport (LAX)", "John F. Kennedy International Airport (JFK)");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
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
        }
    }*/
}
