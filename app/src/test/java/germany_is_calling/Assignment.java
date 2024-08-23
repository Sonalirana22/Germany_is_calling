package germany_is_calling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment {
    WebDriver driver;
    
  
    @BeforeMethod
    public void Setup(){
      //Setup WebDriver
       System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://app.germanyiscalling.com/common/login/");

       //Maximize the window
       driver.manage().window().maximize();
    }


       @Test(priority = 1)
       public void SuccessfulLogin(){

       //Locating the username field and entering valid email id
       WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
       username.sendKeys("sonalirana286@gmail.com");


       // Locating the password field and entering the valid password
       WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
       password.sendKeys("#Dummy@1234");
      

       // Locate and click on the login button
       WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log In']"));
       loginBtn.click();

       //Comparing expected and actual result
       String expectedResult = "https://app.germanyiscalling.com/cv/upload/";
       String actualResult = driver.getCurrentUrl();
       System.out.println(actualResult);

       Assert.assertEquals(actualResult, expectedResult,"Redirection to the landing page is failed");
       }

       @Test(priority = 2)
       public void UnSuccessfulLogin(){

        //Locating the username field and entering valid email id
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("sonalirana286@gmail.com");


        //Locating the password field and entering the wrong password
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Random@1234");


        // Locate and click on the login button
        WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log In']"));
        loginBtn.click();



        // Verifying if the error message is displayed or not
        WebElement errorMsg=driver.findElement(By.xpath("//div[@class='alert alert-danger']//li"));
        String message=errorMsg.getText();
        System.out.println(message);

        Assert.assertTrue(errorMsg.isDisplayed(),"Error message is not displayed");


       }

      @Test(priority = 3)
      public void EmptyFeildsLogin() {
      
      
      //Locate username field
      WebElement username=driver.findElement(By.xpath("//input[@id='username']"));


      //Locate Password field  
      WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
      
      //Locate login button and click on it
      WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log In']"));
      loginBtn.click();


      //Verifying the error message is displayed or not

      WebElement errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ul"));
      System.out.println(errorMsg.getText());

      Assert.assertTrue(errorMsg.isDisplayed(),"Error Message not displayed");

   
      }


      @Test(priority = 4)
      public void SpecialCharsAndInvalidFormat() {
      
      //Locate the username field and enter email with some special characters
      WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
      username.sendKeys("sonali#@gmail.com%m");
      
      //Locate the password field and enter password
      WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
      password.sendKeys("#Dummy@1234");
       

      //Locate the login button and  click
      WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log In']"));
      loginBtn.click();
       

      // comparing the expected and actual error message
      WebElement actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ul"));
      System.out.println(actualMsg.getText());

      String expectedMsg = "Please enter a correct username and password. Note that both fields may be case-sensitive.";

      Assert.assertEquals(actualMsg.getText(), expectedMsg);

      }


      
       @AfterMethod
       public void CloseBrowser(){
         //Close the browser 
        driver.quit();

       }
    
}
