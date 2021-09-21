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
- [H2] - Uses In Memory H2 DB.
- [JUnit] - JUnit5 is used as a test framework
- [Swagger] - Endpoints are exposed on SwaggerUI

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
http://localhost:8080/swagger-ui/#/todo-controller
```
Sample Payload:

```
{
  "id": 0,
  "last_update_timestamp": "2021-09-21T13:53:14.231Z",
  "last_updated_by": "string",
  "task": "string",
  "task_status": true
}
```

## Approach

The Todo APIs provide basic functionality of an application that can be used to save a list tasks.
The tasks have properties such as task description, date when the task was updated with time stamp.
To Keep thing simple the id is auto incremented to avoid any inconsistancy in data. 
The update timestamp takes the current server time when the request was sent. This avoids any inaccuracy in the logging of tasks.

All the validations are taken care at the entity and the service level. 

The API returns a custom BadRequestException with relevent information.

All API endpoints return ResponseEntity<?> to keep the implementaion uniform.

The repository is a standered CrudRepository which could be extended for any further inhancements

## Design patterns used

The application follows MVC which is the most widely used architectural pattern for web applications. 
All classes follow he principle of Separation of Concerns.

All object lifecycle in this application is handled by Spring. This uses dependency injection.  


## Future Inhacements

Login module is very much need if we want to be storing personal task list.
This application could be extended to be used by multiple users. This would create a need for handeling the transactions better.

## Curls For Testing:

Add /Update Todo

```
curl -X POST "http://localhost:8080/v1/api/todo/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 0, \"last_update_timestamp\": \"2021-09-21T13:53:14.231Z\", \"last_updated_by\": \"Neha\", \"task\": \"Some Task\", \"task_status\": true}"

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


