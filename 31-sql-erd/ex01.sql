CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT CHECK (age >= 0),
    rank VARCHAR(10) NOT NULL,
    occupation VARCHAR(50),
    savings INT DEFAULT 0
);
