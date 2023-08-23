package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRatings {
    WebDriver driver;
    public IMDBRatings(){
        System.out.println("Constructor: IMDBRatings");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void endTest()
    {
        System.out.println("End Test: IMDBRatings");
        driver.close();
        driver.quit();

    }
    public void imdb() throws InterruptedException{
        // navigate to the url  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        // Filter is set as rating bydefault so first movie should be highest rated movie. Using Locator "XPath" (//div[contains(@class,"cli-children")]/div/a/h3)[1] | getText()
        WebElement highestRated=driver.findElement(By.xpath("(//div[contains(@class,'cli-children')]/div/a/h3)[1]"));
        System.out.println("Highest rated movie on IMDb: "+highestRated.getText());
        // Total number of movies included in table Using Locator "XPath" //span[contains(@class,"gtxTpS")] | getText()
        WebElement totalmovies=driver.findElement(By.xpath("//span[contains(@class,'gtxTpS')]"));
        System.out.println("Number of movies included in the table: "+totalmovies.getText());
        // Sort the movies by release date Using Locator "XPath" //select[@class="ipc-simple-select__input"] | Release date
        WebElement filter=driver.findElement(By.xpath("//select[@class='ipc-simple-select__input']"));
        Select select=new Select(filter);
        select.selectByVisibleText("Release date");
        Thread.sleep(3000);
        // Oldest movie in a list Using Locator "XPath" (//div[contains(@class,"cli-children")]/div/a/h3)[250]
        WebElement oldestMovie=driver.findElement(By.xpath("(//div[contains(@class,'cli-children')]/div/a/h3)[250]"));
        System.out.println("Oldest movie in a list: "+oldestMovie.getText());
        // Latest movie in a list Using Locator "XPath" (//div[contains(@class,"cli-children")]/div/a/h3)[1]
        WebElement latestMovie=driver.findElement(By.xpath("(//div[contains(@class,'cli-children')]/div/a/h3)[1]"));
        System.out.println("Latest movie in a list: "+latestMovie.getText());
        // sort the movies by number of user rating Using Locator "XPath" //select[@class="ipc-simple-select__input"] | Number of ratings
        select.selectByVisibleText("Number of ratings");
        Thread.sleep(3000);
        // print the higest rating movie Using Locator "ID" (//div[contains(@class,"cli-children")]/div/a/h3)[1]
        WebElement rated=driver.findElement(By.xpath("(//div[contains(@class,'cli-children')]/div/a/h3)[1]"));
        System.out.println("Higest rating movie: "+rated.getText());
    }






}
