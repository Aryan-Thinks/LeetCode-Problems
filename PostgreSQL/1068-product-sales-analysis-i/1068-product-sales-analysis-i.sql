SELECT p.product_name, year, price
FROM sales AS s
INNER JOIN product AS p
    ON s.product_id = p.product_id;