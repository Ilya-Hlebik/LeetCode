select Distinct l1.num as ConsecutiveNums
from Logs l1
         join Logs l2 on l1.id = l2.id + 1
         join Logs l3 on l1.id = l3.id + 2
where l1.num = l2.num
  and l2.num = l3.num;



SELECT DISTINCT num AS ConsecutiveNums
FROM (SELECT num,
             LAG(num, 1) OVER (ORDER BY id) AS prev_num,
              LEAD(num, 1) OVER (ORDER BY id) AS next_num
      FROM Logs) t
WHERE num = prev_num
  AND num = next_num;
