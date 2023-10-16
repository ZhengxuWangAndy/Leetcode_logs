-- Exchange Seats

-- Write a solution to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
-- Return the result table ordered by id in ascending order.

select (
    case 
        when mod(id, 2) = 0 then id - 1
        when mod(id, 2) != 0 and id = counts then id
        else id + 1
    end
) as id, student
from Seat,(
    select distinct count(*) as counts
    from Seat
) as seat_counts
order by id