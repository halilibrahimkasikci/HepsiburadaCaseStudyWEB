package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Commands;

public class LoginPage {
    private WebDriver driver;
    @FindBy(xpath = "//span[.='Giriş Yap']")
    private WebElement lblLoginButtonGroup;
    @FindBy(xpath = "//a[@id='login']")
    private WebElement btnLoginPage;
    @FindBy(xpath = "//input[@id='txtUserName']")
    private WebElement txtUserName;
    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement txtPassword;
    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement btnLogin;
    @FindBy(xpath = "//button[@id='btnEmailSelect']")
    private WebElement btnEmailSelect;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Kullanıcı adı: {0} , Şifre: {1} bilgileri ile giriş yapılır.")
    public void login(String username, String password) {
        Commands.Click(lblLoginButtonGroup);
        Commands.Click(btnLoginPage);
        Commands.waitForElement(txtUserName);
        Commands.SendKeys(txtUserName, username);
        Commands.Click(btnLogin);
        Commands.SendKeys(txtPassword, password);
        Commands.Click(btnEmailSelect);
    }

}
