import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Example {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(Example.class);

    @BeforeMethod
    public void setUp() {
        //download and setup way to driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Driver set up");

        //open website

    }

    @AfterMethod
    public void closeDown() {
        //close web browser
        if (driver != null) {
            driver.quit();
            logger.info("Page closed");
        }
    }

    @Test
    public void ExampleTest() {
        driver.get("https://otus.ru");
        logger.info("Page is open");
    }
}
