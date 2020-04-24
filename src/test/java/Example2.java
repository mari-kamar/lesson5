import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Example2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://otus.ru");
    }

    @AfterMethod
    public void closeDown(){
        driver.close();
    }

    @Test
    public void TimeOuts() {
//  setting up implicit timeout for 30 sec and wait for otus chat
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //  trying to find window
        driver.findElement(By.xpath("//jdiv[@class=\"contentWrapper_Vr\"]"));

// setting up implicit timeout for 0 sec and wait for error
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    // reload page
        driver.navigate().refresh();
        driver.findElement(By.xpath("//jdiv[@class=\"contentWrapper_Vr\"]"));
    // test crashed

//  setting up waiting for load page in 30 sec
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


    }
}
