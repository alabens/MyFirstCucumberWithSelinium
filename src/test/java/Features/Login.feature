Feature: LoginFeature
  This feature deals with the login functionality of the application

  #Scenario: Login with correct username and password
    #Given I navigate to the login page
    #And I enter the following details for login
      #| username | password      |
      #| admin    | adminpassword |
      #| ala      | alapassword   |
    #And I click login button
    #Then I should see the userform page


  Scenario Outline: Login with correct username and password using senario outline
    Given I navigate to the login page
    And I enter "<username>" and "<password>"
    And I click login button
    Then I should see the userform page
    Then Close browser
    Examples:
      | username      | password      |
      | execute       | automation    |
      | administrator | administrator |