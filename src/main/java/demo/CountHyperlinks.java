package demo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperlinks {
    WebDriver driver;
    public CountHyperlinks(){
       System.out.println("Constructor: CountHyperlinks");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver(); 
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    public void endTest()
    {
        System.out.println("End Test: CountHyperlinks");
        driver.close();
        driver.quit();

    }
    public void countLinks(){
        // navigate to url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // search all webelements with tag name a and stored in a list. Using Locator "Tag Name" a
        List<WebElement> urls=driver.findElements(By.tagName("a"));
        // To get a count of hyperlinks present on landing page use list size method.  list.size()
        //   list.size()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Total Numbers of urls: "+urls.size());
     

    }

}
