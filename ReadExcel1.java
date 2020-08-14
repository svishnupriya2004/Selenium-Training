package testcase2withexcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static String[][] excelData(String fileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		XSSFSheet sheet = wb.getSheet("Sheet1");  //to getinto sheet
		
		int rowCount = sheet.getLastRowNum();  // to find no of rows excluding first row
		System.out.println(rowCount);
		
		//int allrows = sheet.getPhysicalNumberOfRows();   // to find no of rows including first row
		
		int cellCount = sheet.getRow(0).getLastCellNum(); // to get cell count
		System.out.println(cellCount);
		
		//declare 2D array
		String[][] data = new String[rowCount][cellCount];

		//give loop for rows
		for (int i = 1; i <= rowCount; i++) {
			
			
			//give innerloop to execute cell value for each row
			for (int j = 0; j < cellCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue(); // single code to getinto row, its cell ,gets cell value
				data[i-1][j] = cellValue;
				System.out.println(cellValue);
			}
			//System.out.println();
		}
		
		wb.close();
		return data;
	}

}
