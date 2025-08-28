select s1.score, (select count(Distinct score) from scores s2 where s2.score >= s1.score ) as 'Rank' from scores s1 order by s1.score desc
