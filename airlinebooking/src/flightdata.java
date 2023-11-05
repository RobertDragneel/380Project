
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class flightdata {

    public String Atime;
    public String Dtime;
    public String Adate;
    public String Ddate;
    public String airline;
    public String fightnum;
    public String departure;
    public String arrival;


    public static void main(String[] args) {
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream("C:\\Users\\alonn\\OneDrive\\Desktop\\380\\380Project\\flight list.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the first sheet in the workbook (you can specify a different sheet if needed)
            Sheet sheet = workbook.getSheetAt(0);

            // Get the number of rows and columns in the sheet
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Create an array list for each column
            ArrayList<String>[] columns = new ArrayList[numCols];
            for (int i = 0; i < numCols; i++) {
                columns[i] = new ArrayList<>();
            }

            // Iterate through the rows and columns to populate the arrays
            for (int row = 0; row < numRows; row++) {
                Row currentRow = sheet.getRow(row);
                for (int col = 0; col < numCols; col++) {
                    Cell cell = currentRow.getCell(col);
                    if (cell != null) {
                        columns[col].add(cell.toString());
                    } else {
                        columns[col].add(""); // Empty cell
                    }
                }
            }

            // You can now access the data in each column array
            for (int col = 0; col < numCols; col++) {
                System.out.println("Column " + (col + 1) + ": " + columns[col]);
            }

            // Close the input stream
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
