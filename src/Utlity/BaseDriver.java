package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    //WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(30));

    @BeforeClass
    public void baslangicIslemleri(){
        System.out.println("başlangıç işlemleri");
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //logintest();
    }

    void logintest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement id= driver.findElement(By.id("input-email"));
        id.sendKeys("ahmetcaner@gmail.com");
        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("şifre");
        WebElement login= driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();

    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }

//    public void sendKeysFunction(WebElement element, String yazi) {
//        waitUntilVisible(element);
//        scrollToElement(element);
//        element.clear();
//        element.sendKeys(yazi);
//    }
//    public void clickFunction(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        scrollToElement(element);
//        element.click();
//    }
//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", element);
//    }
//    public void waitUntilVisible(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
}
