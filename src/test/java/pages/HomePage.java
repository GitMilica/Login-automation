package pages;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Represents the home page of the application, which is displayed after a successful login.
 */
public class HomePage
{
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    @FindBy(id="flash")
    WebElement flashMessage;

    WebDriver driver;

    /**
     * Constructor that initializes the HomePage with the WebDriver instance and initializes
     * the WebElements using PageFactory.
     *
     * @param driver The WebDriver instance used to interact with the web page.
     */
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Initialized HomePage with WebDriver.");
    }

    /**
     * Verifies that the login was successful by checking the presence and content of the flash message.
     * Throws an assertion error if the login was not successful.
     */

    @Step("Verifying a successful login.")
    public void verifySuccessfulLogin()
    {
        logger.info("Waiting for the flash message to confirm successful login.");
        WebDriverWait WdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        logger.info("Flash message found.");
        logger.info("Verifying the flash message content: " + "You logged into a secure area!");
        Assertions.assertTrue(flashMessage.getText().contains("You logged into a secure area!"));
        logger.info("Login verification successful.");
    }


}
