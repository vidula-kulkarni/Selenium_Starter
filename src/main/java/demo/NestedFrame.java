package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {
    WebDriver driver;
    public NestedFrame(){
       System.out.println("Constructor: NestedFrame");
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: NestedFrame");
        driver.close();
        driver.quit();

    }
    
    public void nested(){
// Navigate to the url  https://the-internet.herokuapp.com/nested_frames
driver.get("https://the-internet.herokuapp.com/nested_frames");
// Switch to parent top frame.  switchTo().frame("frame-top")
driver.switchTo().frame("frame-top");
// Switch to child Left frame.  switchTo().frame("frame-left")
driver.switchTo().frame("frame-left");
// print the text present in left frame   "xpath" "/html/body"
System.out.println(driver.findElement(By.xpath("/html/body")).getText());
// Switch back to parent frame  switchTo().frame("frame-top")
driver.switchTo().parentFrame();
// Switch to child Middle frame.  switchTo().frame("frame-middle")
driver.switchTo().frame("frame-middle");
// print the text present in middle frame   "id" "content" | getText()
System.out.println(driver.findElement(By.id("content")).getText());
// Switch back to parent frame  switchTo().frame("frame-top")
driver.switchTo().parentFrame();
// Switch to child Right frame.  switchTo().frame("frame-right")
driver.switchTo().frame("frame-right");
// print the text present in right frame   "xpath" "/html/body"
System.out.println(driver.findElement(By.xpath("/html/body")).getText());
// Switch back to default frame  switchTo().defaultContent()
driver.switchTo().defaultContent();
// Switch to bottom frame.  switchTo().frame("frame-bottom")
driver.switchTo().frame("frame-bottom");
// print the text present in bottom frame   "xpath" "/html/body"
System.out.println(driver.findElement(By.xpath("/html/body")).getText());
   

}

    
}
