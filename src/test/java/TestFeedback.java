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



public class TestFeedback {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";

    @Test
    public void testFeedback() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        By nameLocator = By.cssSelector(".data.text");
        By emailLocator = By.cssSelector(".data.field");
        By commentfildLocator = By.cssSelector(".field.text");
        By buttonLocator = By.id("comment");
        By messageLocator = By.className("message-header");

        driver.findElement(nameLocator).sendKeys("Vasia");
        driver.findElement(emailLocator).sendKeys("test@test.io");
        driver.findElement(commentfildLocator).sendKeys("horror");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed(), "no message");
        driver.quit();
    }

    @Test
    public void testQuireForm() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        By fioLocator = By.cssSelector(".form-input.fio");
        By streetLocator = By.cssSelector(".data.form-input.street");
        By houseLocator = By.cssSelector(".form-input.house");
        By flatLocator = By.cssSelector(".form-input.flat");
        By dateLocator = By.cssSelector(".form-input.date");
        By buttonLocator = By.className("form-submit");
        By resultMessageLocator = By.className("form-result-description");
        driver.findElement(fioLocator).sendKeys("VVP");
        driver.findElement(streetLocator).sendKeys("Lenina");
        driver.findElement(houseLocator).sendKeys("16");
        driver.findElement(flatLocator).sendKeys("3");
        driver.findElement(dateLocator).sendKeys("1");
        driver.findElement(buttonLocator).click();
        String expectedResult = "Вы ввели следующие данные:";
        String actualResult = driver.findElement(resultMessageLocator).getText();
        Assert.assertEquals(actualResult, expectedResult, "test pass");
        driver.quit();
    }

    @Test
    public void testLoginForm() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        By emailLocator = By.cssSelector("#email");
        By passwordLocator = By.cssSelector("input#password");
        By buttonLocator = By.className("form-submit");
        By messageLocator = By.id("error");
        String expectedResult = "Некорректный email или пароль";
        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed(), "test pass");
        String actualResult = driver.findElement(messageLocator).getText();
        Assert.assertEquals(actualResult, expectedResult, "test pass");
        driver.quit();
    }
    @Test
    public void testLoginNewForm() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        By emailLocator = By.cssSelector("input#email");
        By passwordLocator = By.cssSelector("input.form-input.password");
        By buttonLocator = By.cssSelector("button#submit");
        By messageLocator = By.cssSelector("pre#error");
        String expectedResult = "Некорректный email или пароль";
        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed(), "test pass");
        String actualResult = driver.findElement(messageLocator).getText();
        Assert.assertEquals(actualResult, expectedResult, "test pass");
        driver.quit();
    }
}