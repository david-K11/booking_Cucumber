@smoke
Feature: Book first displayed hotel

Background: Language and currency
Given "Home" page
When set up language to English
And set up currency to USD
Then Language is English and currency is USD

Scenario: Book first displayed hotel
Given I have account created
  And I am in "Home" page
When I set up destination as "Liepaja"
  And I set dates "28-11-2020" - "30-11-2020"
  And I select "2" adults and "1" children
  And I click on "Search" button
  And I click on "Choose your room" for fist hotel in the list
  And "Hotel Details" page is opened for selected hotel
  And I click on "Reserve" button for recommended room
  And I click on “I'll Reserve” button 
Then "Your Details" page is displayed
  And I enter valid booking information
  And I click on "Next: Final Details" button
  And "Final Details" page is displayed
