# SecurePay

# Problem Statement

•	Include some form of persistence
•	Assume a userid is available where required. No active session validation is required
•	no need to UI as much.
•	It is ok not have all the tasks completed, however whatever is completed should be working, tested and documented along with any assumptions made

Create a REST API to persist credit card information for a user. 
    a. Write a stateless service in the same api, available on a specific end point, that returns the credit card type (Visa/ Mastercard /Amex /Diners...) and sub-type (Debit, Credit …).
         When identifying the card type and sub-type use the following in the given order
1.	Attempt to use the first 9 digits of the card number, if not found then
2.	Use the first 6 digits of the card number, if not found then
3.	Set the card type and card-subtype as unknown.
    b. When storing the card details include the credit card type and sub-type using this service, and a card nick name (optional).
    c. Include Creation, retrieval (Based on card nickname, card type, card holder name, card id) update and deletion of records.
    d. Include some form of a web UI utilizing this service.
 
Use the following examples of card type information below.
        bin, cardtype, cardsubtype
        455561, VISA,DEBIT
        387765, AMEX,CREDIT
        454545, VISA, CREDIT
        546626, MC,CREDIT
        444433333 to 444532332, VISA, PREMIUM CREDIT
        512176622 to 512189239, MC, GOLD CREDIT
        546626193 to 546691237, MC, BUSINESS
        
# Solution

1. Created Springboot mircoservice to create, update, delete and retrieve card details
2. Postgres database is used. DB scripts are under /src/resources/dbscripts.sql. This includes insert scripts too


# Get Card Details API 
# Get ALL Card Info
API URL - http://localhost:8080/api/card/all
Method: GET
Response:
[
    {
        "cardType": "VISA",
        "cardSubType": "DEBIT",
        "cardNo": "455561",
        "cardNickName": "TEST1",
        "cardHolderName": "TEST1",
        "cardId": 1
    },
    {
        "cardType": "VISA",
        "cardSubType": "PREMIUM CREDIT",
        "cardNo": "444433333 ",
        "cardNickName": "TEST3",
        "cardHolderName": "TEST3",
        "cardId": 5
    }
]

# fetch card details based on card no
URL- http://localhost:8080/api/card/number/{cardNo}/info
Ex: http://localhost:8080/api/card/number/455561/info

# fetch card details based on card nick name
URL - http://localhost:8080/api/card/nickname/{cardnickname}/info
Ex: http://localhost:8080/api/card/nickname/TEST1/info

# fetch card details based on card type
URL - http://localhost:8080/api/card/type/{cardtype}/info
Ex: http://localhost:8080/api/card/type/VISA/info

# fetch card details based on card holder name
URL -http://localhost:8080/api/card/holdernme/{cardHolderName}/info
Ex: http://localhost:8080/api/card/holdernme/TEST1/info

# Insert/Create Card Details
API URL - http://localhost:8080/api/card/create
Method: POST
Request Body:
{
	"cardType":"VISA",
	"cardSubType":"DEBIT",
	"cardNo":"33445566",
	"cardNickName":"TEST1sssss",
	"cardHolderName":"sssssssssss"
}

Response:
{
    "responseCode": "0",
    "responseDesc": "Added Successfully"
}

# Update Card Details
API URL - http://localhost:8080/api/card/update/{cardNo}
Example - http://localhost:8080/api/card/update/123456
Method: PUT
Request Body:
{
	"cardType":"VISA",
	"cardSubType":"DEBIT",
	"cardNickName":"TEST1sssss",
	"cardHolderName":"sssssssssss"
}

Response:
{
    "responseCode": "0",
    "responseDesc": "Updated Successfully"
}


# Skipped
Due to time constraints, Unit test cases are not done and design principles are not followed properly.
Validations are skipped.
