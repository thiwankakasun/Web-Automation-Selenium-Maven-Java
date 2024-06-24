package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class LogoutPage {
    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(LogoutPage.class));

    private By logoutBtn;

    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    public LogoutPage(){
        ConfigLoader configLoader = new ConfigLoader();

        logoutBtn = getBy(configLoader.getObjectRepositoryProperty("logoutBtn"));
    }

    //CLick on the Logout Button
    public void clickLogout() {
        waitUntilLogoutButtonIsVisible();
        driver.findElement(logoutBtn).click();
        logger.info("Successfully Logout from the application");
    }

    //Wait until loading the Login Button
    public void waitUntilLogoutButtonIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
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
