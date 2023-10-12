-- Consectuive Numbers

-- Find all numbers that appear at least three times consecutively.
-- Return the result table in any order.
-- The result format is in the following example.


-- check id and num
select distinct l1.num
as ConsecutiveNums
from Logs l1, Logs l2, Logs l3
where l1.id = l2.id - 1 and l2.id = l3.id - 1 and l1.num = l2.num and l2.num = l3.num;


-- use variable to check in case id are not consecutive

SELECT num AS ConsecutiveNums
FROM (
  SELECT *, 
         @count := IF(@prev = num, @count + 1, 1) AS count, 
         @prev := num
  FROM Logs, (SELECT @count := 0, @prev := NULL) AS vars
  ORDER BY id
) AS tmp
WHERE count >= 3
GROUP BY num