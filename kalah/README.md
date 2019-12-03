

# Backbase Coding Challenge

This project contains an implementation for a game of 6 stone Kalah as per the brief for the Backbase Coding challenge.
The two RESTful methods have been implemented and tested. The game does not currently go beyond this scope and try to 

The application use a 3 layer architecture using Spring:

Web Layer - Implements REST Controller as per the API specification. Converts between internal and external representation.

Persistence Layer - uses a H2 in-memory database accessed by JPA.

Service Layer - implements the Kalah Game rules.
 

##Java Technologies used:

Spring Boot
Spring Web
Spring JPA
H2 Database
JUnit

## Development Tools
Maven
Eclipse


## Building and Running the application

Clone the Repository

git clone https://github.com/jhgraham/james

To run on the command line

mvn package && java -jar target/kalah-rest-service-0.1.0.jar


## Testing

JUnit tests are provided under src/test/java/kalah

Postman scripts

curl --header "Content-Type: application/json" \
--request POST \
http://<host>:<port>/games
Response:
HTTP code: 201
Response Body: { "id": "1234", "uri": "http://<host>:<port>/games/1234" }


curl --header "Content-Type: application/json" \
--request PUT \
http://<host>:<port>/games/{gameId}/pits/{pitId}
gameId: unique identifier of a game
pitId: id of the pit selected to make a move. Pits are numbered from 1 to 14 where 7 and 14 are the kalah (or house)
of each player
Response:
HTTP code: 200
Response Body:
{"id":"1234","url":"http://<host>:<port>/games/1234","status":{"1":"4","2":"4","3":"4","4":"4","5":"4","6":"4","7":"0","8":"4","
9":"4","10":"4","11":"4","12":"4","13":"4","14":"0"}}
status: json object key-value, where key is the pitId and value is the number of stones in the pit



James Graham

December 2019
