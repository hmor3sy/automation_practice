import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    SHAFT.GUI.WebDriver driver;

    public ProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private String url = "https://automationexercise.com/login";
    // Locators
    By productsCard = By.xpath("//div[@class='productinfo text-center']");
    By continueBtn = By.xpath("//button[@data-dismiss='modal']");
    By viewCartBtn = By.xpath("(//a[@href='/view_cart'])[1]");

    // Methods

    @Step("Navigate to login page")
    public ProductPage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Add Products with Price less than 1000")
    public ProductPage addProducts() {
        List<WebElement> products = driver.getDriver().findElements(productsCard);
        try {
            for (int i = 0; i < products.size(); i++) {
                int productPrice = Integer.parseInt(driver.getDriver()
                        .findElement(By.xpath("(//div[@class='productinfo text-center']/h2)["+(i+1)+"]"))
                        .getText().replaceAll("[^0-9]",""));

                System.out.println("Price of product " + (i + 1));
                if (productPrice < 1000){
                    driver.element().click(By.xpath("(//div[@class='productinfo text-center'])["+(i+1)+"]/a"))
                            .click(continueBtn);
                    System.out.println("Added product with price " + productPrice + "to the cart");
                }

            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Verify view cart products")
    public void productsVerification(){
        driver.element().click(viewCartBtn)
                .and().browser().captureScreenshot();
    }
}
