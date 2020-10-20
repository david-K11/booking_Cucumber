@smoke
Feature: Book cheapest hotel in city

Background: Language and currency
Given "Home" page
When set up language to English
And set up currency to USD
Then Language is English and currency is USD

Scenario: Book cheapest hotel in city
Given I have account created
  And I am in "Home" page
When I set up destination as "Riga" 
  And I set dates "26-11-2020" - "29-11-2020"
  And I select "2" adults and "0" children
  And I click on "Search" button
  And I click on "Choose your room" for the cheapest hotel in the list with a rating above "3" stars 
  And " Hotel Details" page is opened for selected hotel
  And I click on "I'll Reserve" button for the most expensive available room in the hotel
  Then "Your Details" page is displayed
  And I enter valid booking information
  And I click on "Next: Final Details" button
  And "Final Details" page is displayed