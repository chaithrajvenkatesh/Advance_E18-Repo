package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcelFile {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(
			"D:\\java_folder\\M118\\AdvanceSeleniumE18\\src\\test\\resources\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//wb.createSheet("WriteData").createRow(1).createCell(2).setCellValue("Selenium");
	wb.getSheet("DDT").createRow(2).createCell(0).setCellValue("2000");
	FileOutputStream fos= new FileOutputStream("D:\\java_folder\\M118\\AdvanceSeleniumE18\\src\\test\\resources\\TestScriptData.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("Data written successfully");
}
}
