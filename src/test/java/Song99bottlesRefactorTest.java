import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class Song99bottlesRefactorTest {

private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";
private void getbottles (StringBuilder lyrics, int number, String btl){
lyrics.append(number).append(btl);
}
    private void getNoMore (StringBuilder lyrics, String noMore, String btl){
        lyrics.append(noMore).append(btl);
    }

    private String createLyrics() {
         final String BOTTLES_WALL_CS = " bottles of beer on the wall, ";
        final String BOTTLES_WALL_DOT = " bottles of beer on the wall.";
        final String BOTTLES_DOTE_LN = " bottles of beer.\n";
        final String TAKE = "Take one down and pass it around, ";
        final String GO = "Go to the store and buy some more, ";
        final String NO_MORE = "No more";

        final String ln = "\n";
        StringBuilder lyrics = new StringBuilder();

        getbottles(lyrics, 99, BOTTLES_WALL_CS);
        getbottles(lyrics, 99, BOTTLES_DOTE_LN);
       // lyrics.append(99).append(BOTTLES_WALL_CS).append(99).append(BOTTLES_DOTE_LN);

        for (int i = 98; i > -1; i--) {
            lyrics.append(TAKE);
            if (i == 1) {
                getbottles(lyrics, i, BOTTLES_WALL_DOT.replace("s", ""));
                getbottles(lyrics, i, BOTTLES_WALL_CS.replace("s", ""));
                getbottles(lyrics, i, BOTTLES_DOTE_LN.replace("s", ""));
               // lyrics
                       // .append(TAKE)
                       // .append(i)
                        //.append(BOTTLES_WALL_DOT.replace("s", ""))
                       // .append(i)
                      //  .append(BOTTLES_WALL_CS.replace("s", ""))
                       // .append(i)
                       // .append(BOTTLES_DOTE_LN.replace("s", ""));
            } else if (i == 0) {
getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_WALL_DOT);
                getNoMore(lyrics, NO_MORE, BOTTLES_WALL_CS);
                getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOTE_LN);
               // lyrics
                     //   .append(TAKE)
                    //    .append(NO_MORE.toLowerCase())
                    //    .append(BOTTLES_WALL_DOT)
                     //   .append(NO_MORE)
                      //  .append(BOTTLES_WALL_CS)
                    //    .append(NO_MORE.toLowerCase())
                      //  .append(BOTTLES_DOTE_LN);
            } else {
                getbottles(lyrics, i, BOTTLES_WALL_DOT);
                getbottles(lyrics, i, BOTTLES_WALL_CS);
                getbottles(lyrics, i, BOTTLES_DOTE_LN);
               // lyrics
                      //  .append(TAKE)
                       // .append(i)
                        //.append(BOTTLES_WALL_DOT)
                       // .append(i)
                        //.append(BOTTLES_WALL_CS)
                       // .append(i)
                       // .append(BOTTLES_DOTE_LN);
            }
        }lyrics.append(GO).append(99).append(BOTTLES_WALL_DOT);

        return lyrics.toString();
    }

    @Test
    public void  testLyricsText1() throws InterruptedException{
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/usr/local/bin/chromedriver";
        String expectedResult = createLyrics();
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
By pTag = By.xpath("//div[@id='main']/p"); //locator
        By menuSongLyrics = By.linkText("Song Lyrics");
        driver.get(BASE_URL);

        driver.findElement(menuSongLyrics).click();
List<WebElement> pAll = driver.findElements(pTag);
StringBuilder actualResult = new StringBuilder();
Assert.assertFalse(pAll.isEmpty());
for(WebElement p : pAll) {
    actualResult.append(p.getText());
}

            Assert.assertEquals(actualResult.toString(), expectedResult);
            driver.quit();//close driver after test


        }

    }






