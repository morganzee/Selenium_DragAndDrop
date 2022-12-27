package DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

public class DragAndDrop {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String browser = "CHROME";

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new EdgeDriver();
        }
            // URL
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
            //get browser title
        String getTitle = driver.getTitle();
        System.out.println("Page Title :" + getTitle);

            //Web element for the source
        WebElement source = driver.findElement(By.id("box3"));

            Thread.sleep(3000);
            //web element for the target
        WebElement target = driver.findElement(By.id("box103"));

            Thread.sleep(3000);
            // This action help to carry out the drag and drop action
        Actions builder = new Actions(driver);
            //This does the actual drag and drop
        //builder.dragAndDrop(source,target).build().perform();
            //What this does is drag from the source to the target hold for a bit and release we can use this or the code line above.
        builder.clickAndHold(source).
                pause(Duration.ofSeconds(2)).
                moveToElement(target).
                pause(Duration.ofSeconds(2)).
                release().build().perform();

            Thread.sleep(3000);
        driver.quit();

    }
}
