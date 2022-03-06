import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

        public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anna.romanovska\\webdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement searchField = driver.findElement(By.cssSelector("input#search-form__input"));
        searchField.sendKeys("Apple"+ Keys.ENTER);

        WebElement firstPhone = driver.findElement(By.xpath("//*[@data-product-id='4956273']"));
        // String itemWidth = firstPhone.getAttribute("offsetWidth");
        // System.out.println(itemWidth);
        String expectedResult = firstPhone.getText();
        System.out.println(expectedResult);

        firstPhone.click();

        WebElement buttonBuy = driver.findElement(By.id("product-buy-button"));
        buttonBuy.click();

        WebElement iteminBasket = (WebElement) driver.findElements(By.xpath("//*[@class='product__item']"));

        String actualResult = iteminBasket.getText();

        Assertions.assertEquals(expectedResult,actualResult);

        driver.quit();

        }

    }



