-- Write your PostgreSQL query statement below
SELECT unique_id, name
FROM employees as emp
LEFT JOIN EmployeeUNI as eun
    ON emp.id = eun.id;