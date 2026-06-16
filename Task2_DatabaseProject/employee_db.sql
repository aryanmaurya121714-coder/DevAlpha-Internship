CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);