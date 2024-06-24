package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class LoginPage {

    Logger logger = Logger.getLogger(String.valueOf(LoginPage.class));
    Duration duration = Duration.ofSeconds(30);
    private final WebDriver driver = DriverManager.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, duration);

    private final By usernameField;
    private final By passwordField;
    private final By acceptTermsBtn;
    private final By loginBtn;
    private final By rememberMeBtn;
    private final By brandLogoImg;
    private final By errorMsg1;

    public LoginPage() {
        ConfigLoader configLoader = new ConfigLoader();

        // Initialize locators from properties file
        usernameField = getBy(configLoader.getObjectRepositoryProperty("usernameField"));
        passwordField = getBy(configLoader.getObjectRepositoryProperty("passwordField"));
        acceptTermsBtn = getBy(configLoader.getObjectRepositoryProperty("acceptTermsBtn"));
        rememberMeBtn = getBy(configLoader.getObjectRepositoryProperty("rememberMeBtn"));
        loginBtn = getBy(configLoader.getObjectRepositoryProperty("loginBtn"));
        brandLogoImg = getBy(configLoader.getObjectRepositoryProperty("brandLogoImg"));
        errorMsg1 = getBy(configLoader.getObjectRepositoryProperty("errorMsg1"));
    }

    public void loadPage(String loginUrl) throws InterruptedException {
        driver.get(loginUrl);
        logger.info("Successfully navigate to the " + loginUrl);
        Thread.sleep(5000);
    }

    //Enter the username
    public void setUsername(String userName) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(userName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully enter the Username " + userName);
        Thread.sleep(5000);
    }

    //Enter the password
    public void setPassword(String password) throws InterruptedException {
        driver.findElement(passwordField).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully enter the Password " + password);
        Thread.sleep(5000);
    }

    //Click on the Accept Terms button
    public void clickAcceptTermsBtn() throws InterruptedException {
        driver.findElement(acceptTermsBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully click the Accept Terms Button");
        Thread.sleep(5000);
    }

    //Click on the Remember Me button
    public void clickRememberMeBtn() throws InterruptedException {
        driver.findElement(rememberMeBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully click the Remember Me Button");
        Thread.sleep(5000);
    }

    //Click on the Login button
    public void clickLogin() throws InterruptedException {
        driver.findElement(loginBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully click the Login Button");
        Thread.sleep(5000);
    }

    //Click on the Login button
    public String checkIncorrectUserNameOrPasswordErrorMsg() throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(errorMsg1, "User name or password incorrect"));
        String errorMsg = driver.findElement(errorMsg1).getText();
        logger.info("User name or password incorrect message is not displayed");
        Thread.sleep(5000);

        return errorMsg;
    }

    // Check the loading image
    public boolean checkLoadingImage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandLogoImg));
        WebElement imageElement = driver.findElement(brandLogoImg);
        logger.info("Successfully Login to the City Bangladesh UA application");
        Thread.sleep(5000);

        return imageElement.isDisplayed();
    }


    private By getBy(String locator) {
        String[] parts = locator.split(":", 2);
        String type = parts[0];
        String value = parts[1];

        switch (type) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "className":
                return By.className(value);
            case "tagName":
                return By.tagName(value);
            case "css":
                return By.cssSelector(value);
            case "xpath":
                return By.xpath(value);
            case "linkText":
                return By.linkText(value);
            case "partialLinkText":
                return By.partialLinkText(value);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + type);
        }
    }
}
