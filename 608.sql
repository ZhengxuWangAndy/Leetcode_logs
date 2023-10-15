-- Tree Node

-- Each node in the tree can be one of three types:

-- "Leaf": if the node is a leaf node.
-- "Root": if the node is the root of the tree.
-- "Inner": If the node is neither a leaf node nor a root node.
-- Write a solution to report the type of each node in the tree.

-- Return the result table in any order.


-- separatly select these 3 types and union them all
select id, 'Inner' as type
from Tree
where id in (
    select distinct p_id
    from Tree
    where p_id is not null
) and p_id is not null
union all
select id, 'Root' as type
from Tree
where p_id is null
union all
select id, 'Leaf' as type
from Tree
where id not in (
    select distinct p_id
    from Tree
    where p_id is not null
) and p_id is not null


-- use case when to separate
select id,
    case
        when Tree.id = (select Tree.id from Tree where p_id is null)
            then 'Root'
        when Tree.id in (select Tree.p_id from Tree)
            then 'Inner'
        else 'Leaf'
    end as type
from Tree


-- use if sentence to separate
select id, 
    if(isnull(Tree.p_id), 'Root', if(Tree.id in (
        select p_id from Tree), 'Inner', 'Leaf')) as type
from Tree