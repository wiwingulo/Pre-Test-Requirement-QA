*** Settings ***
Library    SeleniumLibrary
Library    Collections
Library    RequestsLibrary

*** Keywords ***

User create session reqres
    Create Session    reqres_session    ${URL} 

User send GET request
    ${resp}    GET On Session    reqres_session    /api/users/2
    Set Test Variable    ${RESPONSE}    ${resp}

Response status code is 200 
    Should Be Equal As Strings    ${RESPONSE.status_code}    200

User send create user
    ${body}    Create Dictionary    name=${USERNAME}    job=${USER_JOB}
    Set Test Variable    ${REQUEST_BODY}    ${body}
    
User send POST request
   ${resp}    POST On Session    reqres_session    /api/users/    json=${REQUEST_BODY}    expected_status=anything
    Set Test Variable    ${RESPONSE}    ${resp}

Response status code is 201
    Should Be Equal As Strings    ${RESPONSE.status_code}    401



    
    

    


    

