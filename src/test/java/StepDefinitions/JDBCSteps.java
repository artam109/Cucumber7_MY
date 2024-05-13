package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;


public class JDBCSteps extends DBUtility {
    DialogContent dc = new DialogContent();

    @Then("Send The Query the Database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {

        for (int i = 0; i < getTable(query).size(); i++) {
            Assert.assertEquals(dc.stateNames.get(i).getText().trim(), getTable(query).get(i).get(0));

        }
    }


}
