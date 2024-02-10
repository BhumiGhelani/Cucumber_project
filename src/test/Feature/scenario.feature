Feature: fill details in formsmart page
  @Regression
  Scenario: fill details in form
    Given user launch formsmart application
    Then user scroll till the form section
    When user give input as first name,last name, email and inquiry

    @Smoke
    Scenario Outline: fill details in form using feature file
      Given user is in form home page
      Then user scroll till the form section
      Then user fills the form with "<firstname>","<lastname>","<email>","<inquiry>"
      Examples:
      |firstname|lastname|email|inquiry|
      |Bhumi|Ghelani|bhumi@gmail.com|inquiry1|
      |Shilpi|Dugar |shilpi@gmail.com|inquiry2|
      |Aruna|Shingh |aruna@gmail.com |inquiry3|
      |Jinal|Shah   |jinal@gmail.com |inquiry4|
      |Payal|Thakkar|pyal@gmail.com  |inquiry5|
      |Rupa |Tanna  |rupa@gmail.com  |inquiry6|
      |Richa|Ganatra|richa@gmail.com |inquiry7|
      |Yama |Patel  |yama@gmail.com  |inquiry8|
      |Shivi|Shah   |shivi@gmail.com |inquiry9|
      |Jesica|Patel |jesica@gmail.com|inquiry10|
