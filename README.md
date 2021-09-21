# TODO APP
## _A simple online TODO list_

[![N|Solid](https://miro.medium.com/max/716/1*98O4Gb5HLSlmdUkKg1DP1Q.png)](https://spring.io/)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This boot application exposes APIs for a basic todo application.

- The application stores necessary data in an in-memory database - H2
- The application provides swagger ui for understanding the endpoin
- ✨A naive UI that runs on these exposed services.✨

## Features

• A user can view her/his task list 
• User can add/remove task 
• All changes be persisted within an application run 
• Each task has the date of last updates and a task description 
• All changes can be persistent to allow view them with page refresh 
• Unit Test

## Tech

- [Gradle] - Packaged as a gradle project - 7.1.1
- [Java] - Built on open-JDK11
- [Spring Boot] - Leverages web MVC framework provided by Spring Boot 2.5.4
- [H2] - Markdown parser done right. Fast and easy to extend.
- [JUnit] - great UI boilerplate for modern web apps
- [Swagger] - evented I/O for the backend

And of course sourced as an open source with a [public repository][dill]
 on GitHub.

## Installation

Requires [Java11](https://www.oracle.com/java/technologies/downloads/#java11) v11+ to run.

Install the dependencies and start the server on Intellij or any other IDE of choice.

```
from package com.ey.api.todo
run TodoApplication.main()
```

From jar...

```
java -jar todo-0.0.1-SNAPSHOT-plain.jar
```

Application starts as port 8080


Swagger Path :

```
http://localhost:8080/swagger-ui/#/todo-controller/deleteTodoUsingDELETE
```
Sample Payload:

```
{
  "id": 1,
  "task": "Some Task",
  "completed": true,
  "createdBy": "Neha"
}
```

## Approach



## Design patterns used


## Future Inhacements

## Curls For Testing:

Add /Update Todo

```
curl -X POST "http://localhost:8080/v1/api/todo/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"completed\": true, \"createdBy\": \"Neha\", \"id\": 1, \"task\": \"Some more Task\", \"timeCreate\": \"2021-09-20T13:59:55.801Z\"}"
```

Get All Todos
```
curl -X GET "http://localhost:8080/v1/api/todo/" -H "accept: */*"
```

Get Todo by id
```
curl -X GET "http://localhost:8080/v1/api/todo/todo/1" -H "accept: */*"
```

Delete Todo by id
```
curl -X DELETE "http://localhost:8080/v1/api/todo/todo/1" -H "accept: */*"
```


