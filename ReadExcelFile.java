package ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException {
		File file = new File(filePath+"//"+fileName);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook scs=null;
		String FileExtensionName = fileName.substring(fileName.indexOf("."));
		scs = new XSSFWorkbook(inputstream);
		Sheet sheet = scs.getSheet(sheetName);
		return sheet;
		
	}
}
