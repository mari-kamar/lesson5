import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example3 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeDown() {
        driver.close();
    }

    @Test
    public void Windows() {
//  open full size
        driver.manage().window().maximize();

    // open 1 time
        driver.get("https://otus.ru");

//  open extension 800 on 600
        driver.manage().window().setSize(new Dimension(800, 600));
        System.out.println(driver.manage().window().getPosition());

//  open in 800 on 600 and pass through 4 corners
        driver.manage().window().setSize((new Dimension(800,600)));
        System.out.println(driver.manage().window().getPosition());

        driver.manage().window().setPosition(new Point(0,100));
        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setPosition(new Point(100,0));
        driver.manage().window().setPosition(new Point(0,0));

    }
}
