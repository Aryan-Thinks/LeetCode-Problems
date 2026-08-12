-- Step 1: Find the first order for each customer
-- ROW_NUMBER() ranks each customer's orders by order_date.
WITH first_orders AS (
    SELECT
        customer_id,
        order_date,
        customer_pref_delivery_date,

        -- The earliest order gets rn = 1
        ROW_NUMBER() OVER (
            PARTITION BY customer_id
            ORDER BY order_date
        ) AS rn
    FROM Delivery
)

-- Step 2: Calculate the percentage of immediate first orders
SELECT
    ROUND(
        100.0 * AVG(
            CASE
                -- Immediate order means:
                -- preferred delivery date = order date
                WHEN order_date = customer_pref_delivery_date
                THEN 1
                ELSE 0
            END
        ),
        2
    ) AS immediate_percentage
FROM first_orders
WHERE rn = 1;  -- Keep only each customer's first order