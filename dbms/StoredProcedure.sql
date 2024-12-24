CREATE PROCEDURE GetAverageDepartmentSalaries
AS
BEGIN
    SELECT d.DepartmentID, 
           d.DepartmentName, 
           AVG(e.Salary) AS AverageSalary
    FROM Department d
    LEFT JOIN Employee e ON d.DepartmentID = e.DepartmentID
    GROUP BY d.DepartmentID, d.DepartmentName;
END;

EXEC GetAverageDepartmentSalaries;

