import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {
    // Variables
    SHAFT.GUI.WebDriver driver;
    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    // Locators
    By titleRadioBtn = By.xpath("//input[@name='title' and @value='Mr']");
    private static By txtBox(String label) {
    return By.xpath("(//label[contains(.,'"+label+"')]/following-sibling::input)[1]");
    }
private static By dropBox(String label, int index){
        return By.xpath("(//label[contains(.,'"+label+"')]//following::select)["+index+"]");
}

private static By dropBoxOption(String label, int index, String value){
return By.xpath("(//label[contains(.,'"+label+"')]//following::select)["+index+"]/option[@value='"+value+"']");
}

By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    By accountCreatedMsg = By.xpath("//h2[@data-qa='account-created']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");




    // Methods


    @Step("Fill Registration Form")
    public RegisterPage fillRegistrationForm(String password, String firstName, String lastName,
                                             String company, String address1, String address2,
                                             String state, String city, String zipcode, String mobileNo){
            driver.element().click(titleRadioBtn)
                    .and().type(txtBox("Password"),password);

            driver.element().select(dropBox("Date of Birth",1),"1");
            driver.element().select(dropBox("Date of Birth",2),"September");
            driver.element().select(dropBox("Date of Birth",3),"1980");

            driver.element().type(txtBox("First name *"),firstName)
                    .and().type(txtBox("Last name *"),lastName)
                    .and().type(txtBox("Company"),company)
                    .and().type(txtBox("Address * (Street address, P.O. Box, Company name, etc.)"),address1)
                    .and().type(txtBox("Address 2"),address2);

            driver.element().click(dropBox("Country *",1));
            driver.element().click(dropBoxOption("Country *",1,"United States"));

            driver.element().type(txtBox("State *"),state)
                    .and().type(txtBox("City *"),city)
                    .and().type(txtBox("Zipcode *"),zipcode)
                    .and().type(txtBox("Mobile Number *"),mobileNo)
                            .and().click(createAccountBtn);
            return this;
    }

    @Step("Verify that user is created successfully")
    public RegisterPage verifyThatAccountCreated(String expectedResult){
        driver.verifyThat().element(accountCreatedMsg).text().equalsIgnoringCaseSensitivity(expectedResult).perform();
        return this;
    }
    @Step("Click on Continue button")
    public void clickOnContinue(){
        driver.element().click(continueBtn);
    }

}
