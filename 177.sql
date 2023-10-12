-- Nth highest salary

-- Write a solution to find the nth highest salary from the Employee table. If there is no nth highest salary, return null.

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

# declare M INT;
set N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
select
    IFNULL(
    (select DISTINCT salary
    as SecondHighestSalary
    from Employee
    order by salary desc
    limit 1 offset N ),null)
);
END