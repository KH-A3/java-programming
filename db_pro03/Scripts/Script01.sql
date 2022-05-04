/*
 * PL/SQL
 *     - PROCEDURAL LANGUAGE / SQL
 *     - 프로그래밍 기능이 추가된 SQL
 *     - 변수 정의, 조건문, 반복문을 만들어서 SQL 문에 대한 처리 가능
 */

--SET SERVEROUTPUT ON;
DECLARE
    /*
     * 변수 선언부 영역
     */
BEGIN
	/*
	 * 프로그래밍 로직을 작성하는 영역
	 */
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
EXCEPTION
    /*
     * 예외처리 영역
     */
END;
/