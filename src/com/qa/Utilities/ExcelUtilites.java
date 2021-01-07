package com.qa.Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilites {
	
	
	
	// row count
	
	// column count
	
	//reach the cell data
	
	
	XSSFWorkbook WorkBook;
	XSSFSheet Sheet;
	
	public ExcelUtilites(String ExcelPath, String SheetName) {
		
		try{
			WorkBook = new XSSFWorkbook(ExcelPath);
			Sheet = WorkBook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public int getRowCount() {
		
		int rowCount = Sheet.getPhysicalNumberOfRows();
		return rowCount;
		
	}
	
	public int getColCount() {
		
		int colCount = Sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
		
	}
	
	public String getCellData(int rowNum, int ColNum) {
		
		
		String stringCellValue = Sheet.getRow(rowNum).getCell(ColNum).getStringCellValue();
		return stringCellValue;
	
	}

}
