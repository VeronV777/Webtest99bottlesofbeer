import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest1 {
    @Test

    public void testMenuStartTypo() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/bin/chromedriver";
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
    public void testHeaderH1() throws InterruptedException {
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
    public void testMenuSubmitNewLanguage() throws InterruptedException {
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
    public void testSubmitNewLanguageSubmenu() throws InterruptedException {
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
    public void testSubmenuBrowseLanguages() throws InterruptedException {
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

    @Test
//TC_11_06 Подтвердите, что имена создателей сайта:
//Oliver Schade
//Gregor Scheithauer
//Stefan Scheler
    public void testSubmitNames() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement submenuTeam =
                driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));

        submenuTeam.click();
        WebElement teamOliver =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='main']/h3[contains(text(), 'Oliver Schade')]"
                        ));
        String actualResult1 = teamOliver.getText(); //read text
        Assert.assertEquals(actualResult1, expectedResult1);
        WebElement teamGregor =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='main']/h3[contains (text(), 'Gregor Scheithauer')]"
                        ));
        String actualResult2 = teamGregor.getText(); //read text
        Assert.assertEquals(actualResult2, expectedResult2);
        WebElement teamStefan =
                driver.findElement(By.xpath
                        ("//body/div[@id='wrap']/div[@id='main']/h3[contains (text(), 'Stefan Scheler')]"
                        ));
        String actualResult3 = teamStefan.getText(); //read text
        Assert.assertEquals(actualResult3, expectedResult3);
        driver.quit();


    }




    @Test
//TC_11_13 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html в первом пункте списка пользователь видит текст
//
//IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description),
// the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess
// around with fixing your descriptions etc. Thanks for your understanding.
//
//Шаги:
//1. Открыть вебсайт на странице
//2. Считать текст
//3. Подтвердить, что текст соответствует ожидаемому
//4. Закрыть браузер
    public void testFindTakeYourTime() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult1 = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), " +
                "the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement menuSubmitNewLanguage =
                driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"
                ));

        menuSubmitNewLanguage.click();

        WebElement textImortant =
                driver.findElement(By.xpath
                        (
                                "//li[contains(., 'IMPORTANT')]"
                        ));
        String actualResult1 = textImortant.getText(); //read text
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }

    @Test
    //TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь
    // увидит таблицу со следующими названиями для первого и второго столбцов:
    //Language
    //Author
    //
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Нажать на пункт меню Browse Languages
    //3. Считать названия первого и второго столбцов таблицы
    //3. Подтвердить, что названия соответствует ожидаемым
    //4. Закрыть браузер
    public void testFindFirstSecondColumn() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Language";
        String expectedResult2 = "Author";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")).click();

        WebElement columnLanguage =
                driver.findElement(By.xpath
                        (
                                "//th[contains(., 'Language')]"
                        ));

        String actualResult1 = columnLanguage.getText(); //read text
        Assert.assertEquals(actualResult1, expectedResult1);
        WebElement columnAuthor =
                driver.findElement(By.xpath
                        (
                                "//th[contains(., 'Author')]"
                        ));
        String actualResult2 = columnAuthor.getText(); //read text
        Assert.assertEquals(actualResult2, expectedResult2);
        driver.quit();
    }

    @Test
    //TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии, если нажмет на пункты меню Top List → New Comments
    //
    //Шаги:
    //Придумать самостоятельно.
    public void testFindNewComment() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']")).click();


        driver.findElement(By.xpath
                (
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./newcomments.html']"
                )).click();
//<a href="./newcomments.html">New Comments</a>
        WebElement newComment =
                driver.findElement(By.xpath
                        (
                                "//p[contains(., '')]"
                        ));
        String actualResult = newComment.getText(); //read text
        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();
    }

    @Test
    //TC_11_21 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html пользователь
// видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне, и что все буквы - capital
    //
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Считать слово IMPORTANT: из списка
    //3. Подтвердить requirenments
    //4. Закрыть браузер

    public void testFindImportant() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult1 = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), " +
                "the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);//open main page
        WebElement menuSubmitNewLanguage =
                driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"
                ));

        menuSubmitNewLanguage.click();

        WebElement textImortant =
                driver.findElement(By.xpath
                        (
                                "//li[contains(., 'IMPORTANT')]"
                        ));
        String actualResult1 = textImortant.getText(); //read text
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }



}


