package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
    WebDriver driver;
    public SearchAmazon(){
        System.out.println("Constructor: SearchAmazon");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: SearchAmazon");
        driver.close();
        driver.quit();

    }

    public void Search(){
//         navigate to url  https://www.google.com/
driver.get("https://www.google.com/");
// Enter text in search textarea Using Locator "XPath" //textarea[@type="search"] |sendkeys("amazon")
WebElement searchbox=driver.findElement(By.xpath("//textarea[@type='search']"));
searchbox.sendKeys("amazon");
// click on google search button Using Locator "XPath" //input[@value="Google Search"]
driver.findElement(By.xpath("//input[@value='Google Search']")).click();
// validate amazon.in is displayed Using Locator "XPath" //span[text()='Amazon.in']
boolean displayed=driver.findElement(By.xpath("//span[text()='Amazon.in']")).isDisplayed();
System.out.println("Amazon.in is displayed: "+displayed);
// validate amazon.com is displayed Using Locator "XPath" //span[text()='Amazon.com']
 boolean displayed1=driver.findElement(By.xpath("//span[text()='Amazon.com']")).isDisplayed();   
System.out.println("Amazon.com is displayed: "+displayed1);
}
}
