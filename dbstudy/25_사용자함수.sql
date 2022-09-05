/*
    사용자 함수
    
    1. Function
    2. 어떤 값을 반환할 때 사용
    3. 사용자가 만든 함수의 개념
    4. 값을 반환할 때 RETURN을 사용
    5. 입력 파라미터 사용 가능 (※ 출력 파라미터 사용 X)
    6. 값을 확인할 수 있도록 SELECT문과 같은 쿼리문에서 호출
    7. 형식
        CREATE [OR REPLACE] FUNTION 함수_이름[(매개변수)]
        RETURN 반환타입
        IS
            변수선언
        BEGIN
            함수본문
        [EXCEPTION
            예외처리]
        END [함수_이름];
    
*/

-- 함수 FUNC1 정의
CREATE OR REPLACE FUNCTION FUNC1
RETURN VARCHAR2   -- 반환타입에서는 크기를 명시하지 않는다.
IS
BEGIN
    RETURN 'HELLO WORLD';   -- 반환값
END FUNC1;

-- 함수 FUNC1 호출
SELECT FUNC1()
  FROM DUAL;
  
  
-- 함수 FUNC2 정의
-- 사원번호를 전달하면 해당 사원의 FULL_NAME이 반환되는 함수

CREATE OR REPLACE FUNCTION FUNC2 (EMP_ID EMPLOYEES.EMPLOYEE_ID%TYPE)
RETURN VARCHAR2
IS
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
    LNAME EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME, LAST_NAME
      INTO FNAME, LNAME
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = EMP_ID;
    RETURN FNAME || ' ' || LNAME;
END FUNC2;

-- 함수 FUNC2 호출
SELECT FUNC2 (EMPLOYEE_ID)
  FROM EMPLOYEES;