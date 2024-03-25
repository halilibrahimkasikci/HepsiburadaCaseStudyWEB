package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Commands;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "//div[starts-with(@id,'SearchBox')]")
    private WebElement txtSearchDiv;
    @FindBy(xpath = "//div[.='Aramaya başlamak için en az 2 karakter yazmalısınız']")
    private WebElement txtStartSearching;
    @FindBy(xpath = "//div[starts-with(@id,'SearchBox')]//input")
    private WebElement txtSearchInput;
    @FindBy(xpath = "//div[contains(text(), 'ARA')]")
    private WebElement txtSearchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Sayfanın tamamen yüklendiği kontrol edilir.")
    public void pageIsLoaded() {
        Commands.waitForPageLoad();
    }
    @Step("Arama kutusuna {0} yazılır ve Ara butonuna tıklanır.")
    public void keywordSearch(String keyword) {
        Commands.Click(txtSearchDiv);
        Commands.waitForElement(txtStartSearching);
        Commands.SendKeys(txtSearchInput, keyword);
        Commands.Click(txtSearchButton);
    }
}
