package Oparations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyOparation {

	WebDriver driver;
	public MyOparation(WebDriver driver) {
		this.driver= driver;
    }
	public void perform(Properties p,String oparation,String objectName,String objectType,String value) throws Exception {
		switch(oparation.toUpperCase()) {
		case "CLICK":
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
			 
	     case "SETTEXT":
		   driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(new String(value));
		   break;
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		case "GETTEXT":
		 driver.findElement(this.getObject(p, objectName, objectType)).getText();
		    break;
		case "DROPDOWN":
			Select obj = new Select(driver.findElement(this.getObject(p, objectName, objectType)));
		 obj.selectByValue(new String(value));		
		   break;
		default:
			break;
}
}
	  private By getObject(Properties p, String objectName, String objectType) throws Exception {
		  if (objectType.equalsIgnoreCase("XPATH")) {
		return By.xpath(p.getProperty(objectName));
		  }
		  else if (objectType.equalsIgnoreCase("ID")) {
		return By.id(p.getProperty(objectName));	  
		  }
		  else if (objectType.equalsIgnoreCase("NAME")) {
		return By.name(p.getProperty(objectName));	  
		  }
		  else if (objectType.equalsIgnoreCase("CLASSNAME")) {
		return By.className(p.getProperty(objectName));
		  }
		  else if (objectType.equalsIgnoreCase("CSS")) {
		return By.cssSelector(p.getProperty(objectName));
		 }
		  else if (objectType.equalsIgnoreCase("LINK")) {
		return By.linkText(p.getProperty(objectName));
		}
		  else if (objectType.equalsIgnoreCase("PARTIALLINK")) {
		return By.partialLinkText(p.getProperty(objectName));
		}else {
			throw new Exception("wrong object type");
		}
	  }
}
