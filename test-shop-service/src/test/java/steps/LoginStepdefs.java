package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepdefs {

    @Given("^a User admin exists with password admin$")
    public void aUserAdminExistsWithPasswordAdmin(){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I fill in username with \"([^\"]*)\"$")
    public void iFillInUsernameWith(String username){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I press login$")
    public void iPressLogin(){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be on the home page$")
    public void iShouldBeOnTheHomePage(){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
