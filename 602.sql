-- Friend Requests II: Who Has the Most Friends

-- Write a solution to find the people who have the most friends and the most friends number.
-- The test cases are generated so that only one person has the most friends.
-- The result format is in the following example.


-- Union will get unique result and Union all can get all
select id, count(id) as num
from
(
    (select requester_id as id
    from RequestAccepted)
    union all
    (select accepter_id as id
    from RequestAccepted)
) as Combined
group by id
order by count(id) desc limit 1