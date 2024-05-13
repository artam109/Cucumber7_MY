package Pages;

import Utilities.GWD;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends ParentPage {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[formcontrolname= 'username']")
    public WebElement username;
    @FindBy(css = "[formcontrolname= 'password']")
    public WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginBtn;
    @FindBy(css = "span[class=\"mat-mdc-tooltip-trigger logo-text\"]")
    public WebElement headText;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    public WebElement codeInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement shortName;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'already')]")
    public WebElement alreadyExist;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement deleteButton;
    @FindBy(css = "[data-placeholder='Name']")
    public WebElement searchPlc;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement dialogDelBtn;
    @FindBy(xpath = "//div[@class='control-full']/button")
    public WebElement searchButton;
    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'INTEGRATION_CODE')]/input")
    public WebElement integrationCode;
    @FindBy(xpath = "//ms-integer-field[contains(@placeholder,'PRIORITY')]/input")
    public WebElement priorityInput;
    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    public WebElement toggleBar;
    @FindBy(css = "div[class=\"mat-chip-list-wrapper\"]")
    public WebElement userType;
    @FindBy(xpath = "//span[text()=' Student ']")
    public WebElement student;
    @FindBy(xpath = "//span[text()=' Administrator ']")
    public WebElement administrator;
    @FindBy(css = "mat-select[formcontrolname=\"academicPeriod\"]")
    public WebElement academicPeriod;
    @FindBy(css = "mat-option:nth-child(1)")
    public WebElement firstMatOption;
    @FindBy(xpath = "//span[contains(text(),' Internship  ')]")
    public WebElement internship;
    @FindBy(xpath = "//mat-select//span[contains(text(),'Grade Level')]")
    public WebElement gradeLevel;
    @FindBy(xpath = "//span[contains(text(),' New Exam ')]")
    public WebElement newExamBar;
    @FindBy(css = "tbody[role=\"rowgroup\"] tr > td:nth-child(2)")
    public List<WebElement> stateNames;

    public void deleteItem(String name) {
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        mySendKeys(searchPlc, name);
        myClick(searchButton);

        //search butonun tıklanabilir olana kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        myClick(deleteButton);
        myClick(dialogDelBtn);
    }

    public WebElement getWebElement(String e) {

        switch (e) {
            case "addButton":
                return this.addButton;
            case "nameInput":
                return this.nameInput;
            case "codeInput":
                return this.codeInput;
            case "saveButton":
                return this.saveButton;
            case "shortName":
                return this.shortName;
            case "priorityInput":
                return this.priorityInput;
            case "integrationCode":
                return this.integrationCode;
            case "toggleBar":
                return this.toggleBar;
            case "userType":
                return this.userType;
            case "student":
                return this.student;
            case "administrator":
                return this.administrator;
            case "academicPeriod":
                return this.academicPeriod;
            case "internship":
                return this.internship;
            case "firstMatOption":
                return this.firstMatOption;
            case "gradeLevel":
                return this.gradeLevel;
            case "newExamBar":
                return this.newExamBar;
        }
        return null;
    }

    public String generateRandomWord() {
        int length = 7;
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomWord(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
