import java.io.IOException;
import java.util.List;

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


public class OnlineBookStore {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    String url = "http://qajava.skillbox.ru/";

    @BeforeTest
    public void setUp(){
        driver.navigate().to(url);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void giveSize() throws InterruptedException {
        int expectedResult = 15;

        List<WebElement> divBookInfo = driver.findElements(By.className("book-info"));
int actualResult = divBookInfo.size();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
