package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class NewOrderBuyPage {

    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(NewOrderBuyPage.class));
    Duration duration = Duration.ofSeconds(40);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    private By tradeWidget;
    private By newOrderToggle;
    private By buyOrderField;
    private By symbolSearchClearBtn;
    private By orderTypeDropDownBtn;
    private By orderType_Limit;
    private By orderType_Market;
    private By qtyField;
    private By priceField;
    private By TIFBtn;
    private By TIFType_Day;
    private By TIFType_IOC;
    private By TIFType_FOK;
    private By TIFType_Session;
    private By disclosedQtyField;
    private By minimumValueField;
    private By allOrNoneBtn;
    private By buyBtn;
    private By resetBtn;
    private By confirmBtn;

    public NewOrderBuyPage() {
        ConfigLoader configLoader = new ConfigLoader();

        tradeWidget = getBy(configLoader.getObjectRepositoryProperty("tradeWidget"));
        newOrderToggle = getBy(configLoader.getObjectRepositoryProperty("newOrderToggle"));
        buyOrderField = getBy(configLoader.getObjectRepositoryProperty("buyOrderField"));
        symbolSearchClearBtn = getBy(configLoader.getObjectRepositoryProperty("symbolSearchClearBtn"));
        orderTypeDropDownBtn = getBy(configLoader.getObjectRepositoryProperty("orderTypeDropDownBtn"));
        orderType_Limit = getBy(configLoader.getObjectRepositoryProperty("orderType_Limit"));
        orderType_Market = getBy(configLoader.getObjectRepositoryProperty("orderType_Market"));
        qtyField = getBy(configLoader.getObjectRepositoryProperty("qtyField"));
        priceField = getBy(configLoader.getObjectRepositoryProperty("priceField"));
        TIFBtn = getBy(configLoader.getObjectRepositoryProperty("TIFBtn"));
        TIFType_Day = getBy(configLoader.getObjectRepositoryProperty("TIFType_Day"));
        TIFType_IOC = getBy(configLoader.getObjectRepositoryProperty("TIFType_IOC"));
        TIFType_FOK = getBy(configLoader.getObjectRepositoryProperty("TIFType_FOK"));
        TIFType_Session = getBy(configLoader.getObjectRepositoryProperty("TIFType_Session"));
        disclosedQtyField = getBy(configLoader.getObjectRepositoryProperty("disclosedQtyField"));
        minimumValueField = getBy(configLoader.getObjectRepositoryProperty("minimumValueField"));
        allOrNoneBtn = getBy(configLoader.getObjectRepositoryProperty("allOrNoneBtn"));
        buyBtn = getBy(configLoader.getObjectRepositoryProperty("buyBtn"));
        resetBtn = getBy(configLoader.getObjectRepositoryProperty("resetBtn"));
        confirmBtn = getBy(configLoader.getObjectRepositoryProperty("confirmBtn"));
        confirmBtn = getBy(configLoader.getObjectRepositoryProperty("confirmBtn"));

    }

    //Navigating to Trade widget
    public void clickTradeWidget(){
        driver.findElement(tradeWidget).click();
        logger.info("Successfully navigate to the Trade Widget");
    }

    public String checkOrderBuyOrSell(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyOrderField));
        String buyOrder = driver.findElement(buyOrderField).getText();

        return buyOrder;
    }

    //Click the toggle
    public void clickOrderToggle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newOrderToggle));
        driver.findElement(newOrderToggle).click();
    }

    //Clear the Symbol search field
    public void clearSymbolSearchField() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(symbolSearchClearBtn));
        driver.findElement(symbolSearchClearBtn).clear();
        logger.info("Successfully clear the Symbol field");
        Thread.sleep(5000);
    }

    //Search symbol
    public void setSearchSymbol() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(symbolSearchClearBtn));
        driver.findElement(symbolSearchClearBtn).sendKeys("PDL`PB");
        logger.info("Successfully enter the Symbol");
        Thread.sleep(5000);
    }

    //Enter searched data
    public void searchSymbol() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(symbolSearchClearBtn));
        driver.findElement(symbolSearchClearBtn).sendKeys(Keys.ENTER);
        logger.info("Successfully search the Symbol");
        Thread.sleep(20000);
    }

    //Click on Order Type
    public void clickOrderType() throws InterruptedException {
       // WebElement DropDown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(orderTypeDropDownBtn));
        driver.findElement(orderTypeDropDownBtn).click();
        logger.info("Successfully click the Order Type Dropdown");
        Thread.sleep(5000);
//        Select dropdown = new Select(DropDown);
//
//        // Select an option by visible text
//        dropdown.selectByVisibleText("Limit");
    }

    //When Order Type = Limit
    public void setOrderTypeAsLimit() throws InterruptedException {

        driver.findElement(orderType_Limit).click();
        logger.info("Successfully select the Limit as Order Type");
        //wait.until(ExpectedConditions.elementToBeSelected(orderType_Limit));
        Thread.sleep(5000);
    }

    //When Order Type = Market
    public void setOrderTypeAs_Market(){
        driver.findElement(orderType_Market).click();
    }

    //Define Quantity
    public void setQtyValue() throws InterruptedException {

        driver.findElement(qtyField).sendKeys("10");
        logger.info("Successfully set the Qty");
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.numberOfElementsToBe((orderType_Limit),10));
    }

    //Clear Price
    public void clearPrice() throws InterruptedException {
        driver.findElement(priceField).click();
        Thread.sleep(5000);
    }

    //Define Price
    public void setPriceValue() throws InterruptedException {
        driver.findElement(priceField).sendKeys("26.00");
        Thread.sleep(5000);
    }

    //Click on TIF type
    public void clickTIF_TypeBtn() throws InterruptedException {
        driver.findElement(TIFBtn).click();
        Thread.sleep(5000);
    }

    //When TIF = Day
    public void setTIFTypeAs_Day() throws InterruptedException {
        driver.findElement(TIFType_Day).click();
        Thread.sleep(5000);
    }

    //When TIF = IOC
    public void setTIFTypeAs_IOC() throws InterruptedException {
        driver.findElement(TIFType_IOC).click();
        Thread.sleep(5000);
    }

    //When TIF = FOK
    public void setTIFTypeAs_FOK() throws InterruptedException {
        driver.findElement(TIFType_FOK).click();
        Thread.sleep(5000);
    }

    //When TIF = Session
    public void setTIFTypeAs_Session() throws InterruptedException {
        driver.findElement(TIFType_Session).click();
        Thread.sleep(5000);
    }

    //Define Disclosed qty
    public void setDisclosedQty() throws InterruptedException {
        driver.findElement(disclosedQtyField).sendKeys("5");
        Thread.sleep(5000);
    }

    //Define Min Fill value
    public void setMinimumFillValue() throws InterruptedException {
        driver.findElement(minimumValueField).sendKeys("2");
        Thread.sleep(5000);
    }

    //All or None
    public void clickAllOrNoneBtn() throws InterruptedException {
        driver.findElement(allOrNoneBtn).click();
        Thread.sleep(5000);
    }

    //Click on Buy
    public void clickBuyBtn() throws InterruptedException {
        driver.findElement(buyBtn).click();
        Thread.sleep(5000);
    }

    //Reset values
    public void clickResetBtn() throws InterruptedException {
        driver.findElement(resetBtn).click();
        Thread.sleep(5000);
    }

    //Confirm order
    public void clickConfirmBtn() throws InterruptedException {
        driver.findElement(confirmBtn).click();
        Thread.sleep(5000);
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
