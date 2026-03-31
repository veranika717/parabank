package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    private static final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";
    private static final String VALID_USERNAME = "john";
    private static final String VALID_PASSWORD = "demo";
    private static final String INVALID_USERNAME = "wronguser";
    private static final String INVALID_PASSWORD = "wrongpass";

    private static final By USERNAME_FIELD = By.name("username");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[value='Log In']");
    private static final By REGISTER_LINK = By.linkText("Register");
    private static final By FORGOT_LINK = By.linkText("Forgot login info?");
    private static final By ERROR_MESSAGE = By.xpath("//*[contains(text(), 'error') or contains(text(), 'could not be verified')]");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void openLoginPageTest() {
        String title = driver.getTitle();
        assertTrue(title.contains("ParaBank"));
    }

    @Test
    void loginFieldsExistTest() {
        boolean usernameField = driver.findElement(USERNAME_FIELD).isDisplayed();
        boolean passwordField = driver.findElement(PASSWORD_FIELD).isDisplayed();
        assertTrue(usernameField);
        assertTrue(passwordField);
    }

    @Test
    void loginButtonExistsTest() {
        boolean loginButton = driver.findElement(LOGIN_BUTTON).isDisplayed();
        assertTrue(loginButton);
    }

    @Test
    void usernameFieldAcceptsTextTest() {
        String testText = "testuser";
        driver.findElement(USERNAME_FIELD).sendKeys(testText);

        String enteredText = driver.findElement(USERNAME_FIELD).getAttribute("value");
        assertTrue(enteredText.contains(testText),
                "Username field should display entered text");
    }


    @Test
    void successfulLoginTest() {
        driver.findElement(USERNAME_FIELD).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(VALID_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        assertTrue(driver.getCurrentUrl().contains("overview"));
    }

    @Test
    void failedLoginTest() {
        driver.findElement(USERNAME_FIELD).sendKeys(INVALID_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(INVALID_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();

        assertTrue(driver.getCurrentUrl().contains("index.htm") ||
                driver.getCurrentUrl().contains("parabank"));

        boolean errorMessage = driver.findElement(ERROR_MESSAGE).isDisplayed();
        assertTrue(errorMessage);
    }


    @Test
    void registerLinkTest() {
        driver.findElement(REGISTER_LINK).click();
        assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @Test
    void forgotLoginInfoLinkTest() {
        driver.findElement(FORGOT_LINK).click();
        assertTrue(driver.getCurrentUrl().contains("lookup"));
    }

    @Test
    void enterKeySubmissionTest() {
        driver.findElement(USERNAME_FIELD).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(VALID_PASSWORD);

        driver.findElement(PASSWORD_FIELD).submit();

        assertTrue(driver.getCurrentUrl().contains("overview"),
                "User should be logged in after pressing Enter key");
    }
}