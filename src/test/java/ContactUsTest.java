import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @Test(description = "")
    public void openContactUsPageAndSubmitComment(){
        new LoginPage(driver)
                .navigateHome()
                .verifyVisibiltyOfHomePage()
                .clickOnLoginlink()
                .verifyLoginMsgVisibilty(testData.getTestData("loginToYourAccountMsg"))
                .login(testData.getTestData("loginEmail"),testData.getTestData("password"));
        new NavigationBarPage(driver)
                .openContactUsPage();
        new ContactUsPage(driver)
                .fillContactUsForm(testData.getTestData("contactUsName"),testData.getTestData("contactUsEmail"),
                testData.getTestData("contactUsSubject"),testData.getTestData("contactUsMsg"),
                                       "src/test/resources/filesTobeUpload/customerInfo.docx")
                .submitForm()
                .verifySuccessSubmit(testData.getTestData("contactSuccessMsg"));

    }
    @BeforeClass
    public void setup(){
        driver = new  SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("testData.json");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
