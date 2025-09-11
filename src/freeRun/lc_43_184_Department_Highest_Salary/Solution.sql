SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
         JOIN (
    SELECT
        departmentId,
        MAX(salary) AS max_salary
    FROM Employee
    GROUP BY departmentId
) ds
              ON e.departmentId = ds.departmentId
                  AND e.salary = ds.max_salary
         JOIN Department d
              ON d.id = e.departmentId;
