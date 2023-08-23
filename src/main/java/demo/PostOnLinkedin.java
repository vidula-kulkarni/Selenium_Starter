package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PostOnLinkedin {
    WebDriver driver;
    public PostOnLinkedin(){
        System.out.println("Constructor: PostOnLinkedin");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: PostOnLinkedin");
        driver.close();
        driver.quit();

    }
    
    public void post() throws InterruptedException{
//         Navigate to the url  https://in.linkedin.com/ 
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
driver.findElement(By.xpath("//div[@class='t-16 t-black t-bold']")).click();
Thread.sleep(3000);
//profile viewers
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,650)", "");
Thread.sleep(5000);
WebElement impression=driver.findElement(By.xpath("//span[contains(text(),'post impressions')]"));
System.out.println("Impression of post: "+impression.getText());
driver.navigate().back();
Thread.sleep(3000);
//click on start a post button 
driver.findElement(By.xpath("//*[text()='Start a post']")).click();
// Enter text in to share Using Locator "XPath" //div[@class="ql-editor ql-blank"] | sendKeys("Test post")
Thread.sleep(3000);
driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]/p")).click();
driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]/p")).sendKeys("Test post 1");
Thread.sleep(2000);
// Clik on post button Using Locator "XPath" //span[text()="Post"]
driver.findElement(By.xpath("//span[text()='Post']")).click();
// check post is posted or not Using Locator "xpath"
Thread.sleep(2000);
WebElement posted=driver.findElement(By.xpath("//span[text()='Post successful.']"));
System.out.println("Post successful."+posted.isDisplayed());
}

}
