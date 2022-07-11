
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

public class PrivetVasiaTest {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";


    @BeforeTest
    public void setUp(){

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test

    public void inputTextTest() throws InterruptedException {

        String url = "https://lm.skillbox.cc/qa_tester/module01/";
        String expectedResult = "Привет, Vasia!";
        System.setProperty(firefoxDriver, driverPath);

        driver.navigate().to(url);
        WebElement inputName = driver.findElement(By.className("custom-form__field"));

        inputName.sendKeys("Vasia");


        driver.findElement(By.className("button")).click();

        //   Thread.sleep(1000); //to pause
        WebElement readGreetingText = driver.findElement(By.className("start-screen__res"));
        String actualResult = readGreetingText.getText();
        Assert.assertEquals(actualResult, expectedResult);



    }

    @Test
    public void emptyFormTest() throws InterruptedException {

        String url = "https://lm.skillbox.cc/qa_tester/module01/";
        String expectedResult = "Привет, !";
        System.setProperty(firefoxDriver, driverPath);

        driver.navigate().to(url);
               driver.findElement(By.className("button")).click();
        WebElement readGreetingText = driver.findElement(By.className("start-screen__res"));
        String actualResult = readGreetingText.getText();
        Assert.assertEquals(actualResult, expectedResult);


    }
    @Test
    public void fillFormTest() throws InterruptedException {

        String url = "https://lm.skillbox.cc/qa_tester/module02/homework1/";
        String expectedResult = "Здравствуйте, Ivan.\n" +
                "На вашу почту (aaa@gmail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 7777777777.";
        System.setProperty(firefoxDriver, driverPath);

        driver.navigate().to(url);
        driver.findElement(By.name("name")).sendKeys("Ivan");
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("7777777777");

        driver.findElement(By.xpath("//button[@class ='custom-form__button button']")).click();
        WebElement readGreetingText = driver.findElement(By.className("start-screen__res"));
        String actualResult = readGreetingText.getText();
        Assert.assertEquals(actualResult, expectedResult);


    }

}
