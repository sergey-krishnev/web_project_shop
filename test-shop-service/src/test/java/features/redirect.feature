Feature: Redirect to login page when unregistered

  Scenario Outline: Redirect when it is not login page
    Given a web browser
    When the user navigates to the <page>
    Then link redirects to login page

    Examples:
      | page      |
      | index.jsf |
      | add.jsf   |
      | edit.jsf  |