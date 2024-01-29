package Execuation;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Oparations.MyOparation;
import ReadExcel.ReadExcelFile;
import ReadObject.MyReadObject;

public class MyExecuation {

	WebDriver driver;
	@BeforeMethod
	public void beforemethod() {
		System.setProperty("WebDriver.Chrome.driver","c://chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void f() throws Exception {
		ReadExcelFile file = new ReadExcelFile();
		MyReadObject object = new MyReadObject();
		Properties allObjects = object.getObjectRepository();
		MyOparation oparation = new MyOparation(driver);
		Sheet scsSheet = file.readExcel(System.getProperty("user.dir")+"//", "facebook.xlsx","Sheet1");
		int rowcount = scsSheet.getLastRowNum()-scsSheet.getFirstRowNum();
		for (int i=1; i<rowcount+1; i++) {
			Row row = scsSheet.getRow(i);
			if(row.getCell(0).toString().length()==0) {
				System.out.println(row.getCell(1).toString()+"----"+row.getCell(2).toString()+"----"+row.getCell(3).toString()+"----"+row.getCell(4).toString());
				oparation.perform(allObjects, row.getCell(1).toString(),row.getCell(2).toString(),row.getCell(3).toString(), row.getCell(4).toString());
			}
			else {
				System.out.println("New TestCase-->"+row.getCell(0).toString()+"Started");
			}
		}
	}
	
	@AfterMethod
	public void aftermethod() {
		//driver.navigate().refresh();
	}
}
