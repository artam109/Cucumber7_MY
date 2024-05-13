package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage {
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setup;

    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countries;
    @FindBy(xpath = "//*[text()=\"Citizenships\"]")
    public WebElement citizenships;
    @FindBy(xpath = "//*[text()=\"Nationalities\"]")
    public WebElement nationalities;
    @FindBy(xpath = "//*[text()=\"Fees\"]")
    public WebElement fees;
    @FindBy(xpath = "(//span[text()='Inventory'])[1]")
    public WebElement inventory;
    @FindBy(xpath = "(//span[text()='Setup'])[4]")
    public WebElement inventorySetup;
    @FindBy(xpath = "(//span[text()='Item Categories'])[1]")
    public WebElement itemCategories;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    public WebElement entranceExams;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement subEntranceExams;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    public WebElement entranceSetup;
    @FindBy(xpath = "(//span[text()='States'])[1]")
    public WebElement states;

    public WebElement getWebElement(String strElement) {

        switch (strElement) {
            case "setup":
                return this.setup;
            case "parameters":
                return this.parameters;
            case "countries":
                return this.countries;
            case "citizenships":
                return this.citizenships;
            case "nationalities":
                return this.nationalities;
            case "fees":
                return this.fees;
            case "inventory":
                return this.inventory;
            case "inventorySetup":
                return this.inventorySetup;
            case "itemCategories":
                return this.itemCategories;
            case "entranceExams":
                return this.entranceExams;
            case "subEntranceExams":
                return this.subEntranceExams;
            case "entranceSetup":
                return this.entranceSetup;
            case "states":
                return this.states;
        }

        return null;
    }
}
