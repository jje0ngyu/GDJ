/*
    뷰
    
    1. VIEW
    2. 가상 테이블
    3. 디스크에 저장된 테이블은 아니다. (쿼리만 저장된 상태)
    4. 자주 사용하는 복잡한 쿼리가 있다면 뷰로 저장해 둔다.
    5. 저장된 뷰는 테이블처럼 SELECT문을 활용하면 된다.
    6. 뷰로 인한 성능상 이점 : X
    7. 보안상 이점이 있다.
    8. 뷰 생성
       CREATE VIEW 뷰_이름 AS (쿼리문)
*/

-- 1. 뷰 생성
CREATE VIEW VIEW_EMP
    AS (SELECT E.EMP_NO, E.NAME, E.DEPART, D.DEPT_NAME, E.GENDER, E.POSITION, E.HIRE_DATE, E.SALARY
          FROM DEPARTMENT D INNER JOIN EMPLOYEE E
            ON D.DEPT_NO = E.DEPART);
            
-- 2. 뷰 확인
SELECT * FROM VIEW_EMP;

-- 3. 뷰 삭제
DROP VIEW VIEW_EMP;

-- 사용자가 작성한 VIEW 확인하려면 USER_VIEWS 데이터 사전을 확인
DESC USER_VIEWS;
SELECT VIEW_NAME  -- 뷰 이름
     , TEXT       -- 저장된 쿼리문
  FROM USER_VIEWS;