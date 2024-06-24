package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class PortfolioPage {

    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(NewOrderMarketSellPage.class));
    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    private By tradeWidget;
    private By portfolioWidget;
    private By cashAccountDropDown;
    private By cashAccountOption;

    public PortfolioPage() {
        ConfigLoader configLoader = new ConfigLoader();

        // Initialize locators from properties file
        tradeWidget = getBy(configLoader.getObjectRepositoryProperty("tradeWidget"));
        portfolioWidget = getBy(configLoader.getObjectRepositoryProperty("portfolioWidget"));
        cashAccountDropDown = getBy(configLoader.getObjectRepositoryProperty("cashAccountDropDown"));
        cashAccountOption = getBy(configLoader.getObjectRepositoryProperty("cashAccountOption"));
    }


    //Navigating to Trade widget
    public void clickTradeWidget() {
        driver.findElement(tradeWidget).click();
    }

    //Click on Portfolio tab
    public void clickPortfolioWidget() {
        driver.findElement(portfolioWidget).click();
    }

    //Click on Cash Acc dropdown
    public void clickCashAccDropDown() {
        driver.findElement(cashAccountDropDown).click();
    }

    //Select the Cash Acc
    public void selectCashAccOption() {
        driver.findElement(cashAccountOption).click();
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
