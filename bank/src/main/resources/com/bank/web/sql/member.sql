select * from test;
drop table member;
SELECT * FROM member;
	
-- 실행 단축키 : alt + x
CREATE TABLE member(
	userid VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30),
	password VARCHAR2(30),
	addr VARCHAR2(30),
	birth NUMBER
);

INSERT INTO member(userid,name,password,addr,birth) VALUES ('kim','김유신','1','서울',2000);
INSERT INTO member(userid,name,password,addr,birth) VALUES ('lee','이순신','1','안양',1990);
INSERT INTO member(userid,name,password,addr,birth) VALUES ('kang','강감찬','1','경기',1950);

select * from member;