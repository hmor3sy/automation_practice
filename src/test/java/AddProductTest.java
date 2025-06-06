import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    SHAFT.TestData.EXCEL testExcel;

    @Test
    public void loginAndAddProducts()  {
        new P01_LoginPage(driver)
                .login(testExcel.getCellData("email"), testJson.getTestData("password"))
                .navigateToProducts()
                .addProducts();


    }

    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        testJson = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
        testExcel = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testData.xlsx");
        driver.browser().navigateToURL(testJson.getTestData("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
