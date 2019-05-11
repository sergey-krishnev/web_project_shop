package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdefs {

    private WebDriver driver = null;

    @Before
    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("^a User admin goes to login page$")
    public void aUserAdminGoesToLoginPage(){
        driver.navigate().to("http://localhost:9090/login");
    }

    @When("^I fill in username with \"([^\"]*)\"$")
    public void iFillInUsernameWith(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^I press login$")
    public void iPressLogin() {
        driver.findElement(By.className("btn")).submit();
    }

    @Then("^I should be on the home page$")
    public void iShouldBeOnTheHomePage() {
        if (driver.findElement(By.className("rf-p")).isDisplayed()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
    }

    @When("^I press the button logout$")
    public void iPressTheButtonLogout(){
        driver.findElement(By.name("j_idt9:j_idt10")).click();
    }

    @Then("^I should be on the login page$")
    public void iShouldBeOnTheLoginPage(){
        if(driver.findElement(By.className("alert")).isDisplayed()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
    }

    @After
    public void closeBrowser() {
        driver.close();
    }


}
