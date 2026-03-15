# 🏠 House Price Prediction Using Linear Regression
## 📌 Project Title

House Price Prediction Using Linear Regression Technique

## 📖 Project Description

The House Price Prediction System is designed to estimate property prices using historical real estate data. The system applies the Linear Regression algorithm to model the relationship between various house features and their corresponding prices.

The system takes inputs such as state, city, location, area (square feet), number of bedrooms, number of bathrooms, and age of the house to analyze how each factor influences the final property price.

The model is trained using historical housing data so it can learn patterns and trends in property pricing. After training, the system predicts prices for new houses based on their features.

The primary objective of this system is to help buyers, sellers, and real estate agents make informed property decisions. By automating the prediction process, the system reduces manual errors in property price estimation.

The performance of the prediction model is evaluated using metrics such as:

R² Score

Mean Squared Error (MSE)

The system can also be extended into a web-based real estate price estimator tool for wider accessibility.

## 👥 System Users

The system supports two types of users:

1️⃣ Admin (Real Estate Builder)

Manages property data

Maintains state, city, and location information

Trains and retrains the prediction model

2️⃣ End User

Buyers

Real estate agents

Property investors

Users provide property details and receive predicted house prices.

## 🎯 Objective of the System

The main objective of the system is to predict the selling price of houses using the Linear Regression algorithm based on several features.

### Features used for prediction

State

City

Location

Area (square feet)

Number of bedrooms

Number of bathrooms

Age of house

### Goals

- Establish a mathematical relationship between house features and price

- Minimize prediction error

- Generate accurate real estate price predictions

- Provide useful insights for the real estate market

### ❗ Importance of the System
Helps Buyers

- revents overpaying for properties

- Helps in budget planning

- Helps Sellers

- Suggests competitive pricing

- Reduces risk of underpricing or overpricing

- Helps Real Estate Companies

- Improves market analysis

- Supports investment decisions

- Builds customer trust

- Helps Financial Institutions

- Assists banks in property valuation before approving loans

## 📌 Scope of the System
### Functional Scope

The system can:

- Collect and process housing data

- Store historical house price data

- Analyze features such as area, bedrooms, bathrooms, and location

- Apply the Linear Regression model

- Predict house prices

- Generate prediction reports

### Application Scope

- The system can be used by:

- Real Estate Agencies

- Banks and Financial Institutions

- Property Investors

- Buyers and Sellers

### Technical Scope

#### Programming Language

- Core Java

#### Libraries

- Maven

- Lombok

- JUnit

#### Database

- MySQL

## 🏗️ System Architecture

The project follows a Layered Architecture.

1️⃣ Client Application

Console interface

Accepts user input

Displays prediction results

2️⃣ Model Layer

POJO classes

Contains getters and setters

Used to transfer data between layers

3️⃣ Service Layer

Contains business logic

Data validation

Algorithm implementation

4️⃣ Repository / DAO Layer

Handles database operations

Uses JDBC / ORM frameworks

Executes SQL queries

## 📊 Linear Regression
#### What is Regression?

Regression is a statistical method used to understand the relationship between variables.

Dependent Variable → The value we want to predict

Independent Variable → The input variable used for prediction

#### Example

Predicting employee salary based on years of experience.

Salary → Dependent variable

Experience → Independent variable

#### Types of Regression

Linear Regression

Multiple Linear Regression

Polynomial Regression

#### The prediction formula used is:

#### y = mx + b

Where:

y → Dependent variable (house price)

x → Independent variable (house features)

m → Slope of the line

b → Intercept

## 👩‍💻 Author

Neha Vaidya
