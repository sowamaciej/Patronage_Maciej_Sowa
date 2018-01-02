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




