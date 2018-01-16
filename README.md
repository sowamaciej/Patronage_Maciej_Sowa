# Patronage2018_Maciej_Sowa
Simplified REST API for car dealership database
### Requirements
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven 3.x](https://maven.apache.org/download.cgi)
### Build and run
* Build
```
mvnw clean install
```

* Run
```
mvnw spring-boot:run
```
### Swagger API documentation

* http://localhost:8080/swagger-ui.html
* http://localhost:8080/v2/api-docs
### Validation
| Option | nullable |range|
| ------ | ----------- |------|
| registrationNumber  | no | max 10, first and second A-Z without repetition, then numbers
| numberOfSeats |yes |1-6|
| vehicleBrand |no  |HONDA,FIAT,SKODA
|engineCapacity|no|50 - 6999
|B - dateOfFirstRegistration|no|01/01/1900 - now()
|registrationReleaseDate|no| B - now()
### Environment variable
+ H2_STORAGE_ENABLED
  - TRUE - h2 implementation
  - FALSE - list implementation
  - default - list implementation
## Client
### Get all clients
- Request:
`GET http://localhost:8080/clients`
- Response:
```
[
    {
    "id",
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
### Get client by ID
- Request:
`GET http://localhost:8080/clients/{id}`
- Response:
```
[
    {
    "id",
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
###  Add client
- Request:
`POST http://localhost:8080/clients`
	- Header:
  `Content-Type:application/json`
  - Body:
```
[
    {
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
- Response:
```
[
    {
    "id",
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
###  Update client
- Request:
`PUT http://localhost:8080/clients/{id}`
	- Header:
  `Content-Type:application/json`
  - Body:
```
[
    {
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
- Response:
```
[
    {
    "id",
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
### Delete client by ID
- Request:
`DELETE http://localhost:8080/clients/{id}`
- Response:
```
[
    {
    "id",
    "name",
    "lastName",
    "birthDate",
    "sex",
    "pesel"
    }
]
```
## Cars
### Get all cars
- Request:
`GET http://localhost:8080/cars`
- Response:
```
[
    {
     "id",
     "registrationNumber",
     "vehicleBrand",
     "dateOfFirstRegistration",
     "engineCapacity",
     "registrationReleaseDate",
     "numberOfSeats"
    }
]
```
### Get car by id
- Request:
`GET http://localhost:8080/cars/{id}`
- Response:
```
[
    {
     "id",
     "registrationNumber",
     "vehicleBrand",
     "dateOfFirstRegistration",
     "engineCapacity",
     "registrationReleaseDate"
     "numberOfSeats"
    }
]
```
###  Add car
- Request:
`POST http://localhost:8080/cars`
	- Header:
  `Content-Type:application/json`
  - Body:
```
[
    {
         "registrationNumber",
         "vehicleBrand",
         "dateOfFirstRegistration",
         "engineCapacity",
         "registrationReleaseDate",
         "numberOfSeats"
    }
]
```
- Response:
```
[
    {
         "id",
         "registrationNumber",
         "vehicleBrand",
         "dateOfFirstRegistration",
         "engineCapacity",
         "registrationReleaseDate",
         "numberOfSeats"
    }
]
```
###  Update car
- Request:
`PUT http://localhost:8080/cars/{id}`
	- Header:
  `Content-Type:application/json`
  - Body:
```
[
    {
         "registrationNumber",
         "vehicleBrand",
         "dateOfFirstRegistration",
         "engineCapacity",
         "registrationReleaseDate",
         "numberOfSeats"
    }
]
```
- Response:
```
[
    {
         "id",
         "registrationNumber",
         "vehicleBrand",
         "dateOfFirstRegistration",
         "engineCapacity",
         "registrationReleaseDate",
         "numberOfSeats"
    }
]
```
### Delete car by id
- Request:
`DELETE http://localhost:8080/cars/{id}`
- Response:
```
[
    {
     "id",
     "registrationNumber",
     "vehicleBrand",
     "dateOfFirstRegistration",
     "engineCapacity",
     "registrationReleaseDate",
     "numberOfSeats"
    }
]
```
