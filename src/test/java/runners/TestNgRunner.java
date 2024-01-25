package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "",
        plugin = {"pretty", "html:test-output", "html:target/cucumber-html-report.html", "json:target/json-output/cucumber.json"},
        monochrome = true)

public class TestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
