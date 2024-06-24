package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.DriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class NewOrderMarketBuyPage {

	private WebDriver driver = DriverManager.getDriver();
	Logger logger = Logger.getLogger(String.valueOf(BuyAmendPage.class));
	Duration duration = Duration.ofSeconds(30);
	private WebDriverWait wait = new WebDriverWait(driver, duration);

	private By tradeWidget;
	private By symbolSearchClearBtn;
	private By orderTypeDropDownBtn;
	private By orderType_Market;
	private By qtyField;
	private By TIFBtn;
	private By TIFType_Day;
	private By TIFType_IOC;
	private By disclosedQtyField;
	private By minimumValueField;
	private By allOrNoneBtn;
	private By buyBtn;
	private By resetBtn;
	private By confirmBtn;

	public NewOrderMarketBuyPage() {
		ConfigLoader configLoader = new ConfigLoader();

		// Initialize locators from properties file
		tradeWidget = getBy(configLoader.getObjectRepositoryProperty("tradeWidget"));
		symbolSearchClearBtn = getBy(configLoader.getObjectRepositoryProperty("symbolSearchClearBtn"));
		orderTypeDropDownBtn = getBy(configLoader.getObjectRepositoryProperty("orderTypeDropDownBtn"));
		orderType_Market = getBy(configLoader.getObjectRepositoryProperty("orderType_Market"));
		qtyField = getBy(configLoader.getObjectRepositoryProperty("qtyField"));
		TIFBtn = getBy(configLoader.getObjectRepositoryProperty("TIFBtn"));
		TIFType_Day = getBy(configLoader.getObjectRepositoryProperty("TIFType_Day"));
		TIFType_IOC = getBy(configLoader.getObjectRepositoryProperty("TIFType_IOC"));
		disclosedQtyField = getBy(configLoader.getObjectRepositoryProperty("disclosedQtyField"));
		minimumValueField = getBy(configLoader.getObjectRepositoryProperty("minimumValueField"));
		allOrNoneBtn = getBy(configLoader.getObjectRepositoryProperty("allOrNoneBtn"));
		buyBtn = getBy(configLoader.getObjectRepositoryProperty("buyBtn"));
		resetBtn = getBy(configLoader.getObjectRepositoryProperty("resetBtn"));
		confirmBtn = getBy(configLoader.getObjectRepositoryProperty("confirmBtn"));

//        logger.info(loginBtn.toString());
	}

    //Navigating to Trade widget
	public void clickTradeWidget() {
		driver.findElement(tradeWidget).click();
	}

//    //Locating the text 'Buy'
//    WebElement element = driver.findElement(By.xpath("//span[text()='Buy']"));
//
//		if (element.isDisplayed()) {
//        System.out.println("Buy element is present");
//    }
//
//		else {
//        //Click the toggle
//        driver.findElement(By.xpath("//span[@class='simple-switch dark']")).click();
//        Thread.sleep(1000);
//    }

	//Clear the Symbol search field
	public void clearSymbolSearchField(){
		driver.findElement(symbolSearchClearBtn).clear();
	}

	//Search symbol
	public void setSearchSymbol(){
		driver.findElement(symbolSearchClearBtn).sendKeys("ABBANK`PB");
	}

	//Enter searched data
	public void searchSymbol(){
		driver.findElement(symbolSearchClearBtn).sendKeys(Keys.ENTER);
	}

	//Click on Order Type
	public void clickOrderType(){
		driver.findElement(orderTypeDropDownBtn).click();
	}

    //When Order Type = Market
	public void setOrderTypeAs_Market(){
		driver.findElement(orderType_Market).click();
	}

    //Define Quantity
	public void setQtyValue(){
		driver.findElement(qtyField).sendKeys("15");
	}

    //Click on TIF type
	public void clickTIF_TypeBtn(){
		driver.findElement(TIFBtn).click();
	}

	//When TIF = Day
	public void setTIFTypeAs_Day(){
		driver.findElement(TIFType_Day).click();
	}

	//When TIF = IOC
	public void setTIFTypeAs_IOC(){
		driver.findElement(TIFType_IOC).click();
	}

    //Define Disclosed qty
	public void setDisclosedQty(){
		driver.findElement(disclosedQtyField).sendKeys("5");
	}

    //Define Min Fill value
	public void setMinimumFillValue(){
		driver.findElement(minimumValueField).sendKeys("2");
	}

    //All or None
	public void clickAllOrNoneBtn(){
		driver.findElement(allOrNoneBtn).click();
	}

    //Click on Buy
	public void clickBuyBtn(){
		driver.findElement(buyBtn).click();
	}

	//Reset values
	public void clickResetBtn(){
		driver.findElement(resetBtn).click();
	}

	//Confirm order
	public void clickConfirmBtn(){
		driver.findElement(confirmBtn).click();
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