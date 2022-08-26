/*
    DUAL 테이블 :
    
    1. DUMMY 칼럼에 'X' 값을 하나 가지고 있는 테이블
    2. 아무 의미 없는 테이블
    3. 오라클에서는 FROM절이 필수이기 때문에,
       테이블이 필요없는 조회문에서 DUAL 테이블을 사용한다.
*/
DESC DUAL;

SELECT 1 + 2   --* 반드시 테이블 정보를 입력할 필요는 없다.
  FROM DUAL;
    
/*
    타입 변환 함수 :
    1. TO_NUMBER ('문자열')      : 문자열 형식의 숫자를 숫자 형식으로 변환                      (문자열 → 숫자)
    2. TO_CHAR(데이터, ['형식']) : 지정된 데이터 (주로 숫자나 날짜)를 형식에 맞는 문자열로 변환 (DATE → 문자열)
    3. TO_DATE('문자열', '형식') : 지정된 문자열을 날짜 형식으로 변환                           (문자열 → DATE)
*/

-- 1. 숫자로 변환 (TO_NUMBER)
SELECT '100', TO_NUMBER('100')
  FROM DUAL;
SELECT '1.5', TO_NUMBER('1.5')  --* 소숫점도 가능
  FROM DUAL;

-- 숫자와 '문자' 연산은 오라클에 의해서
-- 숫자와 숫자 연산으로 수정된 뒤 처리된다.
-- EX) '문자' → TO_NUMBER('문자') 방식으로 자동으로 처리한다.
SELECT 1 + '1'      -- SELECT 1 + TO_NUMBER('1')
  FROM DUAL;
    
-- '문자'와 '문자' 연산도 모두 숫자로 바꿔서 처리
SELECT '1' + '1'    -- SELECT TO_NUMBER('1') + TO_NUMBER('1')
  FROM DUAL;
  
SELECT *
  FROM EMPLOYEE
 WHERE EMP_NO = '1001';  --* WHERE EMP_NO = TO_NUMBER('1001') : 오라클이 숫자로 강제 캐스팅
 
-- 2. 문자로 변환 (TO_CHAR)
SELECT
        TO_CHAR(1234)            -- 1234   : 4자리
       ,TO_CHAR(1234,  '999999') --   1234 : 6자리, 부족한 자리 공백.
       ,TO_CHAR(1234,  '000000') -- 001234 : 6자리, 부족한 자리 0.
       ,TO_CHAR(1234,  '9,999')  -- 1,234  : 4자리, 반점 표시
       ,TO_CHAR(12345, '9,999')  -- #####  : 자릿수 부족으로 # 표시.
       ,TO_CHAR(12345, '99,999') -- 12,345
       ,TO_CHAR(1.4,   '9')      -- 1      : 형식은 정수 1자리 표기 (소수점 이하 반올림)
       ,TO_CHAR(1.6,   '9')      -- 2      : 형식은 정수 1자리 표기 (소수점 이하 반올림)
       ,TO_CHAR(0.123, '0.00')   -- 0.12   : 소숫점 이하 2자리 표기 (반올림)
       ,TO_CHAR(0.129, '0.00')   -- 0.13
       ,TO_CHAR(0.129, '9.999')  --* .129 
  FROM
       DUAL;

--  2) 날짜 → 문자로 전환 (TO_DATE)
--  현재 날짜와 시간
--     (1) SYSDATE      : DATE 타입
--     (2) SYSTIMESTAMP : TIMESTAMP 타입
SELECT
        SYSDATE       -- YY/MM/DD 형식으로 표시하지만 시간 데이터도 가지고 있다.
      , SYSTIMESTAMP   
  FROM DUAL;

SELECT
        TO_CHAR(SYSDATE, 'YYYY-MM-DD')
      , TO_CHAR(SYSDATE, 'HH:MI:SS')
  FROM DUAL;


-- 3. 날짜로 변환 (TO_DATE)
-- '05/06/07' 날짜는 언제인가? 알려주기 전에는 모름
-- 지정된 형식으로 해석
-- 예시1) 'YY/MM/DD' : 05년 06월 07일
-- 예시2) 'MM/DD/YY' : 07년 05월 06일
-- 어떤 날짜를 어떻게 해석해야 하는지 알려주는 함수
SELECT
        TO_DATE('05/06/07', 'YY/MM/DD')
       ,TO_DATE('05/06/07', 'MM/DD/YY')
  FROM
        DUAL;
        
-- 현재 날짜를 YYYY-MM-DD 형식으로 조회
SELECT TO_DATE(SYSDATE, 'YYYY-MM-DD') FROM DUAL; -- 잘못된 코드
--* 날짜를 날짜 형식으로 바꿔라? 형식도 잘못 되었고, YYYY-MM-DD 형식으로 출력되지도 않는다.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL; -- 올바른 코드
--* TO_CHAR를 사용하여 문자로 전환해줘야 한다. (*주의*)


-- 사원 테이블에서 90/01/01 ~ 99/12/31 사이에 입사한 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE TO_DATE(HIRE_DATE, 'YY/MM/DD') BETWEEN TO_DATE('90/01/01', 'YY/MM/DD') AND TO_DATE('99/12/31', 'YY/MM/DD')
 --* 실무에서는 문자타입이 성능이 좋아, DATE 타입도 VARCHAR2 타입으로 전환하여 데이터를 저장한다.
 --* 그렇기 때문에 날짜를 검색하기 위해서는 '문자타입'으로 저장된 날짜를 날짜타입으로 전환(TO_DATE)하는 것이 필수! 
 ORDER BY HIRE_DATE;


-- 예제
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    DT1 DATE
  , DT2 TIMESTAMP
  , DT3 VARCHAR2(10 BYTE)  -- YYYY-MM-DD
);

-- DT1과 DT2 칼럼에 현재 날짜 넣기
INSERT INTO
    SAMPLE (DT1, DT2, DT3)
    VALUES (SYSDATE, SYSTIMESTAMP, TO_CHAR(SYSDATE, 'YYYY-MM-DD'));
    
SELECT DT1,DT2,DT3 FROM SAMPLE;

-- 날짜 비교 연산은 TO_DATE 함수가 필요하다.
-- (1) 실패
SELECT DT1, DT2, DT3
  FROM SAMPLE
 WHERE DT1 = TO_DATE ('22/08/26', 'YY/MM/DD');
 
-- (2) 실패
SELECT DT1, DT2, DT3
  FROM SAMPLE
 WHERE DT1 = '22/08/26';

-- (3) 성공 (*주의 : 22/08/26 과 날짜가 동일해야 성공)
SELECT DT1, DT2, DT3
  FROM SAMPLE
 WHERE TO_DATE(DT1, 'YY/MM/DD') = TO_DATE ('22/08/26', 'YY/MM/DD');