-- Write your PostgreSQL query statement below

DELETE FROM Person p
WHERE EXISTS (
    SELECT 1
    FROM Person p2
    WHERE p2.email = p.email
      AND p2.id < p.id
);