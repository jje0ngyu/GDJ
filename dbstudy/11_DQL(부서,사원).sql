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