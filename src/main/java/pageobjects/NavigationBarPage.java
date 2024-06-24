package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class NavigationBarPage {

    private WebDriver driver = DriverManager.getDriver();
    Logger logger = Logger.getLogger(String.valueOf(NavigationBarPage.class));
    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait wait = new WebDriverWait(driver, duration);

    private By marketTab;
    private By tradeTab;
    private By quoteTab;
    private By topStocksTab;
    private By heatMapTab;
    private By newsTab;
    private By chartTab;

    public NavigationBarPage() {
        ConfigLoader configLoader = new ConfigLoader();

        marketTab = getBy(configLoader.getObjectRepositoryProperty("marketTab"));
        tradeTab = getBy(configLoader.getObjectRepositoryProperty("tradeTab"));
        quoteTab = getBy(configLoader.getObjectRepositoryProperty("quoteTab"));
        topStocksTab = getBy(configLoader.getObjectRepositoryProperty("topStocksTab"));
        heatMapTab = getBy(configLoader.getObjectRepositoryProperty("heatMapTab"));
        newsTab = getBy(configLoader.getObjectRepositoryProperty("newsTab"));
        chartTab = getBy(configLoader.getObjectRepositoryProperty("chartTab"));

    }

    //Navigate to Market tab
    public void navigateToMarketTab() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(marketTab));
        driver.findElement(marketTab).click();
        Thread.sleep(10000);
        logger.info("Successfully navigate to the Market Tab");
    }

    //Navigating to Trade tab
    public void navigateToTradeTab() throws InterruptedException {
        driver.findElement(tradeTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the Trade Tab");
    }

    //Navigating to Quote tab
    public void navigateToQuoteTab() throws InterruptedException {
        driver.findElement(quoteTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the Quote Tab");
    }

    //Navigating to Top Stocks tab
    public void navigateToTopStocksTab() throws InterruptedException {
        driver.findElement(topStocksTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the Top Stocks Tab");
    }

    //Navigating to Heat Map tab
    public void navigateToHeatMapTab() throws InterruptedException {
        driver.findElement(heatMapTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the Heat Map Tab");
    }

    //Navigating to News tab
    public void navigateToNewsTab() throws InterruptedException {
        driver.findElement(newsTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the News Tab");
    }

    //Navigating to Chart tab
    public void navigateToChartTab() throws InterruptedException {
        driver.findElement(chartTab).click();
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Successfully navigate to the Chart Tab");
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
