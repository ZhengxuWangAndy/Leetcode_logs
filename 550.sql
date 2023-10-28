-- Game Play Analysis

-- Write a solution to report the fraction of players that logged in again on the day after the day they first logged in, rounded to 2 decimal places. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.

select round(count(player_id) / (select count(distinct player_id) from activity) , 2) as fraction
from Activity
where (player_id, DATE_SUB(event_date, interval 1 day))
in (
    select player_id, min(event_date) as first_login from Activity group by player_id
)