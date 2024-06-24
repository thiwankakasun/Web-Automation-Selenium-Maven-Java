package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class NewOrderSellPage {

    Logger logger = Logger.getLogger(String.valueOf(NewOrderSellPage.class));
    Duration duration = Duration.ofSeconds(30);
    private final WebDriver driver = DriverManager.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, duration);

    private final By tradeWidget;
    private final By newOrderToggle;
    private final By symbolSearchClearBtn;
    private final By orderTypeDropDownBtn;
    private final By orderType_Limit;
    private final By orderType_Market;
    private final By qtyField;
    private final By priceField;
    private final By TIFBtn;
    private final By TIFType_Day;
    private final By TIFType_IOC;
    private final By TIFType_FOK;
    private final By TIFType_Session;
    private final By disclosedQtyField;
    private final By minimumValueField;
    private final By allOrNoneBtn;
    private By sellBtn;
    private final By resetBtn;
    private final By confirmBtn;

    public NewOrderSellPage() {
        ConfigLoader configLoader = new ConfigLoader();

        // Initialize locators from properties file
        tradeWidget = getBy(configLoader.getObjectRepositoryProperty("tradeWidget"));
        newOrderToggle = getBy(configLoader.getObjectRepositoryProperty("newOrderToggle"));
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
        sellBtn = getBy(configLoader.getObjectRepositoryProperty("sellBtn"));
        resetBtn = getBy(configLoader.getObjectRepositoryProperty("resetBtn"));
        confirmBtn = getBy(configLoader.getObjectRepositoryProperty("confirmBtn"));
        sellBtn = getBy(configLoader.getObjectRepositoryProperty("sellBtn"));

    }

    //Navigating to Trade widget
    public void clickTradeWidget() throws InterruptedException {
        driver.findElement(tradeWidget).click();
        Thread.sleep(1500);
    }

    //Select the toggle
    public void clickToggle() throws InterruptedException {
        driver.findElement(newOrderToggle).click();
        Thread.sleep(1500);
    }

    //Clear the Symbol search field
    public void clearSymbolSearchField() throws InterruptedException {
        driver.findElement(symbolSearchClearBtn).clear();
        Thread.sleep(1500);
    }

    //Search symbol
    public void setSearchSymbol() throws InterruptedException {
        driver.findElement(symbolSearchClearBtn).sendKeys("PDL`PB");
        Thread.sleep(1500);
    }

    //Enter searched data
    public void searchSymbol() throws InterruptedException {
        driver.findElement(symbolSearchClearBtn).sendKeys(Keys.ENTER);
        Thread.sleep(1500);
    }

    //Click on Order Type
    public void clickOrderType() throws InterruptedException {
        driver.findElement(orderTypeDropDownBtn).click();
        Thread.sleep(1500);
    }

    //When Order Type = Limit
    public void setOrderTypeAsLimit() throws InterruptedException {
        driver.findElement(orderType_Limit).click();
        Thread.sleep(1500);
    }

    //When Order Type = Market
    public void setOrderTypeAs_Market() {
        driver.findElement(orderType_Market).click();
    }

    //Clear Quantity
    public void clearQty() throws InterruptedException {
        driver.findElement(qtyField).click();
        Thread.sleep(1500);
    }

    //Define Quantity
    public void setQtyValue() throws InterruptedException {
        driver.findElement(qtyField).sendKeys("100");
        Thread.sleep(1500);
    }

    //Clear Price
    public void clearPrice() throws InterruptedException {
        driver.findElement(priceField).click();
        Thread.sleep(1500);
    }

    //Define Price
    public void setPriceValue() throws InterruptedException {
        driver.findElement(priceField).sendKeys("20.00");
        Thread.sleep(1500);
    }

    //Click on TIF type
    public void clickTIF_TypeBtn() throws InterruptedException {
        driver.findElement(TIFBtn).click();
        Thread.sleep(1500);
    }

    //When TIF = Day
    public void setTIFTypeAs_Day() throws InterruptedException {
        driver.findElement(TIFType_Day).click();
        Thread.sleep(1500);
    }

    //When TIF = IOC
    public void setTIFTypeAs_IOC() throws InterruptedException {
        driver.findElement(TIFType_IOC).click();
        Thread.sleep(1500);
    }

    //When TIF = FOK
    public void setTIFTypeAs_FOK() throws InterruptedException {
        driver.findElement(TIFType_FOK).click();
        Thread.sleep(1500);
    }

    //When TIF = Session
    public void setTIFTypeAs_Session() throws InterruptedException {
        driver.findElement(TIFType_Session).click();
        Thread.sleep(1500);
    }

    //Define Disclosed qty
    public void setDisclosedQty() throws InterruptedException {
        driver.findElement(disclosedQtyField).sendKeys("10");
        Thread.sleep(1500);
    }

    //Define Min Fill value
    public void setMinimumFillValue() throws InterruptedException {
        driver.findElement(minimumValueField).sendKeys("90");
        Thread.sleep(1500);
    }

    //All or None
    public void clickAllOrNoneBtn() throws InterruptedException {
        driver.findElement(allOrNoneBtn).click();
        Thread.sleep(1500);
    }

    //Click on Sell
    public void clickSellBtn() throws InterruptedException {
        driver.findElement(sellBtn).click();
        Thread.sleep(1500);
    }

    //Reset values
    public void clickResetBtn() throws InterruptedException {
        driver.findElement(resetBtn).click();
        Thread.sleep(1500);
    }

    //Confirm order
    public void clickConfirmBtn() throws InterruptedException {
        driver.findElement(confirmBtn).click();
        Thread.sleep(1500);
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
