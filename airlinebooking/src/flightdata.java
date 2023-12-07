import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class flightdata {

    private static List<String>[] dataColumns;

    static {
        // Read Excel data only once
        dataColumns = readExcelData();
    }

    public static List<String>[] readExcelData() {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\pinoy\\Desktop\\CSUN\\COMP 380\\380Project\\flight_list.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            List<String>[] columns = new ArrayList[numCols];
            for (int i = 0; i < numCols; i++) {
                columns[i] = new ArrayList<>();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            for (int row = 1; row < numRows; row++) {
                Row currentRow = sheet.getRow(row);
                for (int col = 0; col < numCols; col++) {
                    Cell cell = currentRow.getCell(col);
                    if (cell != null) {
                        if (col == 4 || col == 6) {
                            Date dateValue = cell.getDateCellValue();
                            columns[col].add(dateFormat.format(dateValue));
                        } else {
                            columns[col].add(cell.toString());
                        }
                    } else {
                        columns[col].add("");
                    }
                }
            }

            return columns;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> createSearchData(List<Integer> occurrences, List<String>[] dataColumns) {

        List<String> searchData = new ArrayList<>();

        for (int i : occurrences) {
            StringBuilder combString = new StringBuilder();
            for (int j = 6; j >= 0; j--) {
                combString.insert(0, dataColumns[j].get(i)).insert(0, " ");
            }
            searchData.add(combString.toString().trim());
        }
        
        return searchData;
    }

    public static List<String> search(String location, int num) {
        List<Integer> occurrences = findLocation(dataColumns, location, num);

        if (occurrences.isEmpty()) {
            return null;
        } else {
            return createSearchData(occurrences, dataColumns);
        }
    }

    public static List<String> filter(String origin, String destination) {
        List<String> results1 = search(origin, 1);
        List<String> results2 = search(destination, 2);
        List<String> sameData = new ArrayList<>();
    
        if (results1 == null || results2 == null) {
            sameData.add("No matching flights found");
        } else {
            sameData.addAll(results1);
    
            if (!results1.isEmpty() && !results2.isEmpty()) {
                sameData.retainAll(results2);
            }
    
            if (sameData.isEmpty()) {
                sameData.add("No matching flights found");
            }
        }
    
        return sameData;
    }
    

    public static List<String> flightNumberSearch(String flightNumber) {
        List<String> temp = new ArrayList<>();
        List<Integer> occurrences = findLocation(dataColumns, flightNumber, 0);

        if (occurrences.isEmpty()) {
            temp.add("No matching flights found");
        } else {
            temp = createSearchData(occurrences, dataColumns);
        }

        return temp;
    }

    public static List<Integer> findLocation(List<String>[] data, String substring, int num) {
        List<Integer> indices = new ArrayList<>();
        substring = substring.toLowerCase();

        for (int i = 0; i < data[num].size(); i++) {
            String str = data[num].get(i).toLowerCase();
            if (str.contains(substring)) {
                indices.add(i);
            }
        }

        return indices;
    }

    //this is used for testing
    
    /*public static void main(String[] args) {

        List<String> test = filter("ord", "mia");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }

        
        List<String> test2 = flightNumberSearch("DL123");
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
        }
    }*/
    
}