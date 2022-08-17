package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class test {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Actions actions = new Actions(driver);
  @Test(priority=0)
  public void input() {
	 //name
	  	driver.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: textarea[contains(@id,'ta')]")).sendKeys("Muhammad Idrees");
	 //getting text from 2nd textarea
	  	WebElement text2 = driver.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: textarea[contains(text(),'The ')]"));
	  	System.out.println(text2.getText());
	  	text2.sendKeys(Keys.CONTROL + "a");
	  	text2.sendKeys( Keys.BACK_SPACE);
	  	text2.sendKeys("A supreme lover of plants is automating the browser!");
	 
	  	
	  	
  }
  
  @Test(priority=1)
  public void table() {
	//table
	  	WebElement table = driver.findElement(By.xpath("//div[contains(@class,'navbar')]//following :: table[contains(@id,'table')]"));
	  	List<WebElement> rows = driver.findElements(By.tagName("tr"));
	  	for( WebElement row : rows) {
	  		System.out.print(row.getText() + "\n");
	  	}
	//username
	  	driver.findElement(By.xpath("// form[contains(@name,'form')]//child::input[contains(@type,'text')]")).sendKeys("Muhmmad Idrees");
	//password
	  	driver.findElement(By.xpath("// form[contains(@name,'form')]//child::input[contains(@type,'password')]")).sendKeys("8932");
	//login
	  	driver.findElement(By.xpath("// form[contains(@name,'form')]//child::button[contains(@type,'button')]")).click();
	 
  
  }
  
  @Test(priority=2)
  public void frameSwitching() {
	  	WebElement frame1 = driver.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[1]"));
	  	driver.switchTo().frame(frame1);
	//switch to default frame
		driver.switchTo().defaultContent();
	//frame2
		WebElement frame2 = driver.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[2]"));
		driver.switchTo().frame(frame2);
		driver.switchTo().defaultContent();
	  
	  
  }
  
  @Test(priority=3)
  public void login2() {
	//username
	  	driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'text')]")).sendKeys("Muhmmad Idrees");
	//password
	  	driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'password')]")).sendKeys("8932");
	//login
	  	driver.findElement(By.xpath("// form[contains(@name,'login')]//child::input[contains(@type,'button')]")).click();  
	//alert
	  	driver.switchTo().alert().accept();
  }
  
  @Test(priority=4)
  public void hyundai()	{
	  	driver.findElement(By.xpath("//div[contains(@class,'widget HTML')]//child :: option[contains(text(),'Hyundai')]")).click();
	//dropdown
		driver.findElement(By.xpath("//div[contains(@class,'widget HTML')]//child :: select[contains(@class,'combo')]")).click();
	//doc3
		driver.findElement(By.xpath("//select[contains(@class,'combo')]//child :: option[contains(@value,'jkl')]"));			
  }
  
  @Test(priority=5)
  public void preLoadedText() {
	//preloadedTextBox  
		  WebElement preLoadedTextBox = driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: input[contains(@value,'Selenium')]"));
		  preLoadedTextBox.click();
		  preLoadedTextBox.sendKeys(Keys.CONTROL + "a");
		  preLoadedTextBox.sendKeys(Keys.BACK_SPACE);
		  preLoadedTextBox.sendKeys("automation on 🔥");
	//enabledButton 
		  WebElement btn2 = driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),\"Button2\")]"));
			btn2.click();
	//checking enability
			System.out.println("button 2 is" + btn2.isEnabled());
  }
  
  @Test(priority=6)
  public void threeButtons() {
	  driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),\"Submit\")]")).click();
	  driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),\"Login\")]")).click();
	  driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: button[contains(text(),\"Register\")]")).click();
  }
  
  @Test(priority=7)
  public void waitForTextDisappear() {
	  //clicking after text disapppears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'delete')]")));
		driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: input[contains(@value,'ClickAfter')]")).click();
		driver.switchTo().alert().accept();
  } 
  
  @Test(priority=8)
