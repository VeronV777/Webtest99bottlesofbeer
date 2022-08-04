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
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestFeedback {
    FirefoxDriver driver = new FirefoxDriver();
    String firefoxDriver = "webdriver.gecko.driver";
    String driverPath = "/usr/local/bin/geckodriver";
    @BeforeTest
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

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

    @Test
    public void testLoginNewForm2() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        By emailLocator = By.cssSelector("[data ='email']");
        By passwordLocator = By.cssSelector("[type='password']");
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

    @Test
    public void testBookStoreMainPage() throws InterruptedException {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        By aboutUsLocator = By.cssSelector("div.book-price");
        By aLinksLocator = By.cssSelector("[href='']");
        By bookPriceLocator = By.cssSelector("div.book-price");

        driver.findElement(aboutUsLocator);

        driver.findElements(aLinksLocator);
        driver.findElement(bookPriceLocator);

        driver.quit();
    }

    @Test
    public void testSocksClubFindElements() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        By footerMenuListFirstALocator = By.cssSelector("div.footer__menu > div.footer__menuList:nth-of-type(1) > a:nth-of-type(1)");
        driver.findElement(footerMenuListFirstALocator);

        driver.quit();
    }

    @Test
    public void testFindElements() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");

        //все теги div, которые являются дочерними элементами любого уровня для элемента <div class="pageCreate__cards">
        By pageCreateElementsLocator = By.cssSelector("div.pageCreate__cards div");
        //все элементы, которые находятся на первом уровне вложенности для элемента <div class="baseFooter">
        By baseFooterElementsLocator = By.cssSelector("div.baseFooter > *");
//ищете <div class="pageCreate">, внутри которого на первом уровне вложенности ищете
// <div class="pageCreate__cards">, внутри которого ищете на любом уровне вложенности теги <img>
        By pageCreateImgLocator = By.cssSelector("div.pageCreate div.pageCreate__cards img");
        //     первый <div class="baseCard pageCreate__card">, внутри которого на любом уровне вложенности найдите теги <p>
        By pageCreatePLocator = By.cssSelector("div.pageCreate div.pageCreate__cards > *:nth-child(1) p");
        driver.findElements(pageCreateElementsLocator);
        driver.findElements(baseFooterElementsLocator);
        driver.findElements(pageCreateImgLocator);
        driver.findElements(pageCreatePLocator);
        driver.quit();
    }

    @Test
    public void testOnlineCourses() {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qa.skillbox.ru/module16/16_2/");
        By buttonAddFirstCourseLocator = By.cssSelector("div.baseCard.pageCreate__card:nth-of-type(1) button");
        driver.findElement(buttonAddFirstCourseLocator);
        driver.quit();
    }
    @Test
    public void testOnlineTextbookAddNote()throws InterruptedException {
        System.setProperty(firefoxDriver, driverPath);
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        By buttonAllNotesPlusLocator = By.xpath("//button[@class='pageCreate__sidebarHeaderAdd']");
        By postTitleLocator = By.xpath("//input[@placeholder='Введите заголовок']");
        By postTextLocator = By.xpath("//textarea[@placeholder='Введите основной текст']");

        By buttonAddTextLocator = By.cssSelector("button.baseButton.popup__baseButton");
        By postTitleTextLocator = By.className("articlePreview__link");

        driver.findElement(buttonAllNotesPlusLocator).click();

        driver.findElement(postTitleLocator).sendKeys("My work");
        driver.findElement(postTextLocator).sendKeys("I love working");

       driver.findElement(buttonAddTextLocator).click();
        Assert.assertTrue(driver.findElement(postTitleTextLocator).isDisplayed(), "test pass");
        driver.quit();
    }

}