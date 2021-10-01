# Fizz Buzz Game Service

## How To Run
* git clone Project 
  
  `git clone https://github.com/arshad2K8/FizzBuzzGame.git`
  
* `cd ~/FizzBuzzGame`
* run `./mvnw spring-boot:run`
* Open a browser and type http://localhost:8080/swagger-ui/ for swagger UI
  
  [Link to Swagger UI](http://localhost:8080/swagger-ui/)


## To Run tests

```
cd ~/FizzBuzzGame
./mvnw verify
```

# Tech Stack
* Spring Boot Web

## SWAGGER UI
* Swagger UI Endpoint
[Link to Swagger UI](http://localhost:8080/swagger-ui/)


## CRUD Endpoints

* To Start Game and Fetch Results using CURL

```

curl -X POST localhost:8080/fizzbuzz/start -d '{"startLimit":1,"endLimit":4,"sequenceStrategy":"SIMPLE","gameVersion":"V1"}' -H "Content-Type:application/json"

```

# General Design Patterns Used
* Strategy Pattern