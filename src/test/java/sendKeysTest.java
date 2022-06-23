
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sendKeysTest {
    private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    String chromeDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    @Test
    public void testSignGuestbook() throws InterruptedException{

        FirefoxDriver driver = new FirefoxDriver();
        String expectedResult = "Error: Error: Invalid security code.";
        System.setProperty(chromeDriver, driverPath);

        driver.get(BASE_URL);
        driver.findElement(By.linkText("Guestbook")).click();
        driver.findElement(By.linkText("Sign Guestbook")).click();

        driver.findElement(By.name("name")).click();
        // driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("12345"+ Keys.TAB);
        driver.findElement(By.name("location")).sendKeys("12345");
        driver.findElement(By.name("email")).sendKeys("12345"+ Keys.TAB);
        driver.findElement(By.name("homepage")).sendKeys("12345"+ Keys.TAB);
        driver.findElement(By.name("captcha")).sendKeys("12345"+ Keys.TAB);
        driver.findElement(By.name("comment")).sendKeys("12345"+ Keys.TAB);
        driver.findElement(By.name("submit")).click();

       // String actualResult = driver.findElement(By.name("Error:")).getText();
        String actualResult = driver.findElement(By.xpath(
                "//p[contains(., ' Error: Invalid security code.')]"
        )).getText();
       // String actualResult = driver.findElement(By.linkText(" Error: Invalid security code.")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
