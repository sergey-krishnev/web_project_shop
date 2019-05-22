//package steps;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import utilities.BrowserHelper;
//
//public class AddStepdefs {
//
//    private WebDriver driver = null;
//
//    @Before
//    public void initializeBrowser() {
//        driver = BrowserHelper.getDriver();
//    }
//
//    @When("^I press the button add request$")
//    public void iPressTheButtonAddRequest(){
//        driver.findElement(By.xpath("//input[@value='Add request']")).click();
//    }
//
//    @Then("^I should be on the add page$")
//    public void iShouldBeOnTheAddPage() {
//        if (driver.findElement(By.id("j_idt8")).isDisplayed()) {
//            System.out.println("Test Pass");
//        } else {
//            System.out.println("Test Failed");
//        }
//    }
//
//    @When("^I fill in Customer name with \"([^\"]*)\"$")
//    public void iFillInCustomerNameWith(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("^I fill in Address with \"([^\"]*)\"$")
//    public void iFillInAddressWith(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("^I fill in Sum with \"([^\"]*)\"$")
//    public void iFillInSumWith(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("^I press insert$")
//    public void iPressInsert() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @After
//    public void closeBrowser() {
//        driver.close();
//    }
//
//
//
//}
