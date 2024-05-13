package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _07_DataTableExample {
    @When("write username {string}")
    public void writeUsername(String username) {
        System.out.println(username);
    }

    @And("write username and password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.println(username + " " + password);
    }

    @And("write username as DataTable")
    public void writeUsernameAsDataTable(DataTable users) {
        List<String> userList = users.asList(String.class);

        for (String s : userList) {
            System.out.println("s = " + s);
        }

    }

    @And("write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable userTable) {
        List<List<String>> userList = userTable.asLists(String.class);

        for (int i = 0; i < userList.size(); i++) {
            // FOR PRINTING DATA TABLE VALUES
            System.out.println("table " + userList.get(i).get(0) + " " +
                    userList.get(i).get(1));
        }


    }

}
