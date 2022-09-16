package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static Workbook workbook;
	private static Sheet sheet;
	private static Object actualExcelData[][];

	public static Object[][] getTestDataFromExcelSheet(String sheetName) {
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/TestData/OpenCartAppTestData.xlsx");
			workbook = WorkbookFactory.create(ip);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		actualExcelData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				actualExcelData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return actualExcelData;

	}

}
