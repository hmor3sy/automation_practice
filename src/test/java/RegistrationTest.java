import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    private String timeStamp = String.valueOf(System.currentTimeMillis());


    @Test(description = "Register New User")
    public void registerNewUser(){
        new LoginPage(driver)
                .navigate();
        new RegisterPage(driver)
                .verifyVisibilityOfSignUpPage(testJson.getTestData("signUpText"));
        new LoginPage(driver)
                .register(testJson.getTestData("signUpName"),
                        testJson.getTestData("signUpEmail")+timeStamp+"@gmail.com");
        new RegisterPage(driver)
                .fillRegistrationForm(testJson.getTestData("password"), testJson.getTestData("firstName"),
                        testJson.getTestData("lastName"), testJson.getTestData("company"),
                        testJson.getTestData("address1"), testJson.getTestData("address2"),
                        testJson.getTestData("state"), testJson.getTestData("city"),
                        testJson.getTestData("zipcode"), testJson.getTestData("mobileNo"))
                .verifyThatAccountCreated(testJson.getTestData("createdMsg"))
                .clickOnContinue();
        new NavigationBarPage(driver)
        .verifyLoggedUserVisiblity(testJson.getTestData("loggedInText"))
                .clickOnDeleteAccount();
        new RegisterPage(driver)
                .verifyDeleteAccount(testJson.getTestData("deleteAccountMsg"))
                .clickOnContinue();

    }

    @BeforeClass
    public void setup(){
        driver = new SHAFT.GUI.WebDriver();
        testJson = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
