package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    @Getter
    private static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            //Open via the Chrome browser
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();

            //Open via the incognito tab in Chrome browser
            ChromeOptions option = new ChromeOptions();
            option.addArguments("incognito");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
