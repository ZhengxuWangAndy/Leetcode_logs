-- Customers Who Bought All Products

-- Write a solution to report the customer ids from the Customer table that bought all the products in the Product table.
-- Return the result table in any order.

-- using distinct count to make sure they brought all
select customer_id
from Customer
group by customer_id
having count(distinct product_key) in
(
    select count(distinct product_key)
    from Product
)

