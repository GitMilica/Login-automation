package Utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class WebDriverHandler {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterAll
    public static void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
