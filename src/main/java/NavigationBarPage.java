import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationBarPage {
    SHAFT.GUI.WebDriver driver;

    public NavigationBarPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By loggedInASBtn = By.xpath("//a[contains(.,'Logged in as')]");
    By deleteAccountLnk = By.xpath("//a[@href='/delete_account']");
    By contactUsLnk = By.xpath("//a[@href='/contact_us']");
    By productLnk = By.xpath("//a[@href='/products']");

    // Methods
    @Step("Verify that 'Logged in as username' is visible")
    public NavigationBarPage verifyLoggedUserVisiblity(String expectedResult) {
        driver.verifyThat().element(loggedInASBtn).exists().perform();
        driver.verifyThat().element(loggedInASBtn).text().contains(expectedResult).perform();
        return this;
    }

    @Step("Click on Delete Account Link")
    public NavigationBarPage clickOnDeleteAccount() {
        driver.element().click(deleteAccountLnk);
        return this;
    }
    @Step("Click on Contact Us Link")
    public NavigationBarPage openContactUsPage(){
        driver.element().click(contactUsLnk);
        return this;
    }
    @Step("Click on Products Link")
    public NavigationBarPage openProductPage(){
        driver.element().click(productLnk);
        return this;
    }
}
