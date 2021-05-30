
Feature: launch the browser

 Scenario Outline: 
    And Enter the username
    And Enter the password
    When click the login
    And verify the title
    And click the crm/sfa
    And click the create lead
    Then enter the companyname<>
    And enter the first name<>
    And enter the last name<>
    Then click submit button
    And getthe lead value
    Then close the browser

 Examples: 
      |companyname|first name|last name|
      |exela|mythili|ravi|
      |optisol|suji|rani|
