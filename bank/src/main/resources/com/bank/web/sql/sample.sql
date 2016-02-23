-- 직원의 평균 연봉보다 더 많이 받는 직원 수
select count(*)
from emp
where sal >= (select avg(sal) from emp );

--업무 
select eid 직원번호, ename 직원명, jid 업무번호
from emp
where (eid,jid) in (select eid,jid from job_his);

select
j.eid 사원번호,
(select e.ename from emp e where e.eid = j.eid) 사원명, 
j.did 부서번호,
(select d.dname from dep d where j.did = d.did) 부서명
from job_his j;