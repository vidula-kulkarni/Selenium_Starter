package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WindowHandle {
    WebDriver driver;
    public WindowHandle(){
       System.out.println("Constructor: WindowHandle");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: WindowHandle");
        driver.close();
        driver.quit();
    }
    
    public void windowhandletest() throws IOException{
        // Navigate to the url  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // Switch to the frame iframeResult.  switchTo().frame("iframeResult");
        driver.switchTo().frame("iframeResult");
        // Stored parent windowhandler in a string variable  getWindowHandle()
        String parentwindow=driver.getWindowHandle();
        // Click on 'Try it' button Using Locator "XPath" //button[text()="Try it"]
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        // Stores the open window handlers in a set  
        Set<String> windows=driver.getWindowHandles();
        // Using for loop and if loop we recognised a new wndow switch to child window.  switchTo().window(child)
        for (String openwin : windows) {
            if(!parentwindow.equalsIgnoreCase(openwin)){
                driver.switchTo().window(openwin);
                // Print the current url  getCurrentUrl()
                System.out.println("Current url: "+driver.getCurrentUrl());
               // Print the title  getTitle()
               System.out.println("Title of page: "+driver.getTitle());
              // Take Screenshot  getScreenshotAs(OutputType.FILE)
             Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
             ImageIO.write(s.getImage(),"PNG",new File("C:\\Users\\admin\\project\\selenium_starter\\fullPageScreenshot.png")); 
             // Close the new window  driver.close()
             driver.close();
            // Switch back to parent window  switchTo().window(parent)
            driver.switchTo().window(parentwindow);
            }
        }
        

    }

}
