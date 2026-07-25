-- Write your PostgreSQL query statement below
SELECT e.name
FROM Employee e
JOIN (
    -- Count the number of employees reporting to each manager
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) m
ON e.id = m.managerId;