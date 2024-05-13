package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;

import io.cucumber.java.Scenario;


public class Hooks {


    @After // Cucumber Annotation'ı
    // her senaryodan sonra çalışır
    public void after(Scenario scenario) {

        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/CucumberTestResults.xlsx",
                scenario.getName() + " " + (scenario.isFailed() ? "Failed" : "Passed"));

        //senaryo fail olduysa ekran kaydı al
//        if (scenario.isFailed()) {
//            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
//            byte[] fileContent = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(fileContent, "image/png", "screenshot name");
//        }
        GWD.quitDriver();
    }

}
