/*
 * 지출내역서 테이블과 지출내역구분 테이블에 데이터를 추가/수정/삭제 하는 작업을 진행 한다.
 *     - "지출내역구분" 에는 본인의 한 달치 분량의 생활비 내역을 참고하여
 *       교통비, 식대, 수도세, 전기세 등의 구분명을 추가 한다.
 *     - "지출내역서" 에는 본인의 한 달치 분량의 실제 입출고 내역을 참고하여
 *       가계부를 작성하듯 데이터를 추가한다.
 *     - 테이블에 추가하는 데이터는 최소 5 ~ 10개 정도는 추가하도록 한다.
 */

INSERT INTO 지출내역구분 VALUES(1, '용돈');
INSERT INTO 지출내역구분 VALUES(2, '급여');
INSERT INTO 지출내역구분 VALUES(3, '교통비');
INSERT INTO 지출내역구분 VALUES(4, '식비');
INSERT INTO 지출내역구분 VALUES(5, '월세');
INSERT INTO 지출내역구분 VALUES(6, '전기세');
INSERT INTO 지출내역구분 VALUES(7, '수도세');
INSERT INTO 지출내역구분 VALUES(8, '차량유지비');
INSERT INTO 지출내역구분 VALUES(9, '유류비');


INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         1,            1, TO_DATE(20220305), 500000,      0,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         2,            4, TO_DATE(20220315),      0,  15000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         3,            6, TO_DATE(20220319),      0,  45000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         4,            5, TO_DATE(20220323),      0, 350000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         5,            3, TO_DATE(20220327),      0,  50000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         6,            1, TO_DATE(20220405), 500000,      0,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         7,            7, TO_DATE(20220416),      0,  12500,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         8,            3, TO_DATE(20220418),      0,  55000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(         9,            5, TO_DATE(20220421),      0, 350000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        10,            9, TO_DATE(20220425),      0,  40000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        11,            1, TO_DATE(20220505), 500000,      0,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        12,            4, TO_DATE(20220516),      0,  10000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        13,            3, TO_DATE(20220518),      0,  65000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        14,            5, TO_DATE(20220521),      0, 350000,   '');
INSERT INTO 지출내역서(ACCOUNT_ID, ACCOUNT_TYPE,              날짜, 입금액, 출금액, 비고)
                VALUES(        15,            8, TO_DATE(20220525),      0, 100000,   '');

               
/*
 * 위 작업을 모두 마친 후에는 다음의 작업을 추가로 진행 한다.
 *     - 입금액만을 따로 조회하여 얼마나 입금이 되었는지 통계 조회를 한다.
 *     - 출금액만을 따로 조회하여 얼마나 출금이 되었는지 통계 조회를 한다.
 *     - 위에서 조회한 데이터를 "월별지출내역" 테이블을 새로 만들어 월별로 저장될 수 있게 한다.
 *     - "월별지출내역" 테이블에는 년, 월, 지출구분, 금액 컬럼을 가지게 만들고 지출구분은 '입', '출' 만 저장되도록 한다.
 */
SELECT EXTRACT(YEAR FROM 날짜) AS 년
     , EXTRACT(MONTH FROM 날짜) AS 월
     , SUM(입금액) AS 입금액
  FROM 지출내역서
 WHERE 입금액 > 0
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

SELECT EXTRACT(YEAR FROM 날짜) AS 년
     , EXTRACT(MONTH FROM 날짜) AS 월
     , SUM(출금액) AS 출금액
  FROM 지출내역서
 WHERE 출금액 > 0
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

SELECT EXTRACT(YEAR FROM 날짜) AS 년
     , EXTRACT(MONTH FROM 날짜) AS 월
     , SUM(입금액) AS 입금액
     , SUM(출금액) AS 출금액
  FROM 지출내역서
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

CREATE TABLE 월별지출내역
    AS SELECT EXTRACT(YEAR FROM 날짜) AS 년
            , EXTRACT(MONTH FROM 날짜) AS 월
            , '입' AS 지출구분
            , 입금액 AS 금액
         FROM 지출내역서
        WHERE 1 = 0;


INSERT ALL INTO 월별지출내역 VALUES(년, 월, 지출구분, 금액)
SELECT EXTRACT(YEAR FROM 날짜) AS 년
     , EXTRACT(MONTH FROM 날짜) AS 월
     , CASE WHEN 입금액 > 0 THEN '입'
            WHEN 출금액 > 0 THEN '출'
       END 지출구분
     , SUM(입금액 + 출금액) AS 금액
  FROM 지출내역서
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜)
        , CASE WHEN 입금액 > 0 THEN '입'
               WHEN 출금액 > 0 THEN '출'
           END;


/*
 * 지출내역서에 작성된 모든 지출을 기존 금액보다 10% 인상 시키고 이를
 * 월별지출내역에도 반영하도록 한다.
 */
UPDATE 지출내역서
   SET 출금액 = 출금액 * 1.1
 WHERE 출금액 > 0;

UPDATE 월별지출내역
   SET 금액 = 금액 * 1.1
 WHERE 지출구분 = '출';

COMMIT;

SELECT * FROM 지출내역서;
SELECT * FROM 지출내역구분;
SELECT * FROM 월별지출내역;
