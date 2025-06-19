import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactUsPage {
    // Variables
    SHAFT.GUI.WebDriver driver;

    // Constructor
    public ContactUsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    // Locators
    By txtBox(String label){
        return By.xpath("//input[@placeholder='"+label+"']");
    }
    By textArea = By.xpath("//textarea[@id='message']");
    By chooseFileBtn = By.xpath("//input[@name='upload_file']");
    By submitBtn = By.xpath("//input[@data-qa='submit-button']");
    By successfulMsg = By.xpath("//div[@class='status alert alert-success']");

    // Methods
    @Step("Fill Contact Us Form")
    public ContactUsPage fillContactUsForm(String name, String email, String subject, String message, String filePath){
        driver.element().type(txtBox("Name"),name)
                .type(txtBox("Email"),email)
                .type(txtBox("Subject"),subject)
                .type(textArea,message)
                .typeFileLocationForUpload(chooseFileBtn,filePath);
                return this;
    }
    @Step("Click on Submit Button")
    public ContactUsPage submitForm(){
        driver.element().click(submitBtn);
        driver.alert().acceptAlert();
        return this;
    }
    @Step("Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public ContactUsPage verifySuccessSubmit(String expectedResult){
        driver.verifyThat().element(successfulMsg).exists().perform();
        driver.verifyThat().element(successfulMsg).text().isEqualTo(expectedResult).perform();
        return this;
    }

}
