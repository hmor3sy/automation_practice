import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsPage {
    SHAFT.GUI.WebDriver driver;

    public ProductsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By allProducts_div = By.xpath("//h2[contains(.,'All Products')]");
    By viewProductLnk(int num){return By.xpath("//a[@href='/product_details/"+num+"']");}

    // Methods
    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
    public ProductsPage verifyNavigationToProductsPage(String expectedResult){
        driver.verifyThat().element(allProducts_div).exists().perform();
        driver.verifyThat().element(allProducts_div).text().isEqualTo(expectedResult).perform();
        return this;
    }

    @Step("Click on 'View Product' of product")
    public ProductsPage clickOnViewProduct(int num){
        driver.element().click(viewProductLnk(num));
        return this;
    }
}
