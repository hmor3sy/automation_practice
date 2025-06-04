import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;
    public P02_HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By menLink = By.xpath("//a[@data-parent='#accordian'][contains(.,'Men')]");
    By tShirtLink = By.xpath("//a[contains(.,'Tshirts ')]");

    // Methods
    public void navigateToProducts(){
        driver.element().click(menLink);
        driver.element().click(tShirtLink);
    }

}
