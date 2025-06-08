import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    SHAFT.TestData.EXCEL testExcel;


    @Test(description = "Login and navigate then add products less than 1000 to cart")
    public void loginAndAddProducts()  {
        new LoginPage(driver)
                .navigate()
                .login(testExcel.getCellData("loginEmail"), testJson.getTestData("password"));
        new HomePage(driver)
                .navigateToProducts();
        new ProductPage(driver)
                .addProducts()
                .productsVerification();


    }

    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        testJson = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
        testExcel = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testData.xlsx");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
