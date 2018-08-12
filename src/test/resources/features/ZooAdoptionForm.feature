Feature: Zoo Adoption Subscription Form
  In order to get animal adoption papers
  As a regular user
  I want to be able to subscibe for any permitted animal

  Background:
    Given an opened browser with Zoo Adoption Subscription Page

  Scenario: My Name should be Displayed below the text enter field
    When I enter "My Name" into text field
    Then "My Name" should be displayed below the text

  Scenario Outline: The confirmation text for animal "<animalType>" should be equal confirmation text
    When I enter "My Name" into text field
    And I click continue
    And select "<animalType>"
    And I click continue
    Then The confirmation text should match
      """
      Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal.
      """

  Examples:
    | animalType        |
    | George the Turtle |
    | Simba the Lion    |
    | Nemo the Fish     |

  Scenario: I want to be able to adopt another animal after a complete Adoption
    When I enter "My Name" into text field
    And I click continue
    And select "Nemo the Fish"
    And I click continue
    And I click back to home button
    Then Welcome adoption page should open

  Scenario: I should not be able to adopt when I do not enter a Name
    When I click continue
    Then Animal selection page should not be opened

