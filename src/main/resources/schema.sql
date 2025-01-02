DROP TABLE IF EXISTS CartContents, Cart, Payment, Account, Customer, CustomerOrder, Product;

CREATE TABLE Product (
                         id INT PRIMARY KEY,
                         name VARCHAR(255),
                         price DECIMAL(10, 2),
                         stock_count INT,
                         description TEXT,
                         version INT
);

CREATE TABLE CustomerOrder (
                               id INT PRIMARY KEY,
                               order_amount DECIMAL(10, 2),
                               order_date DATE,
                               version INT
);

CREATE TABLE Customer (
                          id INT PRIMARY KEY,
                          username VARCHAR(255),
                          password VARCHAR(100),
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          customer_email VARCHAR(255),
                          created DATE,
                          version INT
);


CREATE TABLE Payment (
                         id INT PRIMARY KEY,
                         type VARCHAR(50),
                         amount DECIMAL(10, 2),
                         version INT
);

CREATE TABLE Cart (
                      id INT PRIMARY KEY,
                      customer_ID INT,
                      version INT,
                      FOREIGN KEY (customer_ID) REFERENCES Customer(id)
);

CREATE TABLE CartContents(
                             product_ID INT,
                             customer_ID INT,
                             quantity INT,
                             PRIMARY KEY(product_ID, customer_ID),
                             FOREIGN KEY (customer_ID) REFERENCES Customer(id),
                             FOREIGN KEY (product_ID) REFERENCES Product(id)
);