select * from tab;


select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees;

create table emp_copy as
select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees;

select * from emp_copy;

update emp e
set e.sal = (
   select sal 
   from ( select d.did, avg(e2.sal) as sal 
         from dep d, emp e2 where d.did=90
         and d.did = e2.did
         group by d.did) t
   where e.did = d.did)
where e.did in (select d2.did from dep d2 where d.did=90 );