import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LaunchingChromeTest {

    private WebDriver driver;
    @Before
    public void setup(){

        String pathToChromeDriver = "driver/newDriver/chromedriver";

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        driver = new ChromeDriver();

    }
 @Test
    public void naviagettoPage() {
     driver.navigate().to("http://the-internet.herokuapp.com/login");

     driver.findElement(By.id("username")).sendKeys("tomsmith");

     driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

     driver.findElement(By.className("radius")).click();

     String title = driver.findElement(By.cssSelector(".example h2")).getText();;

     assertThat(title, is("Secure Area not"));
    }
    @After
    public void teardown(){
        driver.close();
    }
}