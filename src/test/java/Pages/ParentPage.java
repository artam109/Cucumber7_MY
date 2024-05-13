package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ParentPage {
    public static WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));

    public void myClick(WebElement e){
        wait.until(ExpectedConditions.elementToBeClickable(e));
        scrollToElement(e);
        e.click();
    }

    public void mySendKeys(WebElement e, String txt){
        wait.until(ExpectedConditions.visibilityOf(e));
        e.click();
        e.sendKeys(Keys.TAB);
        scrollToElement(e);
        e.clear();
        e.sendKeys(txt);
    }

    public void scrollToElement(WebElement e){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", e);
    }


    public void verifyContainsText(WebElement e, String txt){
        wait.until(ExpectedConditions.textToBePresentInElement(e, txt));
        Assert.assertTrue(e.getText().toLowerCase().contains(txt.toLowerCase()));

        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

}
