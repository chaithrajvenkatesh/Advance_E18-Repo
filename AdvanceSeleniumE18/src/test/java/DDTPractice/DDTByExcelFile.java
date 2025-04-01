package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\java_folder\\M118\\AdvanceSeleniumE18\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String compagin = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();
		String targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		System.out.println(compagin);
		System.out.println(targetSize);
	}

}
