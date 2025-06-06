import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;

    public P02_HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By menuLink = By.xpath("//a[@href='#Men']");
    By tShirtLink = By.xpath("//a[@href='/category_products/3' and contains(.,'Tshirts')]");

    // Methods
    @Step("Navigate to Products Page")
    public P03_ProductPage navigateToProducts() {
//        WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(3),);
        driver.element().clickUsingJavascript(menuLink);

        driver.element().clickUsingJavascript(tShirtLink);
        return new P03_ProductPage(driver);
    }

}
