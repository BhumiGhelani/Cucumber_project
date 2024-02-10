Feature: validate chartink application

Scenario: work with get started
  Then user validate the homepage logo
  When user click on get started button
  Then user registration for page appears
  When user enter details
  Then user close the registration app

  Scenario Outline: Scenario Outline: fill details in form using feature file
    Then user validate the homepage logo
    When user click on get started button
    Then user registration for page appears
    Then user enter details "<name>","<email>","<password>","<confirmpassword>"
    Examples:
      |name|email|password|confirmpassword|
      |Bhumi|bhumi@gmail.com|abc@123|abc@123|
