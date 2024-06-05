# Currency Exchange Rates Parser

## Description

This project is designed to retrieve and parse currency exchange rates from Belarusbank using Java. The project uses the Jackson library for JSON processing and an HTTP client for making HTTP requests.

## Project Structure

- `Main`: The main class that performs an HTTP request to the bank's API and parses the received data.
- `City`: A class for storing information about the city.
- `CurrencyRate`: A class for storing currency exchange rates.
- `Filial`: A class for storing information about the bank's branch and its currency rates.
- `FilialInfo`: A class for parsing the JSON response and storing information about the branches.

## Dependencies

The project uses the following dependencies:

- `com.fasterxml.jackson.core:jackson-core`
- `com.fasterxml.jackson.core:jackson-databind`
- `org.apache.commons:commons-lang3`
- `org.projectlombok:lombok`

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/AriiSib/belarusBnakApi.git
    cd belarusBnakApi
    ```

2. Ensure you have Java 21 and Maven installed.

3. Build the project:
    ```sh
    mvn clean install
    ```

## Running the Project
### Using IntelliJ IDEA
1. Open the Main class in the org.example package.
2. Click the green run button next to the main method or use the shortcut Shift + F10.

### Using Maven
You can also run the project from the command line using Maven. To do this, execute the following command:
```sh
mvn clean compile exec:java
```
