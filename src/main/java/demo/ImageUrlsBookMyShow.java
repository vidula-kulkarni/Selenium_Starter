package demo;

import java.time.Duration;
//import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrlsBookMyShow {
   WebDriver driver;
    public ImageUrlsBookMyShow(){
        System.out.println("Constructor: ImageUrlsBookMyShow");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: ImageUrlsBookMyShow");
        driver.close();
        driver.quit();

    }

    public void imageUrl(){
        // navigate to url  https://in.bookmyshow.com/explore/home/chennai
       driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // get all img values in recommanded movies section and stored in list. Using Locator "XPath" //div[contains(@class,'YeNog')]/div/a/div/div/div/img
        List<WebElement> l=driver.findElements(By.xpath("//div[contains(@class,'YeNog')]/div/a/div/div/div/img"));
        // iterate through the list and get attribute value for src and print it.  getAttribute("src")
        System.out.println(l.size());
        for (WebElement movies : l) {
           System.out.println(movies.getAttribute("src"));
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        
         try{
            JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)", "");  
            
            Thread.sleep(5000);  
        // print the Name of the 2nd item in the Premiere list Using Locator "XPath" (//div[contains(@class,' iHsoLV')])[2] | getText()
        WebElement secondItem=driver.findElement(By.xpath("(//div[contains(@class,'iHsoLV')])[2]"));
        System.out.println("Name of the 2nd item in the Preniere list: "+secondItem.getText());
        // print Language of the  2nd item in the Premiere list Using Locator "XPath" (//div[contains(@class,' kHxEsI')])[2]
        WebElement seconItemLang=driver.findElement(By.xpath("(//div[contains(@class,'kHxEsI')])[2]"));
        System.out.println(seconItemLang.getText());
        }
        catch(Exception e){
            System.out.println("webpage not loaded completely.");
        }
    }

}
