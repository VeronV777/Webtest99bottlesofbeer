
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

public class PrivetVasiaTest {
    @Test

    public void inputTextTest() throws InterruptedException {
        String chromeDriver = "webdriver.gecko.driver";
        String driverPath = "/usr/local/bin/geckodriver";
        String url = "https://lm.skillbox.cc/qa_tester/module01/";
        String expectedResult = "Привет, Vasia!";
        System.setProperty(chromeDriver, driverPath);
        FirefoxDriver driver = new FirefoxDriver();

       // driver.get(url);
driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
WebElement inputName = driver.findElement(By.className("custom-form__field"));

inputName.sendKeys("Vasia");

              //  driver.findElement(By.xpath("//button[type='submit')]")).click();
       driver.findElement(By.className("button")).click();

        //   Thread.sleep(1000); //to pause
        WebElement readGreetingText = driver.findElement(By.className("start-screen__res"));
        String actualResult = readGreetingText.getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();//close driver after test


    }

}
