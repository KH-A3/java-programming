SELECT FIRST_NAME
     , LENGTH(FIRST_NAME)
  FROM EMPLOYEES;


SELECT LENGTH('Hello') AS Col1
     , LENGTH('안녕') AS Col2
     , LENGTHB('Hello') Col3
     , LENGTHB('안녕') Col4
  FROM DUAL;


SELECT INSTR('sample@example.com', '@') AS Col1
     , INSTR('sample@example.com', '@', -1) AS Col2
     , INSTR('sample@example.com', 'e') AS Col3
     , INSTR('sample@example.com', 'e', -1) AS Col4
     , INSTR('sample@example.com', 'e', 1, 2) AS Col5
     , INSTR('sample@example.com', 'e', -1, 2) AS Col6
  FROM DUAL;
