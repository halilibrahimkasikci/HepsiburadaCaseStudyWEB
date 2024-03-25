package test;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.ProductDetailPage;
import page.SearchResultsPage;
import util.Config;

public class Runner extends BaseTest {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailPage productDetailPage;
    private LoginPage loginPage;


    @Test(testName = "Senaryo 1 - En Yeni Değerlendirme Oylama", priority = 1)
    void Scenario1() {
        homePage.pageIsLoaded();
        homePage.keywordSearch("IPhone");
        homePage.pageIsLoaded();
        String selectedProduct = searchResultsPage.clickRandomProduct();
        productDetailPage.pageIsLoaded();
        productDetailPage.verifyProductNameTitle(selectedProduct);
        productDetailPage.openReviewsAndSort();
        productDetailPage.thumbsUp();
    }

    @Test(testName = "Senaryo 2 - Ürün Beğenme", priority = 2)
    void Scenario2() {
        loginPage = new LoginPage(driver);
        homePage.pageIsLoaded();
        loginPage.login(Config.get("user.mail"), Config.get("user.pass"));
        homePage.keywordSearch("iPhone");
        homePage.pageIsLoaded();
        String selectedProduct = searchResultsPage.clickRandomProduct();
        productDetailPage.pageIsLoaded();
        productDetailPage.verifyProductNameTitle(selectedProduct);
        productDetailPage.likeProductAndVerify();
    }

    @Test(testName = "Senaryo 3 - Ürün Detayı ve Sepet Fiyatı Kontrolü", priority = 3)
    void Scenario3() {
        homePage.pageIsLoaded();
        homePage.keywordSearch("IPhone");
        homePage.pageIsLoaded();
        String selectedProduct = searchResultsPage.clickRandomProduct();
        productDetailPage.pageIsLoaded();
        productDetailPage.verifyProductNameTitle(selectedProduct);
        productDetailPage.productPriceVSCardPrice();
    }
    @BeforeMethod
    public void start() {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        driver.get(Config.get("base.url"));
    }
}
