Feature: Login into Zeiss WebPortal Dashboard

Scenario: Positive Test validating user can login into Zeiss WebPortal Dashboard

Given Initialize browser with Chrome
And Navigate to "https://hunting.zeiss.com/" Website
And Click on SignIn link in Homepage to land on secure sign in Page

When User enters "tamal.datta.innogy@gmail.com" and "2Sitterspace" and logs in

Then Verify that user is successfully logged in
