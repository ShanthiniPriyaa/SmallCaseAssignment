package com.assessment.SmallCase.GenLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileUtilities {
	
	/**
	 * It is used to read the data from propertyfile
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertydata(String key) throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilepath));
		return p.getProperty(key);
	}
	
	/**
	 * It is used to read the data from Excel file
	 * @param SheetName
	 * @param row
	 * @param column
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String SheetName, int row, int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String s = wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return s;
	}
}