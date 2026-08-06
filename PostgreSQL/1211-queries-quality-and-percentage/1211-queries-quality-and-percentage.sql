SELECT
    query_name,

    -- Average of (rating / position)
    ROUND(AVG(rating::numeric / position), 2) AS quality,

    -- Percentage of queries with rating < 3
    ROUND(
        AVG(CASE WHEN rating < 3 THEN 100.0 ELSE 0 END),
        2
    ) AS poor_query_percentage

FROM Queries

-- Calculate metrics for each query name
GROUP BY query_name;