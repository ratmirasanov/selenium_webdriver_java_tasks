package wallethub_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the Home Page using annotations of PageFactory.
    @FindBy(how = How.CSS, using = ".login")

    private WebElement login_link;

    // This is a constructor.
    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for opening Login Page on the Home Page.
    public void goto_login_page() {

        // Click on the "login" link.
        login_link.click();

    }

}
