package Test_1;


import org.testng.annotations.Test;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class test_001 {
	WebDriver driver=null;
	
  
  @BeforeTest
  public void initialize() throws Exception {
	  
	 
		System.setProperty("webdriver.chrome.driver","C:\\Automation_Env\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signin");
		
  }
  
  @Test
  public void GoogleLogin() throws Exception{

  
  assertEquals("Sign in", driver.findElement(By.id("signIn")).getAttribute("value"));
  
  
//Maximize the window
  driver.manage().window().maximize();

  //Clear autofilled and enter username, click next
  WebElement i= driver.findElement(By.id("identifierId"));
  i.clear();
  //driver.findElement(By.id("Email")).clear();

  WebElement x= driver.findElement(By.id("identifierId"));
  x.sendKeys("p.noureldeen@gmail.com");

  WebElement y= driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
  y.click();
  Thread.sleep(2000);

  //Clear pass and enter password, click submit
  //*[@id='password']/div[1]/div/div[1]/input
  driver.findElement(By.id("password")).clear();
  driver.findElement(By.id("password")).sendKeys("++++++");
  //driver.findElement(By.id("PersistentCookie")).click();
  driver.findElement(By.id("passwordNext")).click();
  Thread.sleep(2000);

  //verify login is done
  System.out.println(driver.getTitle());
  Thread.sleep(2000);
}

 
 
  @AfterTest
  public void Exit(){
      driver.close();
    }


}
