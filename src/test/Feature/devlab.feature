Feature: validate devlab application

    Scenario: validate devlab home page navigations
        Given user launch devlab application
        Then user validate the homepage title
        And user validate devlab logo
        When user click on login button
        Then login pop up screen displays
        When user gives input as username and password
        Then user close the login pop up
        Then user close the application


