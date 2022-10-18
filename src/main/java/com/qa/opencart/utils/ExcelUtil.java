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
		FileInputStream ip;

		String excelEnv = System.getProperty("excelEnv");

		try {

			switch (excelEnv.toLowerCase()) {
			case "dev":
				ip = new FileInputStream("./src/test/resources/TestData/DEV_OpenCartAppTestData.xlsx");
				workbook = WorkbookFactory.create(ip);
				sheet = workbook.getSheet(sheetName);
				break;

			case "qa":
				ip = new FileInputStream("./src/test/resources/TestData/QA_OpenCartAppTestData.xlsx");
				workbook = WorkbookFactory.create(ip);
				sheet = workbook.getSheet(sheetName);
				break;

			case "stage":
				ip = new FileInputStream("./src/test/resources/TestData/STAGE_OpenCartAppTestData.xlsx");
				workbook = WorkbookFactory.create(ip);
				sheet = workbook.getSheet(sheetName);
				break;

			case "uat":
				ip = new FileInputStream("./src/test/resources/TestData/UAT_OpenCartAppTestData.xlsx");
				workbook = WorkbookFactory.create(ip);
				sheet = workbook.getSheet(sheetName);
				break;

			case "prod":
				ip = new FileInputStream("./src/test/resources/TestData/PROD_OpenCartAppTestData.xlsx");
				workbook = WorkbookFactory.create(ip);
				sheet = workbook.getSheet(sheetName);
				break;

			default:
				System.out.println("Please provide valid Excel-Env");
				break;
			}

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
