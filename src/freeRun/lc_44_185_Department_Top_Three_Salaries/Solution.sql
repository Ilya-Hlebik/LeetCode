SELECT d.name   AS Department,
       e.name   AS Employee,
       e.salary AS Salary
FROM   employee e
           JOIN department d
                ON d.id = e.departmentid
WHERE  e.salary IN (SELECT salary
                    FROM   (SELECT DISTINCT( salary )
                            FROM   employee e3
                            WHERE  e.departmentid = e3.departmentid
                            ORDER  BY e3.salary DESC
                                LIMIT  3) t)
