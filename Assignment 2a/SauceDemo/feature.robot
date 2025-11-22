*** Settings ***
Library    SeleniumLibrary
Resource   saucedemo.robot

*** Variables ***
${URL}           https://www.saucedemo.com/
${BROWSER}       Chrome
${USERNAME}      standard_user    
${PASSWORD}      secret_sauce
${PRODUCT_ID}    add-to-cart-sauce-labs-fleece-jacket
${PRODUCT_NAME}    Sauce Labs Fleece Jacket
 
*** Test Cases ***
Checkout Product
    [Tags]    Checkout Product from Sauce Demo
    Given User open Browser to Sauce Demo
    When User fill username and password
    And User click login button
    And User verify inventory page
    And User click add to cart button
    When User verify product name
    And User fill First Name, Last Name, Postal Code
    And User verify checkout overview
    Then User verify successfully buy the product
