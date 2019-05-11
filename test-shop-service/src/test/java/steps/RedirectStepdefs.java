package steps;

import utilities.BrowserHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class RedirectStepdefs {

    private WebDriver driver = null;


    @Given("^a web browser$")
    public void aWebBrowser() {
        driver = BrowserHelper.getDriver();
    }

    @When("^the user navigates to the ([^\"]*)$")
    public void theUserNavigatesToThePage(String page) {
        driver.navigate().to("http://localhost:9090/" + page);
    }

    @Then("^link redirects to login page$")
    public void linkRedirectsToLoginPage() {
        if (driver.getCurrentUrl().equals("http://localhost:9090/login")) {
            System.out.println("Test Pass");
        } else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
