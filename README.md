
# README

Rick and Morty API Exercise resolution.
#### Code resolution: https://github.com/ReBedc/rickandmorty

###### The resolution of this exercise was implemented using: Java (v11), SpringBoot (v2.6.4), Maven, Lombok and for tests JUnit, Mockito.







#### The application’s architecture uses a layered model:


- **Controller:** This layer is in charge of receiving and handling the HTTP GET calls. Extracting the relevant information, passing them to the Service layer and finally returning the results to the end user. 
- **Service:** This layer called by the controller contains the application’s logic.
- **Client:** This layer is performing the various calls to the official Rick and Morty API.



## Installation

To install the application, it first needs to be cloned from GitHub. Then Maven should be called from within the application’s folder:
```bash
  git clone https://github.com/ReBedc/rickandmorty.git
  cd rickandmorty/
  mvn clean install -DskipTests

```
The application can now be executed using the following command:

```bash
  java -jar ./target/rickandmorty-0.0.1-SNAPSHOT.jar
```

If all went well, the command will return, among other things, the following:
```bash
  Tomcat started on port(s): 3456 (http) with context path ''
  Started RickAndMortyApplication in 4.073 seconds (JVM running for 4.841)
```
    
## Usage/Examples

The application can then be reached using a browser or a tool such as Postman.
```bash
  HTTP GET http://localhost:3456/search-character-appearance?name=rick 
```
*In this example, the value of the HTTP GET parameter “name” can be changed to find the appearance of other characters.*

It takes the parameter "name" to obtain the information of the characters that matches its name.

It returns a JSON message containing the character's name, a list of episodes where it appears and its first appearance.
JSON response example:
```
{
    "name": "Abadango Cluster Princess",
    "episodes": [
        "Rest and Ricklaxation"
    ],
    "first_appearance": "August 27, 2017"
}
```
If the application don't found the character it returns an HTTP response 404 Not Found.


 


## Running Tests

To run the unit tests for the application, the following command can be used:

```bash
  mvn test
```

