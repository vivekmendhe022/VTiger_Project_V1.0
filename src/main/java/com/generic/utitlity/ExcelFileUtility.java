package com.generic.utitlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist generic method of excel sheel.
 * 
 * @author vivek
 *
 */
public class ExcelFileUtility {

	/**
	 * This method read data from excel sheet & return the data from caller. This is
	 * the desight starategy of Data Driven Testing.
	 * 
	 * @param ShhetName
	 * @param Row
	 * @param Cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String ShhetName, int Row, int Cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		return book.getSheet(ShhetName).getRow(Row).getCell(Cell).getStringCellValue();
	}

	/**
	 * This method will write data into excel file.
	 * 
	 * @param SheeName
	 * @param Row
	 * @param Cell
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String SheeName, int Row, int Cell, String Value)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		book.createSheet(SheeName).createRow(Row).createCell(Cell).setCellValue(Value);

		FileOutputStream fileOut = new FileOutputStream(IConstantUtility.EXCELFILEPATH);
		book.write(fileOut);
		book.close();
	}

	/**
	 * This method will read multiple data from excel file. 
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readDataFromDataProvider(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SheetName);

		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return data;
	}
}
