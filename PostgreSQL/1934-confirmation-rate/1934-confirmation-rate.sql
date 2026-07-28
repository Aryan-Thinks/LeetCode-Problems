-- Get confirmation rate for each user
SELECT
    s.user_id,

    -- Average of confirmed actions (1 = confirmed, 0 = not confirmed)
    ROUND(
        COALESCE(
            AVG(CASE
                    WHEN c.action = 'confirmed' THEN 1.0
                    ELSE 0
                END),
            0      -- If no confirmations exist, return 0
        ),
        2          -- Round to 2 decimal places
    ) AS confirmation_rate

FROM Signups s

-- Keep all users, even if they have no confirmation records
LEFT JOIN Confirmations c
    ON s.user_id = c.user_id

-- Calculate the rate for each user
GROUP BY s.user_id;