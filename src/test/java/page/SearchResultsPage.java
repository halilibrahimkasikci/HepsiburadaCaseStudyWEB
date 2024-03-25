package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Commands;
import java.util.List;
import java.util.Random;

public class SearchResultsPage {
    private WebDriver driver;
    @FindBy(xpath = "//ul[contains(@class,'productListContent')]/li/div[contains(@class,'moria-ProductCard')]")
    private List<WebElement> lstProductList;
    @FindBy(xpath = "//ul[contains(@class,'productListContent')]/li/div[contains(@class,'moria-ProductCard')]/a")
    private List<WebElement> lstProductListA;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Arama sonucunda listelenen ürünlerden rastgele biri seçilir, ürün adı alınır ve ürün sayfası açılır.")
    public String clickRandomProduct() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(lstProductListA.size());
        System.out.println("Toplam " + lstProductListA.size() + " öğe içerisinden " + randomIndex + " sıradaki seçilen öğe başlığı: " + lstProductListA.get(randomIndex).getAttribute("title"));
        Commands.Click(lstProductListA.get(randomIndex));
        return lstProductListA.get(randomIndex).getAttribute("title");
    }
}
