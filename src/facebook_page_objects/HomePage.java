package facebook_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the Home Page using annotations of PageFactory.
    @FindBy(how = How.ID, using = "email")

    private WebElement email_field;

    @FindBy(how = How.ID, using = "pass")

    private WebElement password_field;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")

    private WebElement login_button;

    // This is a constructor.
    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for login action on the Home Page.
    public void login_to_facebook(String email, String password) {

        // Fill in the "email" field.
        email_field.clear();
        email_field.sendKeys(email);

        // Fill in the "password" field.
        password_field.clear();
        password_field.sendKeys(password);

        // Click on the "login" button.
        login_button.click();

    }

}
