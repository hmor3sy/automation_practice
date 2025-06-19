import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsPageTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @Test(description = "Verify All Products and product detail page")
    public void verifyDetails(){
    new LoginPage(driver)
            .navigateHome()
            .verifyVisibiltyOfHomePage()
            .clickOnLoginlink()
            .verifyLoginMsgVisibilty(testData.getTestData("loginToYourAccountMsg"))
            .login(testData.getTestData("loginEmail"),testData.getTestData("password"));
    new NavigationBarPage(driver)
            .openProductPage();
    new ProductsPage(driver)
            .verifyNavigationToProductsPage(testData.getTestData("productPageTitle"))
            .clickOnViewProduct(1);
    // product name, category, price, availability, condition, brand
new ProductDetails(driver).verifyProductDetails(testData.getTestData("productName"),testData.getTestData("productCategory"),
        testData.getTestData("productPrice"),testData.getTestData("productAvailability"),
        testData.getTestData("productCondition"),testData.getTestData("productBrand"));
    }

    @BeforeClass
    public void setup(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("ProductsData.json");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
