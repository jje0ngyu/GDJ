-- 함수 확인용 기초데이터
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NAME VARCHAR2(20 BYTE),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MATH NUMBER(3)
);

INSERT INTO SAMPLE (NAME, KOR, ENG, MATH) VALUES (NULL,100, 100, 100);
INSERT INTO SAMPLE (NAME, KOR, ENG, MATH) VALUES ('영숙', NULL, 100, 100);
INSERT INTO SAMPLE (NAME, KOR, ENG, MATH) VALUES ('정수', 100, NULL, 100);
INSERT INTO SAMPLE (NAME, KOR, ENG, MATH) VALUES ('지영', 100, 100, NULL);
COMMIT;

-- NULL값의 연산에서 사용되면 결과가 NULL이다.
SELECT 1 + NULL FROM DUAL;

-- NULL처리 함수

-- 1. NVL함수
--    NVL(칼럼1, 칼럼값이 NULL일 때 대신 사용할 값)

-- NAME이 없으면 '아무개', KOR, ENG, MATH가 없으면 0으로 조회
SELECT
      NVL(NAME, '아무개') AS STU_NAME
    , NVL(KOR, 0)
    , NVL(ENG, 0)
    , NVL(MATH, 0)
  FROM
      SAMPLE
 ORDER BY
        STU_NAME ASC;  --* NAME ASC; 일 경우, 만점자의 이름이 NULL 값으로 맨 아래 순위로 내려가기 때문에 조정.
        
-- 연습문제

-- 이름과 총점을 조회하기
-- 이름이 없으면 '아무개', 점수가 없으면 0점 처리
-- 결과
-- 아무개 300점
-- 영숙   200점
-- 정숙   200점
-- 지영   200점

SELECT
      NVL(NAME,'아무개') AS 이름
    , NVL(KOR, 0) + NVL(ENG, 0) + NVL(MATH, 0) AS 총점  --* NULL 값이 존재하기 때문에, KOR + ENG + MATH 로 집계하면 안 된다.
  FROM
      SAMPLE
 ORDER BY
      이름 ASC;
      
-- 2. NVL2 함수
--    NVL2 (칼럼, NULL이 아닐 때 사용한 값, NULL일 때 사용할 값)
SELECT
      NVL2 (NAME, NAME || '님', '아무개') AS 이름 --* NULL이 아닐 때 사용한 값 : NAME : NAME에 들어가 있는 값 그대로 사용
      --* || : 문자열 연결 연산자
    , NVL2 (KOR, '응시', '결시') AS 국어
    , NVL2 (ENG, '응시', '결시') AS 영어
    , NVL2 (MATH, '응시', '결시') AS 수학
  FROM
      SAMPLE;


-- 집계함수 (그룹함수)
-- 1. 통계(합계, 평균, 최대, 최소, 개수 등)
-- 2. NULL값을 연산에서 제외
-- 3. 종류 :
--    1) SUM   (칼럼1) : 칼럼 합계
--    2) AVG   (칼럼1) : 칼럼 평균   (* AVE (X))
--    3) MAX   (칼럼1) : 칼럼 최댓값
--    4) MIN   (칼럼1) : 칼럼 최솟값
--    5) COUNT (칼럼1) : 칼럼에 입력된 데이터의 개수

-- 각 칼럼 (KOR, ENG, MATH)의 합계 ★ (* Row를 연산할 때 사용하지 않도록 한다.)
SELECT
      SUM (KOR)
    , SUM (ENG)
    , SUM (MATH)
--  , SUM (KOR, ENG, MATH) : 인수(arguments)가 3개 이므로 불가능. *집계함수는 인수가 1개여야 한다. *콤마(,)를 사용해 연결 불가능
    , SUM (KOR + ENG + MATH) AS 과목별_합계 -- KOR + ENG + MATH와 같은 연산 (SUM 함수를 잘못 사용한 예시) * SUM은 칼럼 단위 연산! (ROW 단위로 사용 X)
    , SUM (KOR) + SUM(ENG) + SUM(MATH) -- 국어 합 + 영어 합 + 수학 합
  FROM
      SAMPLE;
    
-- 각 칼럼(KOR, ENG, MATH)의 평균
SELECT
      AVG(KOR)  -- NULL 제외한 KOR의 평균
    , AVG(ENG)  -- NULL 제외한 ENG의 평균
    , AVG(MATH) -- NULL 제외한 MATH의 평균
  FROM
      SAMPLE;
-- NULL 값은 결시를 의미하므로 0점 처리함
SELECT
      AVG(NVL(KOR,0))
    , AVG(NVL(ENG,0))
    , AVG(NVL(MATH,0))
FROM SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최댓값 (MAX)
SELECT
      MAX(KOR)
    , MAX(ENG)
    , MAX(MATH)
  FROM
      SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최솟값 (MIN)
-- NULL값은 결시를 의미하므로 0점 처리
SELECT
      MIN(NVL(KOR,0))
    , MIN(NVL(ENG,0))
    , MIN(NVL(MATH,0))
  FROM
      SAMPLE;

-- 국어 시험을 응시한 학생이 몇 명인가? (COUNT)
SELECT
      COUNT(KOR)
  FROM
      SAMPLE;
-- 전체 학생은 몇 명인가? (COUNT) *전체 ROW의 갯수 구하기
-- 특정 칼럼을 지정하지 않고 전체 칼럼(*:에스터리스크)를 이용해서 전체 ROW 갯수를 구한다.
SELECT
      COUNT(*)
    FROM SAMPLE;
    

-- 연습문제 3
-- 성명   국어 영어 수학 합계 평균
-- 아무개 100  100  100  300  100
-- 영숙   0    100  100  200  66.67
-- 정수   100  0    100  200  66.67
-- 지영   100  100  0    200  66.67
SELECT
      NVL(NAME,'아무개') AS 성명
    , NVL(KOR,0) AS 국어
    , NVL(ENG,0) AS 영어
    , NVL(MATH,0) AS 수학
    , NVL(KOR,0) + NVL(ENG,0) + NVL(MATH,0) AS 합계
    , ROUND ((NVL(KOR,0) + NVL(ENG,0) + NVL(MATH,0)) / 3, 2) AS 평균
  FROM
      SAMPLE;
