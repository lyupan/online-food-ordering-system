# online-food-ordering-system
Spring Boot, REST API

## Overview
This project was done using Spring Boot framework, which makes it really easy to develop REST APIs.  

## How to Run the Application
### Prerequistes
1. Install docker 
2. Install IntelliJ IDEA (Not sure whether Eclipse or other IDE works)
### Start MySQL Use Docker
Use the file docker-compose.yml and .env to start the mysql database
```
docker-compose up
```
However, if you choose to start your MySQL database another way, it's totally fine.
### Config the MySQL Connection
In the folder src/main/resources/application.properties, config your database url, username and password correctly.
### Start the Application
1. Open the folder in IntelliJ IDEA
2. When the dependencies specified in the file pom.xml are automatically downloaded, run the application.
3. Post the json data in src/main/resources/init-restaurants.json to the endpoint "/restaurants/", and you'll create some sample data in the system.

## EndPoints
####Restaurant
1. /restaurants  
GET - get all restaurants  
POST - upload restaurant  
DELETE - delete all restaurant
2. /restaurants/{id}   
GET - get a restaurant by id  
DELETE - delete a restaurant by id
3. /restaurants/{id}/menus/  
GET - get all menus in the restaurant specified by id  
POST - add new menus in the restaurant specified by id  
DELETE - delete all menus in the restaurant specified by id 
### Menus
Works similar to the API for restaurant
### MenuItems
Works similar to the API for restaurant

## Testing
Due to time limitation, no unit tests is written. However, POSTMAN is used to test all endpoints. And it turns out that delete operation in menus and menuitems didn't work as expected.

## Remaining Issues
Delete operation on menus and menuitems didn't work. The problem is due to the one-to-many relationship, which I haven't found a simple solution. 