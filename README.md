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
- The MVC architecture was used for the design of the application.

### Model (Entity)

The `Member` entity represents a company member with the following attributes:

- `firstName`: String
- `lastName`: String
- `birthDate`: LocalDate
- `country`: String
- `city`: String

### Repository

The `MemberRepository` interface provides methods to perform CRUD operations on `Member` entities.

### Service

The `MemberService` class contains the business logic. It validates the age of the member and checks for duplicate members before saving them to the database. The service ensures:
- Members are at least 18 years old.
- Duplicate members (based on first name, last name, country, and city) are not allowed.

### Controller

The `MemberController` class handles HTTP requests and responses. It includes methods to:
- Display a home page with the options
- Display the list of members.
- Display the form to add a new member.
- Handle form submissions to add a new member.
- Handle validation errors and display user-friendly error messages.

### View (Thymeleaf Templates)

#### Base Template

The `base.html` template is used as a home page layout.

#### Add Member Template

The `add-member.html` template includes a form for adding new members and displays error messages for validation failures, such as:
- Member must be at least 18 years old.
- Duplicate member entries based on first name, last name, country, and city.

#### Members List Template

The `members_list.html` template displays the list of members.
