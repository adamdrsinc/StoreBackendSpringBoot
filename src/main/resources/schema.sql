DROP TABLE IF EXISTS Cart, Payment, Customer, CustomerOrder, Product;

CREATE TABLE Product (
     P_ID INT PRIMARY KEY,
     Name VARCHAR(255),
     Price DECIMAL(10, 2),
     Description TEXT
);

CREATE TABLE CustomerOrder (
   Order_ID INT PRIMARY KEY,
   Order_Amount DECIMAL(10, 2),
   Order_Date DATE
);

CREATE TABLE Customer (
    Customer_ID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255)
);

CREATE TABLE Payment (
     Payment_ID INT PRIMARY KEY,
     Type VARCHAR(50),
     Amount DECIMAL(10, 2)
);

CREATE TABLE Cart (
  Cart_ID INT PRIMARY KEY,
  Customer_ID INT,
  FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID)
);