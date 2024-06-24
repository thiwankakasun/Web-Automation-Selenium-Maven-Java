package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class SellAmendPage {

    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(LoginPage.class));
    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    private By amendBtn;
    private By amendQty;
    private By amendPrice;
    private By sellAmendPriceBtn;
    private By amendResetBtn;
    private By amendConfirmBtn;
    private By amendCancelBtn;

    public SellAmendPage() {
        ConfigLoader configLoader = new ConfigLoader();

        // Initialize locators from properties file
        amendBtn = getBy(configLoader.getObjectRepositoryProperty("amendBtn"));
        amendQty = getBy(configLoader.getObjectRepositoryProperty("amendQty"));
        amendPrice = getBy(configLoader.getObjectRepositoryProperty("amendPrice"));
        sellAmendPriceBtn = getBy(configLoader.getObjectRepositoryProperty("sellAmendPriceBtn"));
        amendResetBtn = getBy(configLoader.getObjectRepositoryProperty("amendResetBtn"));
        amendConfirmBtn = getBy(configLoader.getObjectRepositoryProperty("amendConfirmBtn"));
        amendCancelBtn = getBy(configLoader.getObjectRepositoryProperty("amendCancelBtn"));

//        logger.info(amendConfirmBtn.toString());
    }

//    //Capturing the order status (orderStatus_0 = QUEUED)
//    WebElement element = driver.findElement(By.xpath("//span[@class='font-sub bold orderStatus_0']"));
//		Thread.sleep(1000);
//
//    Actions actions = new Actions(driver); // Initialize Actions class
//		actions.contextClick(element).perform(); // Perform a right-click on the element
//		Thread.sleep(1000);

    //Click on Amend option
    public void clickAmendBtn() throws InterruptedException {
        driver.findElement(amendBtn).click();
    }

    //Enter the amend quantity
    public void setAmendQty() throws InterruptedException {
        driver.findElement(amendQty).sendKeys("100");

    }

    //Clear and enter the amend price
    public void setAmendPrice() throws InterruptedException {
        driver.findElement(amendPrice).click();
        driver.findElement(amendPrice).sendKeys("57");

    }

    //Click on Amend
    public void clickAmendPriceBtn() throws InterruptedException {
        driver.findElement(sellAmendPriceBtn).click();
    }

    //Reset order amending
    public void clickAmendResetBtn() {
        driver.findElement(amendResetBtn).click();
    }

    //Confirm Amend
    public void clickAmendConfirmBtn() {
        driver.findElement(amendConfirmBtn).click();
    }

    //Cancel Confirmation
    public void clickAmendCancelBtn() {
        driver.findElement(amendCancelBtn).click();
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
