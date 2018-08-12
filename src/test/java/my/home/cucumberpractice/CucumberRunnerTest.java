package my.home.cucumberpractice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "classpath:features",
        plugin = {
                "pretty", "json:build/Cucumber.json",
                "html:build/cucumber-html-report"
        }
)
public class CucumberRunnerTest {

}