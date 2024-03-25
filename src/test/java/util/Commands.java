package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Commands {
    private static WebDriver driver;

    public Commands(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }
    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void switchToLastTab() {
        Set<String> acikPencereler = driver.getWindowHandles();
        String sonSekme = acikPencereler.toArray(new String[acikPencereler.size()])[acikPencereler.size() - 1];
        driver.switchTo().window(sonSekme);
    }
    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String script = "window.scrollTo(0, arguments[0] - window.innerHeight / 2);";
        ((JavascriptExecutor) driver).executeScript(script, element.getLocation().getY());
    }
    public static void Click(WebElement element) {
        waitForElementAndMoveToIt(element);
        try {
            element.click();
        } catch (Exception e) {
            JSClick(element);
        }
    }
    public static void JSClick(WebElement element) {
        waitForElementAndMoveToIt(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public static void SendKeys(WebElement element, String value) {
        waitForElementAndMoveToIt(element);
        element.sendKeys(value);
    }
    public static void waitForElementAndMoveToIt(WebElement element) {
        waitForPageLoad();
        waitForElement(element);
        moveToElement(element);
    }
}


