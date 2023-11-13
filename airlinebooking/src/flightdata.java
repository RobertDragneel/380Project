import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class flightdata {
    public static String readExcelSheet() {
        Workbook workbook = null;
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream("C:\\Users\\pinoy\\Desktop\\CSUN\\COMP 380\\380Project\\flight_list.xlsx");
            workbook = new XSSFWorkbook(fis);

            // Get the first sheet in the workbook (you can specify a different sheet if needed)
            Sheet sheet = workbook.getSheetAt(0);

            // Get the number of rows and columns in the sheet
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // Create an array list for each column
            List<List<String>> columns = new ArrayList<>();
            for (int i = 0; i < numCols; i++) {
                columns.add(new ArrayList<>());
            }
            

            // Create a date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            // StringBuilder used to concatenate the data
            StringBuilder flightInfo = new StringBuilder();

            // Iterate through the rows and columns to populate the arrays
            for (int row = 1; row < numRows; row++) {
                Row currentRow = sheet.getRow(row);
                for (int col = 0; col < numCols; col++) {
                    Cell cell = currentRow.getCell(col);
                    if (cell != null) {
                        if (col == 5 || col == 7) {
                            // Format date and time values
                            Date dateValue = cell.getDateCellValue();
                            //columns[col].add(dateFormat.format(dateValue));
                            
                            flightInfo.append(dateFormat.format(dateValue));
                        } else {
                            //columns[col].add(cell.toString());

                            flightInfo.append(cell.toString());
                        }
                    } else {
                        //columns[col].add(""); // Empty cell

                        flightInfo.append(" ");
                    }
                    flightInfo.append(",");
                }
                flightInfo.append("\n");
            }

            /* 
            // You can now access the data in each column array
            for (int col = 0; col < numCols; col++) {
                System.out.println("Column " + (col + 1) + ": " + columns[col]);
            }
            */


            // Close the input stream
            fis.close();
            
            return flightInfo.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close(); // Close the workbook in the finally block
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    public static void main(String[] args) {
        String excelData = readExcelSheet();
        System.out.println(excelData);
    }
}