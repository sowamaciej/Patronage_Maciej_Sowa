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
     "vehicleBrand",
     "vehicleType",
     "vehicleModel",
     "dateOfProduction",
     "vinNumber",
     "weight",
     "fuelType",
     "engineCapacity",
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
     "vehicleBrand",
     "vehicleType",
     "vehicleModel",
     "dateOfProduction",
     "vinNumber",
     "weight",
     "fuelType",
     "engineCapacity",
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
         "vehicleBrand",
         "vehicleType",
         "vehicleModel",
         "dateOfProduction",
         "vinNumber",
         "weight",
         "fuelType",
         "engineCapacity",
         "numberOfSeats"
    }
]
```
- Response:
```
[
    {
         "id",
         "vehicleBrand",
         "vehicleType",
         "vehicleModel",
         "dateOfProduction",
         "vinNumber",
         "weight",
         "fuelType",
         "engineCapacity",
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
         "vehicleBrand",
         "vehicleType",
         "vehicleModel",
         "dateOfProduction",
         "vinNumber",
         "weight",
         "fuelType",
         "engineCapacity",
         "numberOfSeats"
    }
]
```
- Response:
```
[
    {
         "id",
         "vehicleBrand",
         "vehicleType",
         "vehicleModel",
         "dateOfProduction",
         "vinNumber",
         "weight",
         "fuelType",
         "engineCapacity",
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
     "vehicleBrand",
     "vehicleType",
     "vehicleModel",
     "dateOfProduction",
     "vinNumber",
     "weight",
     "fuelType",
     "engineCapacity",
     "numberOfSeats"
    }
]
```
