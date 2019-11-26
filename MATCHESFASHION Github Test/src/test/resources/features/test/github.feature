#Author : Bayo
@test
Feature: Browser testing exercise

  Scenario: Github browser testing
    Given I launch my a "chrome" browser
    When I navigate to the github website "https://github.com/"
    Then I should see the github homepage
    When I search for "webdriverio"
    Then The search result should not be empty
    When I open the first result item
    And I open the the "README.md" file
    Then The title of the README.md page should be visible
