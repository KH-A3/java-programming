
SELECT *
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID = 10;

SELECT * FROM LOCATIONS;

SELECT * FROM EMPLOYEES;


CREATE TABLE T_MYBATIS (
       id NUMBER
     , name VARCHAR2(100)
     , today DATE
);

ALTER TABLE T_MYBATIS ADD CONSTRAINT T_MYBATIS_ID_PK PRIMARY KEY(ID);

CREATE SEQUENCE SEQ_MYBATIS;

INSERT INTO T_MYBATIS VALUES(SEQ_MYBATIS.NEXTVAL, 'test', SYSDATE);

SELECT * FROM T_MYBATIS;
DELETE FROM T_MYBATIS;


SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000
   AND DEPARTMENT_ID IN (80)
   -- AND DEPARTMENT_ID = 80
   -- AND HIRE_DATE >= TO_DATE('1990/01/01')
   -- AND HIRE_DATE <= TO_DATE('1999/12/31')
--   AND HIRE_DATE BETWEEN TO_DATE('1990/01/01') AND TO_DATE('1999/12/31');
   


   
SELECT COUNT(*) AS TOTAL
     , D.DEPARTMENT_NAME
     , D.DEPARTMENT_ID
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
-- WHERE D.DEPARTMENT_ID = 30
-- WHERE D.DEPARTMENT_ID IN (10, 20, 30, 40)
 WHERE D.DEPARTMENT_ID BETWEEN 10 AND 40
 GROUP BY D.DEPARTMENT_ID, D.DEPARTMENT_NAME;
   
   
   
   
/*
 * 자동증가 기능을 사용하여 ID 값이 중복 없이 저장 될 수 있도록 하였음.
 *     - 새로운 데이터를 추가 했을 때 추가한 데이터의 ID 를 알
 *       없는 문제를 해결해보도록 한다.
 *     - 데이터가 추가 될 때 다음과 같은 형식의 메시지가 나오도록 한다.
 *       예)
 *           ID 가 1 인 데이터가 추가 되었습니다.
 */
INSERT INTO T_MYBATIS VALUES(SEQ_MYBATIS.NEXTVAL, 'test', SYSDATE);
SELECT SEQ_MYBATIS.CURRVAL FROM DUAL;
SELECT * FROM T_MYBATIS WHERE ID = 110;


SELECT SEQ_MYBATIS.NEXTVAL FROM DUAL;
INSERT INTO T_MYBATIS VALUES(SEQ_MYBATIS.CURRVAL, 'test', SYSDATE);
SELECT * FROM T_MYBATIS WHERE ID = 89;






SELECT *
  FROM (SELECT ROWNUM AS RN
             , DEPARTMENT_ID
             , DEPARTMENT_NAME
             , MANAGER_ID
             , LOCATION_ID
          FROM (SELECT DEPARTMENT_ID
                     , DEPARTMENT_NAME
                     , MANAGER_ID
                     , LOCATION_ID
                  FROM DEPARTMENTS
                 ORDER BY 3
               )
       )
 WHERE RN BETWEEN 1 AND 10;



SELECT *
  FROM (SELECT ROWNUM AS RN
             , DEPARTMENT_ID
             , DEPARTMENT_NAME
             , MANAGER_ID
             , LOCATION_ID
          FROM DEPARTMENTS
         ORDER BY 3
       )
 WHERE RN BETWEEN 1 AND 10;






SELECT ROWNUM
     , E.EMPLOYEE_ID AS empId
     , CONCAT(FIRST_NAME, ' ' || LAST_NAME) AS empName
     , CONCAT(E.EMAIL, '@emp.com') AS email
     , J.JOB_TITLE AS jobName
     , J.JOB_ID AS jobId
     , D.DEPARTMENT_NAME AS deptName
     , D.DEPARTMENT_ID AS DeptId
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_IDp;
   
   
   
   
SELECT RN
     , empId
     , empName
     , email
     , jobName
     , jobId
     , deptName
     , deptId
  FROM (SELECT ROWNUM AS RN
             , E.EMPLOYEE_ID AS empId
		     , CONCAT(FIRST_NAME, ' ' || LAST_NAME) AS empName
		     , CONCAT(E.EMAIL, '@emp.com') AS email
		     , J.JOB_TITLE AS jobName
		     , J.JOB_ID AS jobId
		     , D.DEPARTMENT_NAME AS deptName
		     , D.DEPARTMENT_ID AS deptId
		  FROM EMPLOYEES E
		  JOIN JOBS J
		    ON E.JOB_ID = J.JOB_ID
		  JOIN DEPARTMENTS D
		    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
		 ORDER BY 2
	    )
 WHERE RN BETWEEN 21 AND 30;




SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;


SELECT SUBSTR('hello@emp.com', 1, INSTR('hello@emp.com', '@emp.com')-1) FROM DUAL;



SELECT EMPLOYEE_ID
     , FIRST_NAME
     , 'img/emp/' || EMPLOYEE_ID || '.png' AS IMG_PATH
  FROM EMPLOYEES
 ORDER BY 1;


SELECT SUBSTR('Jone Smith', 1, INSTR('Jone Smith', ' ') - 1)
	 , SUBSTR('Jone Smith', INSTR('Jone Smith', ' ') + 1, LENGTH('Jone Smith'))
 FROM DUAL;


SELECT * FROM EMPLOYEES;

SELECT * FROM JOBS;

SELECT * FROM DEPARTMENTS;

CREATE TABLE PERMISSIONS (
       empId     NUMBER
     , tableName VARCHAR2(100)
     , pRead     VARCHAR2(1)   DEFAULT('N') CHECK(pRead   IN ('Y', 'N'))
     , pAdd      VARCHAR2(1)   DEFAULT('N') CHECK(pAdd    IN ('Y', 'N'))
     , pUpdate   VARCHAR2(1)   DEFAULT('N') CHECK(pUpdate IN ('Y', 'N'))
     , pDelete   VARCHAR2(1)   DEFAULT('N') CHECK(pDelete IN ('Y', 'N'))
     , CONSTRAINT PERMISSIONS_EMPID_TABLENAME_PK PRIMARY KEY(empId, tableName)
);

INSERT INTO PERMISSIONS(empId, tableName)
SELECT EMPLOYEE_ID AS empId
     , 'employees' AS tableName
  FROM EMPLOYEES;

INSERT INTO PERMISSIONS(empId, tableName)
SELECT EMPLOYEE_ID AS empId
     , 'departments' AS tableName
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empId, tableName)
SELECT EMPLOYEE_ID AS empId
     , 'locations' AS tableName
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empId, tableName)
SELECT EMPLOYEE_ID AS empId
     , 'jobs' AS tableName
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empId, tableName, PREAD)
SELECT EMPLOYEE_ID AS empId
     , 'board' AS tableName
     , 'Y'
  FROM EMPLOYEES;

SELECT * FROM PERMISSIONS WHERE EMPID = 100;



UPDATE PERMISSIONS
   SET pRead = 'N'
 WHERE EMPID = 100
   AND TABLENAME IN ('board');
  
UPDATE PERMISSIONS
   SET TABLENAME = 'dept'
 WHERE TABLENAME = 'depts';


INSERT INTO PERMISSIONS VALUES(0, 'other', 'Y', 'N', 'N', 'N');

SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES';

















