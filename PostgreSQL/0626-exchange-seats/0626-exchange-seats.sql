-- Write your PostgreSQL query statement below

SELECT
    CASE
        -- If it is the last odd seat, keep id as is
        WHEN id % 2 = 1 AND id = (SELECT COUNT(*) FROM Seat) THEN id
        -- If id is odd, move it forward by 1
        WHEN id % 2 = 1 THEN id + 1
        -- If id is even, move it back by 1
        ELSE id - 1
    END AS id,
    student
FROM Seat
ORDER BY id;