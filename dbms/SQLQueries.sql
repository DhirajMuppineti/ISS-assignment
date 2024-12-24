CREATE DATABASE mydb;

USE mydb;

-- Create Department table
CREATE TABLE Department (
    DepartmentID INT PRIMARY KEY, -- Primary key is the unique + not null constraint and indexed and is used as identifier for every entry
    DepartmentName VARCHAR(100) UNIQUE NOT NULL -- department name cannot be null
);

-- Create Employee table
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Age INT CHECK (Age >= 18),  -- Age must be 18 or older
    Salary DECIMAL(10, 2) DEFAULT 50000,  -- Default salary if not specified
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

-- Insert data into Department
INSERT INTO Department (DepartmentID, DepartmentName) 
VALUES
(1, 'Sales'),
(2, 'HR'),
(3, 'IT'),
(4, 'Finance');

-- Insert data into Employee
INSERT INTO Employee (EmployeeID, FirstName, LastName, Age, Salary, DepartmentID) 
VALUES
(1, 'John', 'Doe', 30, 50000, 1),
(2, 'Jane', 'Smith', 28, 55000, 2),
(3, 'Alice', 'Johnson', 35, 70000, 3),
(4, 'Bob', 'Brown', 40, 80000, 4),
(5, 'Charlie', 'Davis', 25, 48000, 1),
(6, 'David', 'Martinez', 50, 90000, 3);

-- Get all entries from the Employee table
SELECT * FROM Employee;

INSERT INTO Employee VALUES (7, 'John', 'Brown', 34, 56000, 2);

--Get all the first names
SELECT Employee.FirstName FROM Employee;

-- Get all the unqiue first names 
SELECT DISTINCT Employee.FirstName FROM Employee;

-- Get all the Employees with Salary greater than 60000
SELECT * FROM Employee WHERE Salary > 60000;

-- Get all employees from IT and salary > 50000 or from finance and salary > 60000
SELECT * FROM Employee 
WHERE (DepartmentID = 3 OR Salary > 50000) AND (DepartmentID = 4 OR Salary > 60000);

-- Get all employees in descending order of their salaries
SELECT * FROM Employee
ORDER BY Salary DESC;

-- Updating salary of an employee
UPDATE Employee 
SET Salary = 75000 
WHERE EmployeeID = 2;

-- Deleting an employee
DELETE FROM Employee 
WHERE EmployeeID = 5;

-- Select top 3 employees in terms of salary
SELECT TOP 3 * FROM Employee
ORDER BY Salary DESC;

-- Get all employees whose first name starts with J
SELECT * FROM Employee 
WHERE FirstName LIKE 'J%';

-- Get all employees from sales and it
SELECT * FROM Employee 
WHERE DepartmentID IN (1, 3);

-- Get all employees whose ages are between 30 and 40	
SELECT * FROM Employee 
WHERE Age BETWEEN 30 AND 40;

-- Using aliases e to avoid typing long names
-- INNER JOIN between Employee and Department to get employees with their respective departments
SELECT 
    e.EmployeeID, e.FirstName, e.LastName, e.Salary, 
    d.DepartmentName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentID = d.DepartmentID;

INSERT INTO Employee VALUES (8, 'Test', 'Test', 18, 10000, NULL);
-- LEFT JOIN between Employee and Department to get all employees with their respective departments (including employees without a department)
SELECT 
    e.EmployeeID, e.FirstName, e.LastName, e.Salary, 
    d.DepartmentName
FROM Employee e
LEFT JOIN Department d
    ON e.DepartmentID = d.DepartmentID;

INSERT INTO Department VALUES (5, 'Marketing');
-- RIGHT JOIN between Employee and Department to get all departments with their respective employees (including departments without employees)
SELECT 
    e.EmployeeID, e.FirstName, e.LastName, e.Salary, 
    d.DepartmentName
FROM Employee e
RIGHT JOIN Department d
    ON e.DepartmentID = d.DepartmentID;

-- FULL JOIN between Employee and Department to get all employees and all departments
SELECT 
    e.EmployeeID, e.FirstName, e.LastName, e.Salary, 
    d.DepartmentName
FROM Employee e
FULL JOIN Department d
    ON e.DepartmentID = d.DepartmentID;

INSERT INTO Department VALUES (19, NULL) -- Won't work as DepartmentName has NOT NULL constraint
INSERT INTO Department VALUES (10, 'IT') -- Won't work as DepartmentName has UNIQUE constraint
INSERT INTO Employee VALUES (10, 'test', 'test', 18, 50000, 10) -- Won't work as Foreign Key constraint fails, There's no Department ID 10
INSERT INTO Employee VALUES (10, 'test', 'test', 16, 50000, 1) -- Won't work as Check fails on age. Employee must be atleast 18 years old

-- Deleting the employee with null department
DELETE FROM Employee 
WHERE EmployeeID = 8;

-- Insert into Employee table without specifying Salary (it will use the default value of 50000)
INSERT INTO Employee (EmployeeID, FirstName, LastName, Age, DepartmentID)
VALUES (9, 'Jack', 'Doe', 30, 1);

-- Create an index on the LastName column in Employee table to improve query retreivel based on lastname
CREATE INDEX idx_LastName ON Employee (LastName);

-- Add a birthdate column to Employee
ALTER TABLE Employee
ADD Birthdate DATE;

-- Add an auto incrementing id to employee table
ALTER TABLE Employee
ADD SerialID INT IDENTITY(1,1);

-- Drop the birthdate column
ALTER TABLE Employee
DROP COLUMN Birthdate;

-- Display average salaries of each departments
SELECT DepartmentID, AVG(Salary) AS AvgSalary
FROM Employee
GROUP BY DepartmentID;

-- Display the number of employees in each department
SELECT DepartmentID, COUNT(*) AS NumberOfEmployees
FROM Employee
GROUP BY DepartmentID;

-- Display the departments with average salary greater than 50000
SELECT DepartmentID, AVG(Salary) AS AvgSalary
FROM Employee
GROUP BY DepartmentID
HAVING AVG(Salary) > 50000;

INSERT INTO Employee VALUES (10, 'TEST', 'test', 19, NULL, 2);

-- Get the employee with null salary
SELECT * FROM Employee
WHERE Salary IS NULL;

-- Display 50000 instead of NULL
SELECT EmployeeID, COALESCE(Salary, 50000) AS Salary
FROM Employee;

INSERT INTO Employee VALUES (12, 'test', 'test', 23, 0, 2);
-- Return NULL if salary is 0
SELECT EmployeeID, NULLIF(Salary, 0) AS Salary
FROM Employee;
