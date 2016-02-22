-- 0. 사원 테이블 전체 검색

select EMAIL from EMPLOYEES;
desc EMPLOYEES;
-- employee_id, first_name, last_name, email, phone_number. hire_date, job_id
-- salary, commission_pct, manager_id, department_id

select * from departments;
-- department_id, department_name, manager_id, location_id, 

-- 1.사원번호, 패밀리네임, 연봉 만 출력
select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees;

-- 2. 연봉 3000 이상인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where salary >= 3000;

-- 3. 부서번호(department_id) 이 100번인 사원

select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where department_id = 100;

-- 4.입사일이 2000년 1월 1일 이후인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉, hire_date 입사일 
from employees
where hire_date = '20030617'

-- 5. 부서가 100 번이 아닌 사원

select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where department_id != 100;

select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where department_id <> 100;

--6. 연봉이 2000~3000인 사원

select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where salary between 2000 and 3000;

select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where salary >= 2000 
and salary <= 3000;

-- 7연봉이 2000~3000 (이상,이하) 범위에 속하지 않는 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉 
from employees
where salary not between 2000 and 3000;

-- 8.커미션이 0.2, 0.3, 0.4 인 사원
select employee_id as 사원번호, last_name as 성, commission_pct as 커미션 
from employees
where commission_pct in(0.2, 0.3, 0.4);

-- 9.커미션이 0.2, 0.3, 0.4 이 아닌 사원
select employee_id as 사원번호, last_name as 성, commission_pct as 커미션 
from employees
where (commission_pct = null or commission_pct not in(0.2, 0.3, 0.4));

-- 10. 패밀리네임의 시작 알파벳이 k인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name like 'k%';

-- 11. 패밀리네임 중에 알파벨이 K인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name like '%k%';

-- 12. 패밀리네임 중에 세번째 알파벨이 a인 사원
SELECT employee_id 사원번호, last_name 성
FROM employees
WHERE last_name like '__a%';

-- 13. 구글 계정을 사용하는 직원
SELECT employee_id 사원번호, last_name 성, email 이메일
FROM employees
WHERE email like '%\@';

-- 14. 커미션을 받지 않는 직원 = 영업직이 아닌 사무적인 직원 72
SELECT employee_id 사원번호, last_name 성, commission_pct 커미션
FROM employees
WHERE commission_pct is null;

-- 15. 커미션을 받는 직원 35
SELECT employee_id 사원번호, last_name 성, commission_pct 커미션
FROM employees
WHERE commission_pct is not null;

-- 16.연봉을 작게 받는 순으로 해서 오름차순 정렬
SELECT employee_id 사원번호, last_name 성, email 이메일, salary 연봉
FROM employees
order by salary;

-- 16.연봉을 작게 받는 순으로 해서 내일차순 정렬
SELECT employee_id 사원번호, last_name 성, email 이메일, salary 연봉
FROM employees
order by salary desc;

-- 17. 고액연봉순 직원리스트(만일, 동일한 연봉을 받으면 패밀리네임에 따라 오름차순)
SELECT employee_id 사원번호, last_name 성, last_name 이름, salary 연봉
FROM employees
order by salary desc, last_name asc;




select * from EMPLOYEES;
-- employee_id, first_name, last_name, email, phone_number. hire_date, job_id
-- salary, commission_pct, manager_id, department_id

select * from departments;
-- department_id, department_name, manager_id, location_id, 

-- 18. exist 문법 (부서번호가 30, 60, 90 인 사원정보
select e.employee_id 사원번호, e.last_name 이름, e.salary 연봉, e.department_id 부서번호
from employees e
where exists
	(	select d.department_id
		from departments d
		where d.department_id in(30,60,90) 
		and e.department_id = d.department_id
		);
		
select e.employee_id 사원번호, e.last_name 이름, e.salary 연봉, e.department_id 부서번호
from employees e
where e.department_id in(30,60,90)