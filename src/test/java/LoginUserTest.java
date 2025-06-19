import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginUserTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;



    @Test(description = "Login User with correct email and password")
    public void loginWithValidUserNameAndPassword(){
    new LoginPage(driver)
            .navigateHome()
            .verifyVisibiltyOfHomePage()
            .clickOnLoginlink()
            .verifyLoginMsgVisibilty(testData.getTestData("loginToYourAccountMsg"))
            .login(testData.getTestData("loginEmail"),testData.getTestData("password"));

    }

    @BeforeClass
    public void setup(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
