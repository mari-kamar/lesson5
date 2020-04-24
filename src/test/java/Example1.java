import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://otus.ru");
    }

    @AfterMethod
    public void closeDown() {
        driver.close();
    }

    @Test
    public void Cookies() {
//  Create cookies
        Cookie cookie1 = new Cookie("Otus1", "Value1");
        Cookie cookie2 = new Cookie("Otus2", "Value2");
        Cookie cookie3 = new Cookie("Otus3", "Value3");
        Cookie cookie4 = new Cookie("Otus4", "Value4");

//  Add cookies
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        System.out.println("---");

//  Show all cookies
        System.out.println(driver.manage().getCookies());
        System.out.println("---");

//  Show 1 cookie
        System.out.println(driver.manage().getCookieNamed("Otus1"));
        System.out.println("---");

//  Delete cookie with name Otus2
        driver.manage().deleteCookieNamed("Otus2");
    //  Check cookie was deleted
        System.out.println(driver.manage().getCookieNamed("Otus2"));
        System.out.println(driver.manage().getCookies());
        System.out.println("---");

//  Delete cookie using variable
        driver.manage().deleteCookie(cookie3);
     // Check cookie was deleted
        System.out.println(driver.manage().getCookieNamed("Otus3"));
        System.out.println(driver.manage().getCookies());

//  Delete all cookies
        driver.manage().deleteAllCookies();
    // Check all were deleted
        System.out.println(driver.manage().getCookies());
    }
}
