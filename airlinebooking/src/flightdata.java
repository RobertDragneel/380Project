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
            FileInputStream fis = new FileInputStream("C:\\Users\\teody\\OneDrive\\Desktop\\VS Code\\Comp 380\\380Project\\flight_list.xlsx");
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

    public static List<String> search(String search1, String search2){
        String input1 = search1;
        String input2 = search2;
        String searchResult = "Item not found in the list.";
        List<String>[] dataColumns = readExcelData();
        List<Integer> occurrences1 = findIndices(dataColumns, input1 , 2);
        List<Integer> occurrences2 = findIndices(dataColumns, input2 , 2);
        List<String> newdata = new ArrayList<>();

        if (occurrences1.isEmpty()) {
            return null;
        }
        else{

            String test = "";
            for (int i = 0; i < occurrences1.size(); i++) {    
                for(int j = 7; j >= 0; j--){
                    test = dataColumns[j].get(occurrences1.get(i)) + " " + test;
                }
                newdata.add(test);
                test = "";
            } 
        }

        return newdata;
    }

    //this is used for testing
    /*public static void main(String[] args) {

        List<String> test = printdata("Los Angeles International Airport (LAX)", null);
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