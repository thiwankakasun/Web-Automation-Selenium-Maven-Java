package dfn.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.*;
import utils.ConfigLoader;
import utils.DriverManager;
import utils.EnvParameters;

public class BaseClass {
    public ConfigLoader ConfigLoader = new ConfigLoader();
    public String env = EnvParameters.ENV;
    public String loginurl = ConfigLoader.getTestDataProperty(env + ".url");
    public String userName = ConfigLoader.getTestDataProperty(env + ".username");
    public String password = ConfigLoader.getTestDataProperty(env + ".password");
    protected LoginPage loginPage;
    protected LogoutPage logoutPage;
    protected NavigationBarPage navigationBarPage;
    protected NewOrderBuyPage newOrderBuyPage;
    protected NewOrderSellPage newOrderSellPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        DriverManager.initializeDriver();
//        DriverManager.getDriver().get(loginurl);
        DriverManager.getDriver().manage().window().maximize();
        loginPage = new LoginPage();
        navigationBarPage = new NavigationBarPage();
        newOrderBuyPage = new NewOrderBuyPage();
        newOrderSellPage = new NewOrderSellPage();
        logoutPage = new LogoutPage();

    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
