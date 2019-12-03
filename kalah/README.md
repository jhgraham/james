

# Coding Test for Backbase - December 2019

This project contains an implementation for a game of 6 stone Kalah as per the brief for the Backbase Coding challenge.
Two RESTful methods have been implemented and tested for creating a new game and making a move.  

The application use a 3 layer architecture using Spring:

* Web Layer - Implements REST Controller as per the API specification. Converts between internal and external representation.

* Persistence Layer - uses a H2 in-memory database accessed by JPA.

* Service Layer - implements the Kalah Game rules.
 

## Java Technologies

* Spring Boot
* Spring Web
* Spring JPA
* H2 Database
* JUnit

## Development Tools
* Maven
* Eclipse


## Building and Running the application

* Clone the Repository

	git clone https://github.com/jhgraham/james

* To run on the command line

	mvn package && java -jar target/kalah-rest-service-0.1.0.jar


## Testing

### JUnit
JUnit tests are provided under src/test/java/kalah.

### Postman
Postman scripts are provided under postman directory. 
The Postman Collection contains two requests: 

   1. A POST Request for creating a new game (CreateNewGame)
   
		
	Example Request:
		POST http://localhost:8080/games
		
	Response:
	
		HTTP 201 Created
		{
			"id": "1",
			"url": "http://localhost:8080/games/1"
		}
   
   2. A PUT Request for making a move in the game (MakeMove)

	Example Request:
		PUT http://localhost:8080/games/1/pits/8

	Response:
		HTTP 200 OK
		
		{
			"id": "1",
			"url": "http://localhost:8080/games/1",
			"status": {
				"1": "7",
				"2": "6",
				"3": "6",
				"4": "0",
				"5": "7",
				"6": "7",
				"7": "1",
				"8": "0",
				"9": "8",
				"10": "8",
				"11": "7",
				"12": "7",
				"13": "7",
				"14": "1"
			}
		}


James Graham

December 2019
