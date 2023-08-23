package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPrompt {
    WebDriver driver;
    public AlertPrompt(){
            System.out.println("Constructor: AlertPrompt");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: AlertPrompt");
        driver.close();
        driver.quit();

    }

    public void alerts(){
        // Navigate to the url  https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // Switch to the child frame iframeResult.  switchTo().frame("iframeResult")
        driver.switchTo().frame("iframeResult");
        // Click on 'Try it' button Using Locator "XPath" //button[text()='Try it']
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        // Switch to alert and enter your name in textbox  //button[text()='Try it']
        driver.switchTo().alert().sendKeys("Vidula Kulkarni");
        // Accept the alert.  switchTo().alert().accept()
        driver.switchTo().alert().accept();
        // Check name is printed  Using Locator "XPath" //p[@id='demo'] |getText().contains("vidula kulkarni")
        WebElement text=driver.findElement(By.xpath("//p[@id='demo']"));
        System.out.println("Vidula Kulkarni is present: "+text.getText().contains("Vidula Kulkarni"));
    }
}
