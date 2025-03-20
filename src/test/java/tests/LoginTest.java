package tests;
import Utils.WebDriverHandler;
import extensions.TestResultLoggerExtension;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.LoginPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Test class for verifying the login functionality of the application.
 * Inherits from WebDriverHandler to manage the WebDriver instance.
 */

@ExtendWith(TestResultLoggerExtension.class)
public class LoginTest extends WebDriverHandler {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);


    /**
     * Test to verify a successful login with valid credentials.
     */

    @Test
    @Description("Test to verify a successful login with valid credentials.")
    @Link(name = "HerokuApp", url = "https://the-internet.herokuapp.com/login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    public void SuccessfulLogin()
    {
        logger.info("Starting successful login test.");

        String url = "https://the-internet.herokuapp.com/login";
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        // Create instances of the page objects
        logger.info("Creating instances of LoginPage and HomePage.");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        logger.info("Instances of LoginPage and HomePage created.");

        // Navigate to the login page
        logger.info("Navigating to the login page.");
        driver.get(url);
        logger.info("Navigation to the login page completed.");

        // Perform login actions
        logger.info("Performing login with valid credentials.");
        loginPage.setUsername(username).setPassword(password).clickOnLoginButton();
        logger.info("Login actions performed.");

        // Verify successful login
        logger.info("Verifying successful login.");
        homePage.verifySuccessfulLogin();
        logger.info("Login was successful.");

    }

    /**
     * Test to verify a failed login with invalid credentials.
     */

    @Test
    @Description("Test to verify a failed login with invalid credentials.")
    @Link(name = "HerokuApp", url = "https://the-internet.herokuapp.com/login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("negative")
    public void FailedLogin()
    {

        String url = "https://the-internet.herokuapp.com/login";
        String username = "";
        String password = "SuperSecretPassword!";

        // Create an instance of the login page object
        logger.info("Creating instance of LoginPage.");
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Instance of LoginPage created.");

        // Navigate to the login page
        logger.info("Navigating to the login page.");
        driver.get(url);
        logger.info("Navigation to the login page completed.");


        // Perform login actions with incorrect credentials
        logger.info("Performing login actions with invalid username.");
        loginPage.setUsername(username).setPassword(password).clickOnLoginButton();
        logger.info("Login actions performed with invalid credentials.");

        logger.info("Verifying failed login.");
        loginPage.verifyFailedLogin();
        logger.info("Failed login verified.");
    }



}
