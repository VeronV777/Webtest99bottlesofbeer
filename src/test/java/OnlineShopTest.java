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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OnlineShopTest {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    String url = "https://lm.skillbox.cc/qa_tester/module03/practice1/";

    @BeforeTest
    public void setUp(){
        driver.navigate().to(url);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testGiveSize() throws InterruptedException {
        String expectedResult = "В нашем магазине есть обувь вашего размера";
            driver.findElement(By.tagName("input")).sendKeys("34");
        driver.findElement(By.id("check-size-button")).click();
        String actualResult = driver.findElement(By.className("error")).getText();
        Assert.assertEquals(actualResult, expectedResult);
}
    @Test
    public void testGiveWrongSize()  {
        String expectedResult = "В нашем магазине нет обуви вашего размера";
        driver.findElement(By.tagName("input")).sendKeys("0");
        driver.findElement(By.id("check-size-button")).click();
        String actualResult = driver.findElement(By.id("size-error")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
