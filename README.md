# RestApiGithub

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)
* [Documentation](#Documentation)
* [Tests](#Tests)
* [Endpoint](#endpoint)

## Introduction

The application presents information about GitHub users.
It returns in the form of JSON information containing user data such as: id, login, name, type, avatarUrl and createdAt. 
Additionally, the calculations field is presented, which returns the result of the operation (6 / followers * (2 + public repos).

The application, using the H2 database, records the number of calls for each login. The database contains two fields - login and request_count.


## Technologies 

* Java 
* Spring Boot version 2.5.0
* Lombok 
* Logger
* Hibernate
* H2
* Swagger 2


## Documentation

Go to http://localhost:8080/swagger-ui.html#/ to see API documentation 

## Tests

The application has been tested using Swagger.
For login "fabpot" give the following result:

curl -X GET "http://localhost:8080/users/fabpot" -H "accept: application/json"

Request URL: http://localhost:8080/users/fabpot

Server response: Code 200 OK, Details:

{

  "id": 47313,
  
  "login": "fabpot",
  
  "name": "Fabien Potencier",
  
  "type": "User",
  
  "avatarUrl": "https://avatars.githubusercontent.com/u/47313?v=4",
  
  "createdAt": "2009-01-17T13:42:51Z",
  
  "calcuations": 11470
  
}

Response headers

 connection: keep-alive 
 
 content-type: application/json 
 
 date: Sun, 30 May 2021 19:34:21 GMT 
 
 keep-alive: timeout=60 
 
 transfer-encoding: Identity 



## Endpoint

GET (getUserInformation) "http=//localhost:8080/users/{login}" (login - user GitHub login)
