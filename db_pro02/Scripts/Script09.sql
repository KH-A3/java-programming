/*
 * 다음의 요구 사항에 맞추어 데이터 베이스 작업을 진행 한다.
 *     1. 관리자 계정으로 devAdmin 계정을 새로 만들고 데이터베이스 원격 접속과
 *        테이블 생성, 수정, 삭제 / 데이터 추가, 수정, 삭제 / 뷰 테이블 생성을
 *        할 수 있는 권한을 부여 한다.
 *     2. devAdmin 계정으로 접속하고 회원관리를 위한 테이블(USER_ACCOUNT)을 생성한다. 테이블에는
 *        ID, 회원계정명, 회원패스워드, 회원이름 정보를 관리 할 수 있도록 컬럼을 생성한다.
 *     3. 2 번에서 생성한 데이터베이스와 외래키로 관계를 맺는 회원정보 테이블(USER_INFO)을 생성한다.
 *        테이블에는 ID, 성별, 나이, 이메일, 주소, 전화번호 정보를 관리 할 수 있도록 컬럼을 생성한다.
 *        ID 컬럼은 USER_ACCOUNT 와 외래키 관계를 가지는 컬럼으로 생성한다.
 *     4. 2번, 3번에서 생성한 테이블에 데이터를 3개 추가 한다.
 *        데이터를 추가 할 때 ID 컬럼에 대해서는 SEQUENCE 객체를 사용하여 값이 자동으로 생성될 수 있게한다.
 *     5. VIEW 를 만들어서 두 개의 테이블 정보가 모두 조회될 수 있도록 한다.
 *        성별에 대해서는 남성, 여성으로 변환되게 하며, 패스워드는 * 문자로 마스킹 한다.
 */
CREATE USER devAdmin IDENTIFIED BY rPqkfwk12345678;

GRANT CONNECT, RESOURCE, CREATE SESSION
    , CREATE VIEW, INSERT ANY TABLE
    , UPDATE ANY TABLE, DELETE ANY TABLE
  TO devAdmin;
ALTER USER devAdmin quota 10M ON DATA;
 
SELECT * FROM ALL_USERS WHERE USERNAME = 'DEVADMIN';
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'DEVADMIN';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'DEVADMIN';

-- SELECT * FROM USER_ROLE_PRIVS;
-- SELECT * FROM USER_SYS_PRIVS;

COMMIT;

CREATE TABLE USER_ACCOUNT (
       ID        NUMBER        CONSTRAINT PK_USER_ACCOUNT_ID       PRIMARY KEY
     , USERNAME  VARCHAR(50)   CONSTRAINT NN_USER_ACCOUNT_USERNAME NOT NULL
     , PASSWORD  VARCHAR(50)   CONSTRAINT NN_USER_ACCOUNT_PASSWORD NOT NULL
     , NAME      VARCHAR(50)   CONSTRAINT NN_USER_ACCOUNT_NAME     NOT NULL
);

CREATE TABLE USER_INFO(
       ID      NUMBER        CONSTRAINT PK_USER_INFO_ID     PRIMARY KEY
     , GENDER  CHAR(1)       CONSTRAINT CK_USER_INFO_GENDER CHECK(GENDER IN ('F', 'M'))
     , AGE     NUMBER(3)     CONSTRAINT CK_USER_INFO_AGE    CHECK(AGE BETWEEN 0 AND 199)
     , EMAIL   VARCHAR(100)
     , PHONE   VARCHAR(13)
     , CONSTRAINT FK_USER_INFO_ID FOREIGN KEY(ID) REFERENCES USER_ACCOUNT(ID)
);

CREATE SEQUENCE USER_ACCOUNT_SEQ NOCACHE;

SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;
SELECT * FROM ALL_ALL_TABLES WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';
SELECT * FROM ALL_TAB_COLUMNS WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';
SELECT * FROM USER_CONSTRAINTS WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';
SELECT * FROM USER_SEQUENCES;

COMMIT;

SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;

INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user1', 'user1', '사용자1');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'F', 20, NULL, NULL);

INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user2', 'user2', '사용자2');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'M', 22, NULL, NULL);

INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user3', 'user3', '사용자3');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'F', 24, NULL, NULL);


CREATE OR REPLACE VIEW V_USER_INFO
    AS SELECT A.ID
            , A.USERNAME
            , REPLACE(A.PASSWORD, A.PASSWORD, RPAD('*', (SELECT DATA_LENGTH
                                                           FROM USER_TAB_COLUMNS
                                                          WHERE TABLE_NAME = 'USER_ACCOUNT'
                                                            AND COLUMN_NAME = 'PASSWORD'), '*')) AS PASSWORD
            , A.NAME
            , DECODE(B.GENDER, 'F', '여성', 'M', '남성') AS GENDER
            , B.AGE
            , B.EMAIL
            , B.PHONE
         FROM USER_ACCOUNT A
         JOIN USER_INFO B
           ON A.ID = B.ID;

SELECT * FROM V_USER_INFO;


