-- Department Highest Salary


-- Write a solution to find employees who have the highest salary in each of the departments.
-- Return the result table in any order.

-- // my code : checkout max value using sub query and use 2 inner join to get these data and mapping with name
select distinct D.name as Department, E.name as Employee, E.Salary as Salary
from Employee as E inner join (
    select distinct departmentId, MAX(salary) as salary
    from Employee
    group by departmentId ) as K on E.salary = K.salary and E.departmentId = K.departmentId
inner join Department as D on E.departmentId = D.id



-- Official solution: using where () in () to filter the subquery and final data

select Department.name as 'Department', Employee.name as 'Employee', Salary
from Employee join Department on Employee.departmentId = Department.Id
where (Employee.departmentId, Salary) in (
    select
        departmentId, max(Salary)
    from
        Employee
    group by
        departmentId
)