package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import javax.tools.Tool;

public class _02_CountrySteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.countries);
    }

    @When("Create a country")
    public void createACountry() {
        String countryName = RandomStringUtils.randomAlphanumeric(8); // 8 harf ver
        String countryCode = RandomStringUtils.randomNumeric(4); // 4 rakam ver
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,countryName);
        dc.mySendKeys(dc.codeInput,countryCode);
        dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() throws InterruptedException {

        dc.verifyContainsText(dc.successMessage, "success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String country, String code) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,country);
        dc.mySendKeys(dc.codeInput,code);
        dc.myClick(dc.saveButton);
    }
}
