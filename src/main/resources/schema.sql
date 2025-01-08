DROP TABLE IF EXISTS CartContents, Cart, Payment, Account, customer_roles, Customer, Role, CustomerOrder, Product;

CREATE TABLE Product (
                         product_id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         price DECIMAL(10, 2),
                         stock_count INT,
                         description TEXT
);

CREATE TABLE CustomerOrder (
                               customer_order_id SERIAL PRIMARY KEY,
                               order_amount DECIMAL(10, 2),
                               order_date DATE
);


CREATE TABLE Role(
                     role_id SERIAL PRIMARY KEY,
                     name VARCHAR(50)
);

CREATE TABLE Customer (
                          customer_id SERIAL PRIMARY KEY,
                          username VARCHAR(255),
                          password VARCHAR(100),
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          customer_email VARCHAR(255),
                          created DATE,
                          customer_role VARCHAR(50)
);


CREATE TABLE Payment (
                         payment_id SERIAL PRIMARY KEY,
                         type VARCHAR(50),
                         amount DECIMAL(10, 2)
);

CREATE TABLE Cart (
                      cart_id SERIAL PRIMARY KEY,
                      customer_id INT,
                      version INT,
                      FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE CartContents(
                             product_id INT,
                             customer_id INT,
                             quantity INT,
                             PRIMARY KEY(product_ID, customer_ID),
                             FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
                             FOREIGN KEY (product_ID) REFERENCES Product(product_id)
);