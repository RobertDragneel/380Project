import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.commons.io.FilenameUtils;

public class ReadExcelTest {
    public static void main(String[] args) {
        try {
            // Provide the path to your Excel file
            String filePath = "C:/Users/pinoy/Desktop/CSUN/COMP 380/380Project/flight_list.xlsx";
            
            // Determine the file type (XLS or XLSX)
            String fileExtension = FilenameUtils.getExtension(filePath);
            Workbook workbook;
            if ("xlsx".equals(fileExtension)) {
                workbook = new XSSFWorkbook(filePath);
            } else {
                // For XLS files, use HSSFWorkbook
                throw new UnsupportedOperationException("XLS format is not supported.");
            }

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Create a DataFormatter to format cell values
            DataFormatter dataFormatter = new DataFormatter();

            // Iterate through rows and cells
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println(); // Move to the next row
            }

            // Close the workbook
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
