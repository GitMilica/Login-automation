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
 * This class represents the login page of the application and provides methods
 * to interact with the login form, including entering the username, password,
 * clicking the login button, and verifying failed login attempts.
 */
public class LoginPage
{
    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    @FindBy(id="username")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(className="fa-sign-in")
    WebElement loginButton;

    @FindBy(id="flash")
    WebElement flashMessage;

    /**
     * Constructor to initialize the LoginPage object.
     *
     * @param driver The WebDriver instance used to interact with the web page.
     */

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
        logger.info("Initialized LoginPage with WebDriver.");
    }


    /**
     * Enters the provided username into the username field.
     *
     * @param username The username to be entered.
     * @return The current instance of LoginPage for method chaining.
     */

    @Step("Entering the username")
    public LoginPage setUsername(String username)
    {
        logger.info("Starting to enter username: " + username);
        usernameField.sendKeys(username);
        logger.info("Entered username: " + username);
        return this;
    }

    /**
     * Enters the provided password into the password field.
     *
     * @param password The password to be entered.
     * @return The current instance of LoginPage for method chaining.
     */

    @Step("Entering the password")
    public LoginPage setPassword(String password)
    {
        logger.info("Starting to enter password.");
        passwordField.sendKeys(password);
        logger.info("Entered password.");
        return this;
    }

    /**
     * Clicks the login button and navigates to the HomePage if the login is successful.
     *
     * @return A new instance of HomePage.
     */

    @Step("Clicking on login button")
    public HomePage clickOnLoginButton() {
        logger.info("Starting to click on the login button.");
        loginButton.click();
        logger.info("Clicked on the login button.");
        return new HomePage(driver);

    }

    /**
     * Verifies that the login attempt has failed by checking the flash message displayed on the page.
     *
     * @return The current instance of LoginPage for method chaining.
     */

    @Step("Verifying a failed login")
    public LoginPage verifyFailedLogin()
    {
        logger.info("Starting to verify failed login.");
        WebDriverWait WdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        logger.info("Flash message received: " + "Your username is invalid!");
        Assertions.assertTrue(flashMessage.getText().contains("Your username is invalid!"));
        logger.info("Verified failed login successfully.");
        return this;
    }

}

