package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _08_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable dt) {
        List<String> strLinkList = dt.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            // CLICK LEFT NAV ELEMENT
            ln.myClick(ln.getWebElement(strLinkList.get(i)));
        }

    }

    @And("Click on the Element in Dialog")
    public void clickOnTheElementInDialog(DataTable dt) {
        List<String> strLinkList = dt.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            // GET THE ELEMENT AND CLICK
            dc.myClick(dc.getWebElement(strLinkList.get(i)));
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dt) {
        List<List<String>> strLinkList = dt.asLists(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            // GET THE NECESSARY WEB ELEMENT
            WebElement txtBox = dc.getWebElement(strLinkList.get(i).get(0));
            // SEND KEYS TO THAT ELEMENT
            dc.mySendKeys(txtBox, strLinkList.get(i).get(1));
        }

    }

    @And("User delete the Element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dt) {
        List<String> strLinkList = dt.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            dc.deleteItem(strLinkList.get(i));
        }
    }
}
