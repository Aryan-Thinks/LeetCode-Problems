-- https://leetcode.com/problems/percentage-of-users-attended-a-contest

-- Find the percentage of users registered in each contest

SELECT
    r.contest_id,

    -- (Registered users / Total users) × 100
    ROUND(
        COUNT(r.user_id) * 100.0 /
        (SELECT COUNT(*) FROM Users),
        2
    ) AS percentage

FROM Register AS r

-- Count registrations for each contest
GROUP BY r.contest_id

-- Highest percentage first
-- If tied, smaller contest_id first
ORDER BY percentage DESC, r.contest_id ASC;