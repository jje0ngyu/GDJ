/*
    DQL :
    
    1. Data Query Language
    2. 데이터 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터베이스에 변화가 없으므로 COMMIT 없음
        (트랜잭션의 대상이 아님)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
            FROM 테이블_이름
            [WHERE 조건]      --이하 [ ]문장은 생략가능
            [GROUP BY 그룹화]
            [HAVING 그룹화_조건식]
            [ORDER BY 정렬]
            
    6. 실행 순서
    ⑤  SELECT 칼럼
    ①    FROM 테이블
    ②   WHERE 조건식
    ③   GROUP BY 그룹화
    ④  HAVING 그룹화_조건식
    ⑥   ORDER BY 정렬기준
*/

-- 1. 사원 테이블에서 사원명 조회하기
SELECT NAME
  FROM EMPLOYEE;

-- 1) 테이블에 오너(OWNER) 명시
SELECT NAME
    FROM SCOTT.EMPLOYEE;
-- 2) 칼럼에 테이블 명시
SELECT EMPLOYEE.NAME
    FROM EMPLOYEE;
-- 3) 테이블에 별명 지정 ★
SELECT EMP.NAME
    FROM EMPLOYEE EMP; --별명 EMP 지정
-- 4) 칼럼에 별명(ALIAS) 지정 ★
SELECT NAME AS 사원명  --별명 사원명 지정
    FROM EMPLOYEE;


-- 2. 사원 테이블의 모든 칼럼 조회하기
--      모든 칼럼 : *  (에스터리스크)
--      중요 : 실무에서 * 사용금지 ★   (프로젝트에서도 사용 X)
--*     편의를 위해 * 사용,  성능에 문제가 있다.
SELECT *
    FROM EMPLOYEE;
    
-- 모든 칼럼이 필요하면 모두 명시 ★
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE;
    
-- 3. 부서 테이블에서 지역명 조회하기
--      단, 동일한 지역은 한 번만 조회하기
--      중복 제거 : DISTINCT
SELECT DISTINCT LOCATION  --* 지역만 출력 (동일할 경우 1개만 출력)
    FROM DEPARTMENT;
    
SELECT DISTINCT DEPT_NAME, LOCATION --* 부서명 & 지역만 출력 (부서명 AND 지역이 동일할 경우 1개만 출력)
    FROM DEPARTMENT;

-- 4. 사원 테이블에서 직급이 '과장'인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE POSITION = '과장';

-- 5. 사원 테이블에서 급여가 200만 ~ 500만인사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE SALARY>= 2000000 AND SALARY <= 5000000;
   
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE SALARY BETWEEN 2000000 AND 5000000; -- BETWEEN ~ AND  (권장 ★)
   
-- 6. 사원 테이블에서 소속부서가 1,2인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE DEPART = 1 OR DEPART = 2;
   
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE DEPART IN (1,2); 
   
-- 7. 사원 테이블에서 성별이 없는 사원 조회
--      NULL 유무 :
--      1) NULL 이다  : IS NULL  (* 주의 : A = NULL  과 값이 다름)
--      2) NULL 아니다: IS NOT NULL
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
    FROM EMPLOYEE
   WHERE GENDER IS NULL;

-- 8. 사원 테이블에서 김 씨 조회
--      1) 만능문자(WILD CARD) :
--          (1) % : 모든 문자, 글자 수 제한 X
--          (2) _ : 모든 문자, 한 글자로 제한
--      2) 예시
--          (1) '김'으로 시작하는 이름 찾기 : 김%
--          (2) '김'으로 끝나는 이름 찾기   : %김
--          (3) '김'을 포함하는 이름 찾기   : %김%
--      3) 만능문자 연산자
--          LIKE, NOT LIKE
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE NAME LIKE '김%';


-- 9. 사원 테이블에서 사원번호가 1로 시작하는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE EMP_NO LIKE '1%'; --* 이 경우 오라클이 자동으로 NUMBER타입을 문자타입으로 캐스팅해준다. (나쁜 코드★)
 
 
/*
    ORDER BY절
        ASC  : 오름차순 정렬, 생략가능
        DESC : 내림차순 정렬
*/
-- 10. 사원 테이블에서 사원명의 가나다순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY NAME ASC;

-- 11. 사원 테이블에서 급여가 높은순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY SALARY DESC;
 
-- 12. 사원 테이블에서 성별의 가나다순으로 조회하기
--      오름차순 정렬 : NULL 값은 마지막에 배치
--      내림차순 정렬 : NULL 값은 처음에 배치
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY GENDER DESC;
 
-- 13. 사원 테이블에서 먼저 고용된순으로 조회하기
--      오름차순 정렬 : 먼저 입사한 사람 순으로
--      내림차순 정렬 : 최근 입사한 사람 순으로
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY HIRE_DATE;
 
-- 14. 사원 테이블에서 소속부서의 오름차순 정렬로 조회하되,
--     같은 소속부서 내에서는 먼저 고용된 순으로 조회하기
--          1차 정렬기준 : 소속부서 (DEPART)
--          2차 정렬기준 : 고용일자 (HIRE_DATE)
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY DEPART ASC, HIRE_DATE ASC;

/* WHERE절과 ORDER BY절 함께 사용 */
-- 15. 사원 테이블에서 급여가 5,000,000원 이상인 사원들을 고용된 순으로 조회하기
--      1차 졍렬 : 급여
--      2차 정렬 : 고용일
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 5000000
 ORDER BY HIRE_DATE;
 
 /* SELECT문 처리순서 */
 SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE AS HD, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 5000000
 ORDER BY HD;
 
 SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY AS S
  FROM EMPLOYEE
 WHERE S >= 5000000 --* WHERE절(4)은 SELECT(5) 보다 먼저 처리하기 때문에 별칭으로 작성하면 안 된다.
 ORDER BY HIRE_DATE;