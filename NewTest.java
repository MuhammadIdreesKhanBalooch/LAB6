package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;

	@Test
  public void f()  throws InterruptedException{ 


//getting to manager login
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("(//div[contains(@class,'borderM box padT20')]//descendant :: button)[2]")).click();
	  //add customer
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//div[contains(@class,'border box padT20 ng-scope')]//descendant :: button)[1]")).click();
	  //add name
WebElement name =	  driver.findElement(By.xpath("(//div[contains(@class,'ng-scope')]//descendant :: input)[1]"));
name.click();
name.sendKeys("Muhamad");
	  //add last name
WebElement lname =  driver.findElement(By.xpath("(//div[contains(@class,'ng-scope')]//descendant :: input)[2]"));
lname.click();
lname.sendKeys("Idrees");
	  //add postal code

WebElement postalCode =	  driver.findElement(By.xpath("(//div[contains(@class,'ng-scope')]//descendant :: input)[3]"));
postalCode.click();
postalCode.sendKeys("5400");

//add customer
driver.findElement(By.xpath("(//div[contains(@class,'ng-scope')]//descendant :: button)[6]")).click();
  }

	@BeforeMethod
	public void beforeMethod() {
		// setting selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\4073\\Desktop\\chromedr\\chromedriver.exe");
		driver = new ChromeDriver();
		// hitting url
		String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
		driver.get(url);

	}

	@AfterMethod
	public void afterMethod() {
	}

}
