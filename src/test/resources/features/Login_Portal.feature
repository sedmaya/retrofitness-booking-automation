Feature: RetroFitness - Login Portal Page

  Background:
    Given I access to Login Portal

  @pilates-enroll
  Scenario: Verify Successful Enrollment for Pilates on Monday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "Pilates" Class I click on "Enroll in Class" button
    And I see pop up to confirm enrollment in "Pilates" Class
    And I click "Enroll in Class" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now enrolled for Pilates"


  @pilates-wait
  Scenario: Verify Successful Joining Wait List for Pilates on Monday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "Pilates" Class I click on "Join Waitlist" button
    And I see pop up to confirm enrollment in "Pilates" Class
    And I click "Join Waitlist" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now on the waitlist for Pilates"

  @barre-enroll
  Scenario: Verify Successful Enrollment for Barre on Wednesday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "Barre" Class I click on "Enroll in Class" button
    And I see pop up to confirm enrollment in "Barre" Class
    And I click "Enroll in Class" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now enrolled for Barre"

  @barre-wait
  Scenario: Verify Successful Joining Wait List for Barre on Wednesday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "Barre" Class I click on "Join Waitlist" button
    And I see pop up to confirm enrollment in "Barre" Class
    And I click "Join Waitlist" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now on the waitlist for Barre"

  @pil-barre-enroll
  Scenario: Verify Successful Enrollment for PilBarre on Thursday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "PilBarre" Class I click on "Enroll in Class" button
    And I see pop up to confirm enrollment in "PilBarre" Class
    And I click "Enroll in Class" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now enrolled for PilBarre"

  @pil-barre-wait
  Scenario: Verify Successful Joining Wait List for PilBarre on Thursday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "PilBarre" Class I click on "Join Waitlist" button
    And I see pop up to confirm enrollment in "PilBarre" Class
    And I click "Join Waitlist" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now on the waitlist for PilBarre"

  @yoga-pil-enroll
  Scenario: Verify Successful Enrollment for YogaiLates on Friday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "YogaiLates" Class I click on "Enroll in Class" button
    And I see pop up to confirm enrollment in "YogaiLates" Class
    And I click "Enroll in Class" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now enrolled for YogaiLates"

  @yoga-pil-wait
  Scenario: Verify Successful Joining Wait List for YogaiLates on Friday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "YogaiLates" Class I click on "Join Waitlist" button
    And I see pop up to confirm enrollment in "YogaiLates" Class
    And I click "Join Waitlist" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now on the waitlist for YogaiLates"

  @test-enroll
  Scenario: Verify Successful Enrollment for Zumba on Saturday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And I scroll to the "Stretch With Us" Class "Enroll in Class" button
    And Next to the "Stretch With Us" Class I click on "Enroll in Class" button
    And I see pop up to confirm enrollment in "Stretch With Us" Class
    And I click "Enroll in Class" button on the pop up window
    Then I should be presented with a confirmation message that contains "Stretch With Us"

  @test-wait
  Scenario: Verify Successful Joining Wait List for Slow Burn on Wednesday:
    When I enter username "sedmaya"
    And I enter password "Bookaclass"
    And I click on the login button
    And I redirected to my Account home page "https://www.myiclubonline.com/iclub/members#account/personal"
    And I click on Classes tab
    And I redirected to Classes sign up page
    And I click Month list view
    And Next to the "Stretch With Us" Class I click on "Join Waitlist" button
    And I see pop up to confirm enrollment in "Stretch With Us" Class
    And I click "Join Waitlist" button on the pop up window
    Then I should be presented with a confirmation message that contains "You are now on the waitlist for Stretch With Us"