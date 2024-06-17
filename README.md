# CakeTracker

Cake Tracker is a management tool to track birthdays of company members in a remote multinational company. This application allows adding members, viewing a list of all members, and sorting members by upcoming birthdays.

## Features

- Add a member with attributes: First Name, Last Name, Birth Date, Country, City
- List all company members with their information
- Sort members by the closest upcoming birthdays

## Basic requirements

- JDK 17 or later
- Maven 3.9.0 or later

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/Codyru/CakeTracker.git
    ```
2. Navigate to the project directory:
    ```sh
    cd cake-tracker
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```
4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage

- Open your web browser and navigate to `http://localhost:8080/`.
- Use the navigation links to add a member or view the sorted list of members by upcoming birthdays.

## Design Documentation

- The project follows a layered architecture with a clear separation of concerns.
