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



public class onlineTheatreTest {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";

    String url = "https://lm.skillbox.cc/qa_tester/module06/register/";
    @BeforeTest
    public void setUp(){
        driver.navigate().to(url);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void fillFormTest() throws InterruptedException {

        String expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        System.setProperty(firefoxDriver, driverPath);

        driver.findElement(By.id("name")).sendKeys("Ivan");
        driver.findElement(By.id("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.id("password")).sendKeys("qwerty!123");
        driver.findElement(By.xpath("//button[@class ='form-submit']")).click();
        String actualResult = driver.findElement(By.xpath("//p[@class ='form-result']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void emptyFormTest() throws InterruptedException {

        String expectedResult = "Введите имя";
        System.setProperty(firefoxDriver, driverPath);
        driver.findElement(By.xpath("//button[@class ='form-submit']")).click();
        String actualResult = driver.findElement(By.xpath("//p[@class ='form-error']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void findElements() throws InterruptedException {

        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        WebElement emailElement =driver.findElement(By.className("form-input"));
        WebElement passwordElement =driver.findElement(By.id("password"));
               WebElement confirmPasswordElement =driver.findElement(By.name("confirm_password"));
    }}
