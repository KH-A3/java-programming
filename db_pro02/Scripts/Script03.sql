/*
 * EMPLOYEES 테이블의 구조를 복사한 새로운 테이블 2개를 만든다.
 *     - EMP_COMMISSION 테이블을 만든다. 이 테이블은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMITSSION_PCT 컬럼을 가진다.
 *     - EMP_NO_COMMISSION 테이블을 만든다. 이 테이블은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY 컬럼을 가진다.
 */
CREATE TABLE EMP_COMMISSION
    AS SELECT EMPLOYEE_ID
            , FIRST_NAME
            , LAST_NAME
            , SALARY
            , COMMISSION_PCT
         FROM EMPLOYEES
        WHERE 1 = 0;

CREATE TABLE EMP_NO_COMMISSION
    AS SELECT EMPLOYEE_ID
            , FIRST_NAME
            , LAST_NAME
            , SALARY
         FROM EMPLOYEES
        WHERE 1 = 0;

SELECT * FROM EMP_COMMISSION;
SELECT * FROM EMP_NO_COMMISSION;

/*
 * 위 작업을 통해 생성한 테이블에 EMPLOYEES 테이블이 가지고 있는 모든 행 데이터를 추가한다.
 *     - INSERT INTO ... ( SELECT ... 구문을 사용하여 추가해 본다.
 *     - INSERT ALL INTO ... 구문을 사용하여 추가해 본다.
 * 
 * 위의 작업을 진행 할 때 DELETE FROM EMP_COMMISSION; DELETE FROM EMP_NO_COMMISSION; 을 작업 후 진행 한다.
 */
INSERT INTO EMP_COMMISSION (
       SELECT EMPLOYEE_ID
            , FIRST_NAME
            , LAST_NAME
            , SALARY
            , COMMISSION_PCT
         FROM EMPLOYEES
        WHERE COMMISSION_PCT IS NOT NULL
);

INSERT INTO EMP_NO_COMMISSION (
       SELECT EMPLOYEE_ID
            , FIRST_NAME
            , LAST_NAME
            , SALARY
         FROM EMPLOYEES
        WHERE COMMISSION_PCT IS NULL
);

INSERT ALL
  WHEN COMMISSION_PCT IS NOT NULL THEN
       INTO EMP_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY, COMMISSION_PCT)
  WHEN COMMISSION_PCT IS NULL THEN
       INTO EMP_NO_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY)
SELECT EMPLOYEE_ID, LOWER(FIRST_NAME) AS FIRST_NAME, LOWER(LAST_NAME) AS 이름, SALARY, COMMISSION_PCT
  FROM EMPLOYEES;
 
SELECT * FROM EMP_COMMISSION;
SELECT * FROM EMP_NO_COMMISSION;
COMMIT;

