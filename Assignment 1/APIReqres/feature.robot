*** Settings ***
Library    SeleniumLibrary
Library    Collections
Resource   apireqres.robot

*** Variables ***
${URL}           https://reqres.in
${USER_ID}       1
${USERNAME}      Wiwin
${USER_JOB}      QA Automation

*** Test Cases ***
GET SINGLE USER
    [Tags]        GET SINGLE USER
    Given User create session reqres
    When User send GET request
    Then Response status code is 200 

POST CREATE USER
    [Tags]        POST CREATE USER
    Given User create session reqres
    When User send create user
    And User send POST request
    Then Response status code is 201
  
    
