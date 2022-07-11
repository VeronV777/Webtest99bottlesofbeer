
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
public class HW12 {


    private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    String chromeDriver = "webdriver.chrome.driver";
    String driverPath = "/usr/bin/chromedriver";
    //TC_12_01 Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь может найти описание страницы, на которой перечеслены все программные языки, начинающиеся с буквы J,  отсортированные по названию
//
//Шаги:
//Открыть базовую страницу
//Нажать на пункт меню BROWSE LANGUAGES
//Нажать на подменю J
//Подтвердить, что пользователь видит текст “All languages starting with the letter J are shown, sorted by Language.”
    @Test
    public void testSortedByLanguagestext() throws InterruptedException {

        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        //By pTag = By.xpath("//div[@id='main']/p"); //locator
        //By menuSongLyrics = By.linkText("Song Lyrics");
        driver.get(BASE_URL);

        driver.findElement(By.xpath("//a[@href='/abc.html']")).click();
        // driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='j.html']")).click();
        driver.findElement(By.xpath("//a[@href='j.html']")).click();
        String actualResult = driver.findElement(By.xpath("//p[contains(.,'All languages')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    //TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
//
//Шаги:
//Открыть базовую страницу
//Нажать на пункт меню BROWSE LANGUAGES
//Нажать на подменю M
//Подтвердить, что последний язык программирования на странице - MySQL
    @Test
    public void testMSQL() throws InterruptedException {

        String expectedResult = "MySQL";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//a[@href='/abc.html']")).click();
        driver.findElement(By.xpath("//a[@href='m.html']")).click();
        driver.findElements(By.xpath("//table[@id='category']/a"));
        String actualResult = driver.findElement(By.xpath("//a[@href='language-mysql-1252.html']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    //TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица с заголовками Language, Author, Date, Comments, Rate
    @Test
    public void testBrowseLanguageTable() throws InterruptedException {

        String expectedResult = "LanguageAuthorDateCommentsRate";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();


        driver.get(BASE_URL);
        driver.findElement(By.xpath("//a[@href='/abc.html']")).click();
        List<WebElement> pAll = driver.findElements(By.xpath("//table[@id='category']/tbody/tr/th"));
        StringBuilder actualResult = new StringBuilder();

        for (WebElement p : pAll) {
            actualResult.append(p.getText());
        }
        Assert.assertEquals(actualResult.toString(), expectedResult);
        driver.quit();

    }

    //TC_12_04 Подтвердите, что создатель решения на языке Mathematica - Brenton Bostick,
// дата обновления решения на этом языке - 03/16/06, и что это решение имеет 1 комментарий
    @Test
    public void testMathematicaBrentonBostick() throws InterruptedException {

        String expectedResultLanguage = "Mathematica";
        String expectedResultAuthor = "Brenton Bostick";
        String expectedResultData = "03/16/06";
        String expectedResultComment = "1";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Browse Languages")).click();
        driver.findElement(By.linkText("M")).click();
        List<WebElement> trAll = driver.findElements(By.xpath("//table[@id='category']/tbody/tr"));
        List<String> actualResult = new ArrayList<>();
        for (WebElement tr : trAll) {
            if (tr.getText().contains("Mathematica")) {
                actualResult.add(tr.getText());
            }
        }
        Assert.assertEquals(actualResult.size(), 1);
        Assert.assertNotNull(actualResult);
        Assert.assertFalse(actualResult.get(0).isEmpty());
        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append(expectedResultLanguage)
                .append(" ")
                .append(expectedResultAuthor)
                .append(" ")
                .append(expectedResultData)
                .append(" ")
                .append(expectedResultComment);

        Assert.assertEquals(actualResult.get(0), expectedResult.toString());
        driver.quit();
    }

    //TC_12_05 Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
    @Test
    public void testNumericalLanguages() throws InterruptedException {

        int expectedResult = 10;
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Browse Languages")).click();
        driver.findElement(By.linkText("0-9")).click();
        List<WebElement> trAll = driver.findElements(By.xpath("//table[@id='category']/tbody/tr"));
        //List <String> result = new ArrayList<>();


        int actualResult = 0;
        for (WebElement tr : trAll) {
            Character ch = tr.getText().charAt(0);

            if (ch >= '0' && ch <= '9') {
                //System.out.println(ch);

                actualResult++;
                //System.out.println(actualResult);
            }
        }
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

@Test
public void testJavaLanguage() throws InterruptedException {

    int expectedResult = 5;
    System.setProperty(chromeDriver, driverPath);
    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);
    driver.findElement(By.linkText("Browse Languages")).click();
    driver.findElement(By.linkText("J")).click();
    List<WebElement> trAll = driver.findElements(By.xpath("//table[@id='category']/tbody/tr"));
    //List <String> result = new ArrayList<>();



    int actualResult = 0;
    for (WebElement tr : trAll) {
        if (tr.getText().contains("Java")){
         actualResult++;

               // System.out.println(actualResult);


    }}
    Assert.assertEquals(actualResult, expectedResult);
    driver.quit();
}
}