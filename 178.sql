-- Rank Scores

-- Write a solution to find the rank of the scores. The ranking should be calculated according to the following rules:

-- The scores should be ranked from the highest to the lowest.
-- If there is a tie between two scores, both should have the same ranking.
-- After a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no holes between ranks.
-- Return the result table ordered by score in descending order.


-- use window function DENSE_RANK
select score, DENSE_RANK() over (
    order by score desc
    )
    as 'rank'
from Scores;



-- use count to count on how many scores are greater than the current one.

select S1.score,(
    select count(distinct S2.score)
    from Scores S2
    where S1.score <= S2.score
) as 'rank'
from Scores S1
order by score desc;

-- use inner join where score greater than it self and count on the distinct value to get the rank.

SELECT
  S.score,
  COUNT(DISTINCT T.score) AS 'rank'
FROM
  Scores S
  INNER JOIN Scores T ON S.score <= T.score
GROUP BY
  S.id,
  S.score
ORDER BY
  S.score DESC;
