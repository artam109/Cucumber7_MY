package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = true, // true olduğunda testleri çalıştırmaz, sadece STEPleri var mı diye kontrol eder
        plugin = {"html:target/site/cucumber-pretty.html"} //basit report
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}


