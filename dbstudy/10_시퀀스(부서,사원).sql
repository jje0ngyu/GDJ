-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER            NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER            NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER            NULL,
    POSITION  VARCHAR2(20 BYTE) NULL,
    GENDER    CHAR(2)           NULL,
    HIRE_DATE DATE              NULL, 
    SALARY    NUMBER            NULL
);

-- 기본키
ALTER TABLE DEPARTMENT 
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;

/*************************************************************/

/*
    시퀀스 :
    
    1. SEQUENCE
    2. 일련번호를 생성하는 데이터베이스 객체
    3. 자동으로 증가하는 번호 생성
    4. (인공키로) 기본키(PK)에서 주로 사용
    5. NEXTVAL를 이용하면 새로운 번호가 생성
    6. CURRVAL (CURRENT VALUE) 현재 번호를 확인
    
*/

/*
    시퀀스 생성 형식 : 
    
    CREATE SEQUENCE 시퀀스_이름
        START WITH 시작값              -- 생략하면 1, 생성 이후 수정 불가
        INCREMENT BY 증가값            -- 생략하면 1,
        MINVALUE 최솟값
        MAXVALUE 최댓값
        CACHE 사용유무                 -- NOCACHE 권장
        CYCLE 사용유무                 -- PK에서는 NOCYCLE (생략하면 NOCYCLE)
        (* 위 순서는 차례에 상관없다.)
*/
-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
     START WITH 1
     INCREMENT BY 1
     MINVALUE 1
     MAXVALUE 100
     NOCACHE
     NOCYCLE;


-- 부서 테이블에 행(Row) 삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');   --DEPARTMENT_SEQ.NEXTVAL : 1
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');   --DEPARTMENT_SEQ.NEXTVAL : 2
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');   --DEPARTMENT_SEQ.NEXTVAL : 3 
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');   --DEPARTMENT_SEQ.NEXTVAL : 4

-- 작업의 완료
COMMIT;


-- 사원 테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;


-- 사원 테이블에 행(Row) 삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원(소속부서)
-- PK             - FK
-- 1,2,3,4        - 1,2,3,4중 하나만 가능
INSERT INTO 
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000); --EMPLOYEE_SEQ.NEXTVAL:1001
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000); --EMPLOYEE_SEQ.NEXTVAL:1002
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000); --EMPLOYEE_SEQ.NEXTVAL:1003
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000); --EMPLOYEE_SEQ.NEXTVAL: 1004

--오류가 발생하는 INSERT
--INSERT를 실패하였으나, SEQUENCE의 번호는 사용 (EMPLOYEE_SEQ.NEXTVAL: 1005)
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '신현준', 5, '대리', 'M', '98-12-01', 3500000);
--정상 데이터 다시 INSERT
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '신현준', 3, '대리', 'M', '98-12-01', 3500000); --EMPLOYEE_SEQ.NEXTVAL: 1006
COMMIT;