package wallethub_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the Login Page using annotations of PageFactory.
    @FindBy(how = How.NAME, using = "em")

    private WebElement email_field;

    @FindBy(how = How.NAME, using = "pw")

    private WebElement password_field;

    @FindBy(how = How.CSS, using = ".btn.blue.touch-element-cl")

    private WebElement login_button;

    // This is a constructor.
    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for login action on the Login Page.
    public void login_to_wallethub(String email, String password) {

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
