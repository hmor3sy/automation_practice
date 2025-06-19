import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private String url_Home = "https://automationexercise.com";
    private String url = "https://automationexercise.com/login";
    // Locators

    By signUpNameTxtBox = By.xpath("//input[@data-qa='signup-name']");
    By signUpEmailTxtBox = By.xpath("//input[@data-qa='signup-email']");
    By signUpBtn = By.xpath("//button[@data-qa='signup-button']");

    By emailInput = By.xpath("//input[@data-qa='login-email']");
    By passwordInput = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By div_Home = By.xpath("//div[@id='slider-carousel']");
    By loginLnk = By.xpath("//a[@href='/login']");
    By loginFormMsg = By.xpath("//h2[contains(.,'Login to your account')]");

    // Methods

    @Step("Navigate to Login/Registration page")
    public LoginPage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }
    @Step("Navigate to Home page")
    public LoginPage navigateHome(){
        driver.browser().navigateToURL(url_Home);
        return this;
    }

    @Step("Sign Up with new user and email")
    public LoginPage register(String name, String email) {
        driver.element().type(signUpNameTxtBox, name)
                .and().type(signUpEmailTxtBox, email)
                .and().clickUsingJavascript(signUpBtn);
        return this;
    }

    @Step("Login to Home Page")
    public LoginPage login(String email, String password) {
        driver.element().type(emailInput, email).
                and().type(passwordInput, password).
                and().click(loginBtn);
        return this;
    }

    @Step("")
    public LoginPage clickOnLoginlink(){
        driver.element().click(loginLnk);
        return this;
    }

    @Step("Verify that home page is visible successfully")
    public LoginPage verifyVisibiltyOfHomePage(){
        driver.verifyThat().element(div_Home).exists().perform();
        return this;
    }

    @Step("Verify 'Login to your account' is visible")
    public LoginPage verifyLoginMsgVisibilty(String expectedResult){
        driver.verifyThat().element(loginFormMsg).exists().perform();
        driver.verifyThat().element(loginFormMsg).text().isEqualTo(expectedResult);
        return this;
    }

}
