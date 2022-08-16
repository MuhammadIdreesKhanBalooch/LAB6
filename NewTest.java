package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	//Actions actions = new Actions(driver);
	@Test(priority=1)
  public void addCustomer()  throws InterruptedException{ 


//getting to manager login
		 Thread.sleep(3000);
		  driver.findElement(By.xpath("(//div[contains(@class,'borderM box padT20')]//descendant :: button)[2]")).click();

	  //add customer
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//div[contains(@class,'border box padT20 ng-scope')]//descendant :: button)[1]")).click();
	  //add name
	  Thread.sleep(5000);
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
driver.switchTo().alert().accept();
//open acc
driver.findElement(By.xpath("(//div[contains(@class,'center')]//descendant :: button)[2]")).click();
Thread.sleep(2000);
//customer dropdown
driver.findElement(By.xpath("(//div[contains(@class,'form-group')]//descendant :: select)[1]")).click();

driver.findElement(By.xpath("(//div[contains(@class,'form-group')]//descendant :: option)[7]")).click();
driver.findElement(By.xpath("(//div[contains(@class,'form-group')]//descendant :: select)[2]")).click();
driver.findElement(By.xpath("(//form[contains(@class,'ng-invalid ng-invalid-required ng-dirty ng-valid-parse')]//following :: option)[9]")).click();

  }
//	@Test(priority=2)
//	public void openAccount() throws InterruptedException{
//	//	driver.findElement(By.xpath("(//div[contains(@class,'center')]//descendant :: button)[2]")).click();
//}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// setting selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\khan\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// hitting url
		String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
		driver.get(url);
			}

	@AfterMethod
	public void afterMethod() {
	}

}
