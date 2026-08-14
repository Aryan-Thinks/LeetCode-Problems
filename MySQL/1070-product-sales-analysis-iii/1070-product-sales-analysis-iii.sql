-- Get the first sale year for each product
SELECT
    product_id,
    MIN(year) AS first_year,
    quantity,
    price
FROM Sales
WHERE (product_id, year) IN (
    -- Find the first year for every product
    SELECT
        product_id,
        MIN(year)
    FROM Sales
    GROUP BY product_id
)

GROUP BY product_id, year, quantity, price
ORDER BY product_id;
