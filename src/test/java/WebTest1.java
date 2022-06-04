import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest1 {
@Test

    public void testMenuStartTypo () throws InterruptedException {
String chromeDriver = "webdriver.chrome.driver";
String driverPath = "/usr/local/bin/chromedriver";
String url = "https://www.99-bottles-of-beer.net/";
String expectedResult = "Welcome to 99 Bottles of Beer";
System.setProperty(chromeDriver, driverPath);
    WebDriver driver = new ChromeDriver();

    driver.get(url);//open main page
    WebElement menuBrowseLanguages =
            driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));
    //show path
menuBrowseLanguages.click();//open element
 //   Thread.sleep(1000); //to pause
    WebElement menuStart =
            driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']"));
    menuStart.click();
WebElement welcome = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
String actualResult = welcome.getText(); //read text
    Assert.assertEquals(actualResult, expectedResult);
  driver.quit();//close driver after test


    }
    @Test
//TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок 99 Bottles of Beer
//
//Шаги:
//1. Открыть вебсайт на базовой странице
//2. Считать заголовок в правом верхнем углу
//3. Подтвердить, что текст заголовка соответствует ожидаемому
//4. Закрыть браузер
    public void testHeaderH1 () throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement h1 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = h1.getText(); //read text
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();//close driver after test


    }
    @Test
//TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
//
//Шаги:
//1. Открыть вебсайт на базовой странице
//2. Считать название последнего пункта меню
//3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
//4. Закрыть браузер
    public void testMenuSubmitNewLanguage () throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "SUBMIT NEW LANGUAGE";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement menuSubmitNewLanguage =
                driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

       //menuSubmitNewLanguage.click();//open element
        String actualResult = menuSubmitNewLanguage.getText(); //read text
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }



}