public void newPopWindow() {
	 //only store curent window name 
		  driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child :: a[contains(text(),'Open')]")).click();  
		  String parentWindowHandler = driver.getWindowHandle();
	
		 String subWindowHandler = null;
	//get subWindow handles
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next(); 
			}
			driver.switchTo().window(subWindowHandler);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main")));
	//getting text from new popup window
			WebElement para1 = driver.findElement(By.className("main"));

			WebElement para2 = driver.findElement(By.className("sub"));
			System.out.println(para1.getText() + "\n" + para2.getText());
	//switch to parent window	
			driver.switchTo().window(parentWindowHandler);
	  
  } 
  
  @Test(priority=9)
  public void uploadFile() {
	  //upload file
	  		driver.findElement(By.xpath("//form[contains(@action,'demo_form')]//child :: input")).sendKeys("C:\\Users\\4073\\Desktop\\companyHiring.PNG");
	// my btn functionality before clicking "try it"
			WebElement myBtn = driver.findElement(By.xpath("//button[contains(text(),'My')]"));
			System.out.println("'My Button' functionality before clicking 'Try It' button" + myBtn.isEnabled());
	// cliking tryIt button
			driver.findElement(By.xpath("//button[contains(text(),'Try')]")).click();
	// my btn functionality after clicking "try it"
			System.out.println("'My Button' functionality after clicking 'Try It' button" + myBtn.isEnabled());
  }
  
  @Test(priority=10)
  public void doubleClickButton() {
	 //double click button 
			WebElement dbClick = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));  
			actions.doubleClick(dbClick).perform();
	//handle alert
			driver.switchTo().alert().accept();
	// chekThis buton
			driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
	// checkbox wait
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'dt') ]")));
			// checkbox click
			driver.findElement(By.xpath("//input[contains(@id,'dt') ]")).click();		
  }
  
  @Test(priority=11)
  public void gender() {
	 //gender radio 
	  		driver.findElement(By.xpath("//div[contains(@class,'widget HTML')]//descendant :: input)[13]")).click();
	 //clickToget alert
	  		driver.findElement(By.xpath("//input[contains(@value,'ClickTo')]")).click();
	 //handle alert
	  		driver.switchTo().alert().accept();
	 //select blue
	  		driver.findElement(By.xpath("//input[contains(@value,'blue')]")).click();
	 //unselect orange
	  		driver.findElement(By.xpath("//input[contains(@value,'ora')]")).click();
	 //reading text
	  		WebElement read = driver.findElement(By.xpath("//input[contains(@value,'Read')]"));
	  		actions.doubleClick(read).perform();
	 //get prompt
	  		
	  		WebElement getPrompt = driver.findElement(By.xpath("//input[contains(@value,'GetPrompt')]"));
			getPrompt.click();
			Alert promptPresent = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(promptPresent.getText());
	//put name in alert
			String name = "Muhammad Idrees";
			driver.switchTo().alert().sendKeys(name);
			promptPresent.accept();
	//cconfirmation alert
			driver.findElement(By.xpath("//input[contains(@value,'GetConfirm')]")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();		
  }
  
  @Test(priority=12)
  public void csameClassboxes() {
	  
	// filling text boxes and selecting car
			WebElement locateUsingClass1 = driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[26]"));
			locateUsingClass1.click();
			locateUsingClass1.sendKeys("located finally");
			WebElement locateUsingClass2 = driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[27]"));
			locateUsingClass2.click();
			locateUsingClass2.sendKeys("hope done the question");
	//select car
			driver.findElement(By.xpath("//input[contains(@value,'Car')]")).click();
	//select bag		
			driver.findElement(By.xpath("//input[contains(@value,'Bag')]")).click();
	//select book
			driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
	//deselect book
			driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();	
	//deropdown
			driver.findElement(By.xpath("//button[contains(@class,'drop')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Facebook')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	// setting selenium
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\khan\\chrome driver\\chromedriver.exe");
			
	// hitting url
			String url = "https://omayo.blogspot.in/";
			driver.get(url);
			
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
