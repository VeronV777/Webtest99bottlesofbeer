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
    @Test
    //TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Нажать на пункт меню Submit new Language
    //3. Считать название подзаголовка последнего пункта меню
    //4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
    public void testSubmitNewLanguageSubmenu () throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement menuSubmitNewLanguage =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"
                        ));

        menuSubmitNewLanguage.click();//open element
        WebElement submenuSubmitNewLanguage =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"
                ));
        String actualResult = submenuSubmitNewLanguage.getText(); //read text
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }
    @Test
//TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт подменю называется 0-9
//
//Шаги:
//1. Открыть вебсайт на странице
//2. Считать название первого подзаголовка
//3. Подтвердить, что название подменю соответствует ожидаемому
//4. Закрыть браузер
    public void testSubmenuBrowseLanguages () throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "0-9";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement menuBrowseLanguages =
                driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));

        menuBrowseLanguages.click();
        WebElement submenuBrowseLanguages09 =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"
                        ));
        String actualResult = submenuBrowseLanguages09.getText(); //read text
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }



}




