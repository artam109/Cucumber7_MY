package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _03_CitizenShip {

    private static String randWord;
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenships")
    public void navigateToCitizenships() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenships);

    }

    @When("Create a citizenship")
    public void createACitizenship() {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,dc.generateRandomWord());
        dc.mySendKeys(dc.shortName,dc.generateRandomWord(3));
        dc.myClick(dc.saveButton);
    }

    @When("Create a citizenship name as {string} shortname as {string}")
    public void createACitizenshipNameAsShortnameAs(String name, String shortname) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortName,shortname);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyExist, "already");
    }

    @When("user delete name as {string}")
    public void userDeleteNameAs(String name) {
        dc.deleteItem(name);
    }

    @And("User sending random word to Dialog")
    public void userSendingRandomWordToDialog(DataTable dt) {
        List<String> list = dt.asList(String.class);
        randWord = dc.generateRandomWord();
        for (String str : list){
            dc.mySendKeys(dc.getWebElement(str), randWord);
        }
    }

    @And("User delete the random created Element from Dialog")
    public void userDeleteTheRandomCreatedElementFromDialog() {
        dc.deleteItem(randWord);
    }
}
