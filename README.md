<h1> Ambula Project </h1> 

Created a spring boot project using Gradle with the following requirements
1. There will be 2 users (ADMIN, READER).
2. ADMIN can perform CRUDE operations like POST, DELETE, PATCH, etc.
3. READER can perform only GET operation.
4. Create a REST API called create_data which creates a table in the database with the name 'user_location'.
5. user_location will have three fields NAME, Latitude, and Longitude.
6. user can update the user_location table using another REST API called update_data
7. READER can call the get_users/N which returns the nearest N users from the location (0,0).

## Technology Used
### SpringBoot
### H2-database
### Postman
### Basic Authentication

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) 17
- Postman or any REST API testing tool

## Installation and Setup

Follow these steps to install and set up the application:

1. Clone the repository:
	git clone <repository-url>

2. Open any Ide of your choice and import the project

3. Download all the Gradle dependencies

4. Run the Spring boot project 


The application will start running on http://localhost:8080`.

## About the application
This Spring Boot app is used to find Nearest users Based on given Latitude and Longitude. READER can perform only GET operation. ADMIN can perform CRUDE operations like POST, PUT, GET, etc.This application uses Spring boot, H2 Database, Spring Security,Basic Authentication to perform Login Operations of Admin and Reader.

## API Endpoints

The following API endpoints are available:

- **POST http://localhost:8080/create_data : 
 ```
{
    "name":"Koti",
    "latitude":2.3,
    "longitude":3.3
}
```

- **PUT http://localhost:8080/update_data/1 :
```
{
    "id": 1,
    "name": "Motu",
    "latitude": 9.3,
    "longitude": 4.3
}

```
- **GET http://localhost:8080/get_users/3:
```
{
    "id": 1,
    "name": "Soti",
    "latitude": 3.3,
    "longitude": 7.3
}

{
    "id": 2,
    "name": "Moti",
    "latitude": 6.3,
    "longitude": 7.3
}

{
    "id": 3,
    "name": "Moti",
    "latitude": 12.3,
    "longitude": 37.3
}
```
  
## Testing the APIs

You can test the APIs using a tool like Postman:

1. Run Gradle Application in STS.

2. Open Postman or any REST API testing tool.

## Admin Tasks
3. Send a POST request to `http://localhost:8080/create_data and open Authentication tab select Basic Auth give username as <b>'admin' </b> and password as <b>'admin'</b>. give User details as follow in RequestBody
```
{
    "name":"Koti",
    "latitude":2.3,
    "longitude":3.3
}

{
    "name":"Somu",
    "latitude":7.3,
    "longitude":6.3
}
{
    "name":"Divya",
    "latitude":10.3,
    "longitude":12.3
}

{
    "name":"Raje",
    "latitude":5.3,
    "longitude":6.3
}

{
    "name":"Ram",
    "latitude":79,
    "longitude":50
}
```

4. Send a PUT request to `http://localhost:8080/update_data/4

```
{
    "name":"Raju",
    "latitude":49,
    "longitude":50
}
```
5. Send a GET request to `http://localhost:8080/get_users/2 to get <b>N</b> No.of Readers based on their Nearest location. This task will be done by Admin
```
[
    {
        "id": 1,
        "name": "Koti",
        "latitude": 2.3,
        "longitude": 3.3
    },
    {
        "id": 4,
        "name": "Raje",
        "latitude": 5.3,
        "longitude": 6.3
    }
]
```
## Reader Task
6. Send a GET request to `http://localhost:8080/get_users/3 and open Authentication tab select Basic Auth give username as <b>'reader' </b> and password as <b>'reader'</b>. and send Request to get <b>N</b> No.of Readers based on their Nearest locations.

```
[
    {
        "id": 1,
        "name": "Koti",
        "latitude": 2.3,
        "longitude": 3.3
    },
    {
        "id": 4,
        "name": "Raje",
        "latitude": 5.3,
        "longitude": 6.3
    },
    {
        "id": 2,
        "name": "Somu",
        "latitude": 7.3,
        "longitude": 6.3
    }
]
```
# h2 database Image
<img src="https://ik.imagekit.io/a7tcqauqn/New_Folder/Screenshot__641_.png?updatedAt=1689342101205">

# Thank You ...
