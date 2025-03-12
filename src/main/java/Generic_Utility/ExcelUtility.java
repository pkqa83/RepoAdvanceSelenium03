package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * Method used to read data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return excelData
	 * @throws Throwable
	 * @author Viraj
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */


	
	public String getExcelData(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException  {

		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);

		String excelData = cell.getStringCellValue();
		return excelData;

	}
	
	
	/*
	 * This method is used to read any type of data from Excel file and format into String type
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return excelData
	 * @throws Throwable
	 * @author Viraj
	 */
	
	public String getExcelDataUsingDataFormatter(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_excel.xlsx");
	    Workbook book  = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet(sheetName);
	    Row row = sheet.getRow(rowIndex);
	    Cell cell = row.getCell(cellIndex);
	    
	    DataFormatter format = new DataFormatter();	    
	    String excelData = format.formatCellValue(cell);
		return excelData;
	}
	
	
	
	public Object[][] getExcelDataByDataProvider(String sheetName, int firstRowIndex, int firstCellIndex, int lastRowIndex, int lastCellIndex) throws EncryptedDocumentException, IOException  {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger_Excel_TestNg.xlsx");
	    Workbook book  = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet(sheetName);

	    
	    int RowSize = lastRowIndex-firstRowIndex+1;
	    int ColumnSize = lastCellIndex - firstCellIndex+1;
	    
	    Object[][] arr = new Object[RowSize][ColumnSize];
	    
	    for(int i = 0; i<RowSize; i++ ) 
	    {   
	    	int row = firstRowIndex+i;
	    	for(int j = 0; j<ColumnSize; j++)
	    	{	
	    		int cell = firstCellIndex+j;			    		
	    		arr[i][j] = sheet.getRow(row).getCell(cell).toString();
	    		System.out.println(arr[i][j]);
	    			    		
	    	}	    	
	    	row++;
	    }        
		return arr;
			
		
	}
	
}
