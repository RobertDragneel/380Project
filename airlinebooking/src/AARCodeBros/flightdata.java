package AARCodeBros;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class flightdata {

    
    /** 
     * @return List<String>[]
     */
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
    
    
    /** 
     * @param dataColumns
     * @param target
     * @param col
     * @return List<Integer>
     */
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

    //this is used for testing
    /*public static void main(String[] args) {
        List<String>[] dataColumns = readExcelData();

        String targetItem = "American Airlines";
        List<Integer> occurrences = findIndices(dataColumns, targetItem, 0);
        if (occurrences.isEmpty()) {
            System.out.println("Item not found in the list.");
        } else {
            System.out.println("The item '" + targetItem + "' is found at indices: " + occurrences);
        }

        String name = "American Airlines";
        if (dataColumns != null) {
            int i = dataColumns[0].indexOf(name);
            System.out.println(dataColumns[0].indexOf(name));
            System.out.println(dataColumns[0].get(i));
        }
    }*/
}
