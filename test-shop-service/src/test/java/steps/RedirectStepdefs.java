package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RedirectStepdefs {

    private WebDriver driver = null;



    @Given("^a web browser$")
    public void aWebBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("^the user navigates to the ([^\"]*)$")
    public void theUserNavigatesToThePage(String page) {
        driver.navigate().to("http://localhost:9090/" + page);
    }

    @Then("^link redirects to login page$")
    public void linkRedirectsToLoginPage() throws Throwable {
        if (driver.getCurrentUrl().equals("http://localhost:9090/login")) {
            System.out.println("Test Pass");
        } else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
