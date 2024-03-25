package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.Commands;

public class ProductDetailPage {
    private WebDriver driver;
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@id='product-name']")
    private WebElement lblProductDetailName;
    @FindBy(xpath = "//span[@id='offering-price']")
    private WebElement lblProductDetailPrice;
    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement btnAddToCard;
    @FindBy(xpath = "//button[normalize-space()= 'Sepete git']")
    private WebElement btnGoToCard;
    @FindBy(xpath = "//span[normalize-space()= 'Ürün sepetinizde']")
    private WebElement lblInYourCard;
    @FindBy(xpath = "//table[@id='css-tab-buttons']//a[contains(text(),'Değerlendirmeler')]")
    private WebElement btnReviews;
    @FindBy(xpath = "//div[@id='tabProductReviews' and @style='display: block;']")
    private WebElement ddlReviewsTab;
    @FindBy(xpath = "//div[contains(@class,'hermes-Sort-module')]/div[contains(@class,'hermes-Dropdown-module')]/div")
    private WebElement ddlReviewsSort;
    @FindBy(xpath = "//div[contains(@class,'hermes-Sort-module')]//div[contains(text(),'En faydalı değerlendirme')]")
    private WebElement ddlReviewsSortMostHelpful;
    @FindBy(xpath = "(//div[@itemprop='review'])[1]//div[contains(@class,'thumbsUp hermes-ReviewCard-module-')]")
    private WebElement btnFirstThumbsUp;
    @FindBy(xpath = "(//div[@itemprop='review'])[1]//span[.='Teşekkür Ederiz.']")
    private WebElement lblThankYouMessage;
    @FindBy(xpath = "//span[.='Henüz değerlendirme yok']")
    private WebElement lblNoReview;
    @FindBy(xpath = "//div[contains(@class,'hermes-ProductRate-module')]/div/div/div/span[1]")
    private WebElement lblRatingContainer;
    @FindBy(xpath = "//div[contains(@class,'customerAccount-Like')]")
    private WebElement btnLikeContainer;
    @FindBy(xpath = "//div[contains(@class,'customerAccount-Like')]/div[normalize-space()='Beğen']")
    private WebElement btnLike;
    @FindBy(xpath = "//div[contains(@class,'customerAccount-Like')]/div[normalize-space()='Beğendin']")
    private WebElement btnLiked;
    @FindBy(xpath = "//div[normalize-space()='Ürün listenize eklendi.']")
    private WebElement lblProductLikeAdded;
    @FindBy(xpath = "//div[contains(@class,'product_price_container')]/div[contains(@class,'product_price')]")
    private WebElement lblCardPrice;
    String noReviewMessage = "Henüz değerlendirme yok";
    @Step("Sayfanın tamamen yüklendiği kontrol edilir.")
    public void pageIsLoaded() {
        Commands.waitForPageLoad();
        Commands.switchToLastTab();
    }
    @Step("Arama sayfasındaki {0} ürün adı ile ürün sayfasındaki ürün adı karşılaştırılır.")
    public void verifyProductNameTitle(String productTitle) {
        Commands.waitForElement(lblProductDetailName);
        Assert.assertEquals(lblProductDetailName.getText().trim(), productTitle.trim());
    }
    @Step("Değerlendirmeler sayfası açılır ve değerlendirme varsa sıralama yapılır,")
    public void openReviewsAndSort() {
        Commands.JSClick(btnReviews);
        Commands.waitForElement(ddlReviewsTab);
        Commands.moveToElement(ddlReviewsTab);
        if (lblRatingContainer.getText().equals(noReviewMessage)) {
            System.out.println(noReviewMessage);
        } else {
            Commands.JSClick(ddlReviewsSort);
            Commands.JSClick(ddlReviewsSortMostHelpful);
        }
    }
    @Step("Değerlendirmeler sayfasında yorum varsa, oylama yapılır.")
    public void thumbsUp() {
        if (!lblRatingContainer.getText().equals(noReviewMessage)) {
            Commands.JSClick(btnFirstThumbsUp);
            Commands.waitForElement(lblThankYouMessage);
        }
    }
    @Step("Ürün sayfasında Beğen butonu kontrol edilir. Eğer Beğen butonu aktifse, ürün beğenilir ve bu durum kontrol edilir.")
    public void likeProductAndVerify() {
        Commands.waitForElement(btnLikeContainer);
        String likeButtonText = btnLikeContainer.getText();
        if (likeButtonText.equals("Beğen")) {
            Commands.JSClick(btnLike);
            Commands.waitForElement(lblProductLikeAdded);
            Commands.waitForElement(btnLiked);
            driver.navigate().refresh();
            Commands.waitForElement(btnLiked);
        }
    }
    @Step("Ürün sepete eklenir ve sepet sayfası açılarak tutar karşılaştırması yapılır.")
    public void productPriceVSCardPrice() {
        String productPrice = lblProductDetailPrice.getText();
        Commands.JSClick(btnAddToCard);
        Commands.waitForElement(lblInYourCard);
        Commands.Click(btnGoToCard);
        Commands.waitForElement(lblCardPrice);
        String cardPrice = lblCardPrice.getText();
        Assert.assertEquals(cardPrice.trim(), productPrice.trim());
    }
}

