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



public class CatsAndDogsTest {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    private By emailLocator = By.className("email");
    private By writeTomeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-text");

private By radioButtonGirlLocator = By.id("girl");
    private By radioButtonBoyLocator = By.id("boy");
    private By writeYourEmailLocator = By.name("email");
    private By sendMeButtonLocator = By.id("sendMe");
    private By resultTextLocator = By.className("result-text");
    private By resultEmailTextLocator = By.className("your-email");
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testCats() throws InterruptedException {
        String url = "http://qajava.skillbox.ru/module04/lesson2/";
driver.get(url);
        driver.findElement(emailLocator).sendKeys("test@test.com");
        driver.findElement(writeTomeLocator).click();


       var actualResult = driver.findElement(resultEmailLocator).isDisplayed();
        Assert.assertEquals(true, actualResult, "message is not seen");
        Assert.assertTrue(actualResult, "message is not seen");
    }
    @Test
    public void testCatsEmtyEmail()  {
        String url = "http://qajava.skillbox.ru/module04/lesson2/";
        driver.get(url);
        driver.findElement(writeTomeLocator).click();
        var actualResult = driver.findElement(resultEmailLocator).getText();
      String expectedResult = "Когда можно будет забрать котёночка, мы вам сообщим на указанный e-mail:";
        Assert.assertEquals(actualResult, expectedResult, "wrong text");
    }
    @Test
    public void testDogsTextDisplayed()  {
        String url = "http://qajava.skillbox.ru/module04/lesson2/practice/";
        driver.get(url);
        driver.findElement(radioButtonBoyLocator).click();
        driver.findElement(writeYourEmailLocator).sendKeys("test@test.com");
        driver.findElement(sendMeButtonLocator).click();
        var actualResult = driver.findElement(resultTextLocator).isDisplayed();
        Assert.assertTrue(actualResult, "message is not seen");
    }
    @Test
    public void testDogsResultText()  {
        String url = "http://qajava.skillbox.ru/module04/lesson2/practice/";
        driver.get(url);
        driver.findElement(radioButtonGirlLocator).click();
        driver.findElement(writeYourEmailLocator).sendKeys("test@test.com");
        driver.findElement(sendMeButtonLocator).click();
        String actualResult = driver.findElement(resultTextLocator).getText();
        String expectedResult = "Хорошо, мы пришлём имя для вашей девочки на e-mail:";
        Assert.assertEquals(actualResult, expectedResult, "text is wrong");
    }
    @Test
    public void testDogsResultEmail()  {
        String url = "http://qajava.skillbox.ru/module04/lesson2/practice/";
        driver.get(url);
        driver.findElement(radioButtonBoyLocator).click();
        driver.findElement(writeYourEmailLocator).sendKeys("test@test.com");
        driver.findElement(sendMeButtonLocator).click();
        String actualResult = driver.findElement(resultEmailTextLocator).getText();
        String expectedResult = "test@test.com";
        Assert.assertEquals(actualResult, expectedResult, "wrong email");
    }
}
