Feature: Application Login

@smoke @smoke1
Scenario Outline:
Given User is on login page
When user is login with  "<user>" and "<password>"
Then Able to login "<Flag>"


Examples:

|user|password|Flag|
|Abc1|XYZ1|true|
|Abc2|xyz2|false|

@smoke1 @smoke
Scenario Outline:
Given User is on login page
When user is login with  "<user>" and "<password>"
Then Able to login "<Flag>"


Examples:

|user|password|Flag|
|123|1234|true|
|345|545|false|