package my.home.cucumberpractice;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import my.home.cucumberpractice.utils.AllureUtils;
import my.home.cucumberpractice.utils.Utils;

import java.util.Properties;

public class CucumberHooks {

    @Before
    public void setUp(Scenario scenario) {
        Properties properties = Utils.readProperties("test.properties");
        Configuration.baseUrl = properties.getProperty("domain");
        Configuration.browser = System.getProperty("browser");
        Configuration.headless = Boolean.parseBoolean(properties.getProperty("headless"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            AllureUtils.makeScreenshot("Screenshot", WebDriverRunner.getWebDriver());
        }
        WebDriverRunner.closeWebDriver();
    }
}
