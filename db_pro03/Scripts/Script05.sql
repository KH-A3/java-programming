/*
 * 상품 재고 관리를 위한 테이블
 *     재고입출고 테이블
 *         - 상품에 대한 입고/출고 내역을 저장하는 테이블
 * 
 *     재고관리 테이블
 *         - 상품에 대한 전체 재고 수량을 관리하는 테이블
 * 
 * 요구사항
 *     - 재고 입고가 발생하는 경우 재고관리 테이블에 동일한 이름의 상품이 없는 경우
 *       재고관리에 새로운 상품으로 추가한다.
 *       동일한 이름의 상품이 있는 경우 기존 수량을 증가시킨다.
 *     - 재고 출고가 발생하는 경우 재고관리 테이블에 동일한 이름의 상품이 없는 경우 -> 에러
 *       동일한 이름의 상품이 있는 경우 기존 수량을 감소시킨다. 만약 차감된 수량이 마이너스가
 *       된 경우 롤백(ROLLBACK)을 한다.
 */
CREATE TABLE 재고입출고(
       PID    NUMBER                     CONSTRAINT PK_재고입출고_PID    PRIMARY KEY
     , PNAME  VARCHAR2(100)              CONSTRAINT NN_재고입출고_PNAME  NOT NULL
     , PTYPE  CHAR(1)                    CONSTRAINT CK_재고입출고_PTYPE  CHECK(PTYPE IN ('I', 'O'))
     , PCNT   NUMBER         DEFAULT(1)  CONSTRAINT NN_재고입출고_PCNT   NOT NULL
     , PDATE  DATE                       CONSTRAINT NN_재고입출고_PDATE  NOT NULL
);

CREATE TABLE 재고관리(
       PID     NUMBER         CONSTRAINT PK_재고관리_PID     PRIMARY KEY
     , PNAME   VARCHAR2(100)  CONSTRAINT NN_재고관리_PNAME   NOT NULL
     , PTOTAL  NUMBER         CONSTRAINT NN_재고관리_PTOTAL  NOT NULL
);

CREATE SEQUENCE SEQ_재고입출고 NOCACHE;

CREATE SEQUENCE SEQ_재고관리 NOCACHE;


CREATE OR REPLACE PROCEDURE PROC_재고입출등록(
       inout_name  IN   VARCHAR2
     , inout_type  IN   VARCHAR2
     , inout_cnt   IN   NUMBER
     , inout_date  IN   DATE
     , res_count   OUT  NUMBER
)
IS
    var_type VARCHAR2(1) := inout_type;
BEGIN
	var_type := UPPER(inout_type);
    INSERT INTO 재고입출고 VALUES(SEQ_재고입출고.NEXTVAL, inout_name, var_type, inout_cnt, inout_date);
    
    INSERT INTO 재고관리 VALUES(SEQ_재고관리.NEXTVAL, inout_name, inout_cnt);
    res_count := 1;
END;

SELECT * FROM USER_ERRORS;

DECLARE
    res_count  NUMBER;
BEGIN
    PROC_재고입출등록('상품A', 'i', 5, TO_DATE(20220506), res_count);
    PROC_재고입출등록('상품A', 'i', 10, TO_DATE(20220507), res_count);
    DBMS_OUTPUT.PUT_LINE('실행 결과 : ' || res_count || ' 개 행이 반영되었습니다.');
END;


SELECT * FROM 재고입출고;
SELECT * FROM 재고관리;
SELECT * FROM USER_SEQUENCES;

DELETE FROM 재고입출고;
DELETE FROM 재고관리;
COMMIT;



