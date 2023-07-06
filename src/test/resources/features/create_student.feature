@CREATE_STUDENT
Feature: Create student feature
  @SMOKE
  Scenario Outline: Create student (happy path)
    Given user is on the app page
    And user click on add student button
    And user enters name in name field
    And user enters email in email field
    And user enters '<gender>' in gender field
    When user click on submit button
    Then user is created

    Examples:
      |gender|
      |MALE  |
#    |FEMALE|
 #   |OTHER |
