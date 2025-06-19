import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductDetails {
    SHAFT.GUI.WebDriver driver;
    public ProductDetails(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    // Locators
    By productInfo_div = By.xpath("//div[@class='product-information']");
    By productName_H2 = By.xpath("//div[@class='product-information']/h2");
    By productCategory_P = By.xpath("//div[@class='product-information']/p[contains(.,'Category')]");
    By productPrice_Span = By.xpath("//div[@class='col-sm-7']//span//span");
    By productQuantity_input = By.xpath("//input[@id='quantity']");
    By productAvailability_P = By.xpath("//p[contains(.,'Availability:')]");
    By productCondition_P = By.xpath("//p[contains(.,'Condition:')]");
    By productBrand_P = By.xpath("//p[contains(.,'Brand:')]");


    // Methods
    @Step("Verify that detail is visible: product name, category, price, availability, condition, brand")
    public ProductDetails verifyProductDetails(String productName, String productCategory, String productPrice,
                                               String productAvailability, String productCondition, String productBrand){
        driver.verifyThat().element(productInfo_div).exists().perform();
        driver.verifyThat().element(productName_H2).text().isEqualTo(productName).perform();
        driver.verifyThat().element(productCategory_P).text().contains(productCategory).perform();
        driver.verifyThat().element(productPrice_Span).text().isEqualTo(productPrice).perform();
        driver.verifyThat().element(productAvailability_P).textTrimmed().contains(productAvailability).perform();
        driver.verifyThat().element(productCondition_P).textTrimmed().contains(productCondition).perform();
        driver.verifyThat().element(productBrand_P).textTrimmed().contains(productBrand).perform();
        return this;
    }

}
