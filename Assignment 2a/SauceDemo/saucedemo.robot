*** Settings ***
Library    SeleniumLibrary

*** Keywords ***

User open Browser to Sauce Demo
    Open Browser   ${URL}   ${BROWSER}
    Maximize Browser Window

User fill username and password
    Input Text    id:user-name    ${USERNAME}
    Input Password    id:password    ${PASSWORD}

User click login button
    Click Button    id:login-button

User verify inventory page
    Wait Until Page Contains    Swag Labs
    Page Should Contain    Swag Labs

User click add to cart button
    Click Button    id:${PRODUCT_ID}
    Click Element    class:shopping_cart_link

User verify product name
    Element Text Should Be    xpath://*[text()='${PRODUCT_NAME}']    ${PRODUCT_NAME}
    Click Button    id:checkout

User fill First Name, Last Name, Postal Code
    Input Text    id:first-name    Wiwin
    Input Text    id:last-name    Gulo
    Input Text    id:postal-code    12212
    Click Button    id:continue

User verify checkout overview
    Element Text Should Be    xpath://*[text()='${PRODUCT_NAME}']    ${PRODUCT_NAME}
    Click Button    id:finish

User verify successfully buy the product
    Element Text Should Be    xpath://*[text()='Thank you for your order!']   Thank you for your order!
    


    

