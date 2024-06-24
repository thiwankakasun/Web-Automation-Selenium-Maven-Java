package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.logging.Logger;

public class BuyCancelPage {
    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(BuyAmendPage.class));
    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    private By orderStatus;
    private By placedOrderCancelBtn;
    private By placedOrderResetBtn;
    private By selectedOrderCancelBtn;
    private By placedOrderConfirmCancellationBtn;
    private By placedOrderCancelConfirmationBtn;

    public BuyCancelPage() {
        ConfigLoader configLoader = new ConfigLoader();

        // Initialize locators from properties file
        orderStatus = getBy(configLoader.getObjectRepositoryProperty("orderStatus"));
        placedOrderCancelBtn = getBy(configLoader.getObjectRepositoryProperty("placedOrderCancelBtn"));
        placedOrderResetBtn = getBy(configLoader.getObjectRepositoryProperty("placedOrderResetBtn"));
        selectedOrderCancelBtn = getBy(configLoader.getObjectRepositoryProperty("selectedOrderCancelBtn"));
        placedOrderConfirmCancellationBtn = getBy(configLoader.getObjectRepositoryProperty("placedOrderConfirmCancellationBtn"));
        placedOrderCancelConfirmationBtn = getBy(configLoader.getObjectRepositoryProperty("placedOrderCancelConfirmationBtn"));
    }

    //Capturing the order status (orderStatus_0 = QUEUED)
    public void getBuyOrderStatus(){
        driver.findElement(orderStatus).getText();
    }

    public void rightClickOnPlacedBuyOrder(){
        WebElement Status = driver.findElement(orderStatus);
        Actions actions = new Actions(driver); // Initialize Actions class
		actions.contextClick(Status).perform(); // Perform a right-click on the element
    }

    //Click on Cancel option
    public void clickPlacedBuyOrderCancelBtn(){
        driver.findElement(placedOrderCancelBtn).click();
    }

    //Reset
    public void clickPlacedBuyOrderResetBtn(){
        driver.findElement(placedOrderResetBtn).click();
    }

    //Click on Order Cancel
    public void clickSelectedOrderCancelBtn(){
        driver.findElement(selectedOrderCancelBtn).click();
    }

    //Confirm Cancellation
    public void clickPlacedBuyOrderConfirmCancellationBtn(){
        driver.findElement(placedOrderConfirmCancellationBtn).click();
    }

    //Cancel Confirmation
    public void clickPlacedBuyOrderCancelConfirmationBtn(){
        driver.findElement(placedOrderCancelConfirmationBtn).click();
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
