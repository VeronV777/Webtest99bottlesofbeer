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


public class MovieTheatreTest {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    String url = "https://lm.skillbox.cc/qa_tester/module07/practice3/";

    @BeforeTest
    public void setUp(){
        driver.navigate().to(url);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testFavoriteMovie()  {
        String expectedResult = "Stranger things";
        driver.findElement(By.id("films")).sendKeys("Pretty woman");
        driver.findElement(By.id("serials")).sendKeys("Stranger things");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String actualResult =driver.findElement(By.id("best_serials")).getText();
                Assert.assertEquals(actualResult, expectedResult, "test fail");
    }
}
