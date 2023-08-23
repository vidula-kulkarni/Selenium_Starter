package demo;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PostImageOnLinkedIN {
    WebDriver driver;
    public PostImageOnLinkedIN(){
    System.out.println("Constructor: PostImageOnLinkedIN");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: PostImageOnLinkedIN");
        driver.close();
        driver.quit();

    }

    public void postImage() throws InterruptedException{
        // Navigate to the url  https://in.linkedin.com/ 
        driver.get("https://in.linkedin.com/");
        driver.navigate().refresh();
       // Enter Email or phone number Using Locator "ID" session_key |sendKeys("vidula.jobs@gmail.com")
       WebElement email=driver.findElement(By.id("session_key"));
       email.sendKeys("QualityBancbridge22@gmail.com");
       // Enter password Using Locator "ID" session_password | senkKeys("*********")
       WebElement password=driver.findElement(By.id("session_password"));
       password.sendKeys("Autolink1@");
       //Click on sign in button
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[text()='Start a post']")).click();
    Thread.sleep(2000);
      //  Click on Photo button Using Locator "XPath" (//button[@aria-label="Add a photo"])[1]
     driver.findElement(By.xpath("(//button[@aria-label='Add a photo'])[1]")).click();
    // Copy and select a image path and paste in dialog box using remote class or sendKeys  or using AutoIT tool Method.  C:\Users\admin\Desktop\image.png
    String path="C:\\Users\\admin\\Desktop\\image.png";
    WebElement photo=driver.findElement(By.xpath("//input[@name='file']"));
    photo.sendKeys(path);
    Thread.sleep(2000);
    // Actions action=new Actions(driver);
    // action.sendKeys(Keys.ESCAPE).build().perform();
    // Click on 'Done' button Using Locator "XPath" //*[text()="Done"]
    driver.findElement(By.xpath("//*[text()='Done']")).click();
    // Click on 'Post' button Using Locator "XPath" //*[text()="Post"]
    driver.findElement(By.xpath("//*[text()='Post']")).click();
    // Checking post is submitted successfuly Using Locator "XPath" //span[text()="Post successful."]
    Thread.sleep(2000);
    WebElement posted=driver.findElement(By.xpath("//span[text()='Post successful.']"));
    System.out.println("Post successful."+posted.isDisplayed()); 
   
    }
    
}
