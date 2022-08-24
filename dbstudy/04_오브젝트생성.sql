-- 테이블 삭제
DROP TABLE PROCEEDING;
DROP TABLE EMPLOYEE;
DROP TABLE PJT;
DROP TABLE DEPARTMENT;

-- 부서 테이블 생성
CREATE TABLE DEPARTMENT (
    DEPT_NO       VARCHAR2(15 BYTE) NOT NULL,
    DEPT_NAME     VARCHAR2(30 BYTE) NULL,
    DEPT_LOCATION VARCHAR2(50 BYTE) NULL
);
-- 프로젝트 테이블 생성
CREATE TABLE PJT (
    PJT_NO      NUMBER            NOT NULL,
    PJT_NAME    VARCHAR2(30 BYTE) NULL,
    BEGIN_DATE  DATE              NULL,
    END_DATE    DATE              NULL
);
-- 사원 테이블 생성
CREATE TABLE EMPLOYEE (
    EMP_NO     NUMBER            NOT NULL,
    DEPT_NO    VARCHAR2(15 BYTE) NOT NULL,
    POSITION   CHAR(10 BYTE)     NULL,
    NAME       VARCHAR2(15 BYTE) NULL,
    HIRE_DATE  DATE              NULL,
    SALARY     NUMBER            NULL
);
-- 프로젝트진행 테이블 생성
CREATE TABLE PROCEEDING (
    PCD_NO  NUMBER NOT NULL,
    EMP_NO  NUMBER NOT NULL,
    PJT_NO  NUMBER NOT NULL
);
-- 기본키 추가
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE PJT
    ADD CONSTRAINT PK_PJT PRIMARY KEY(PJT_NO);
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);
ALTER TABLE PROCEEDING
    ADD CONSTRAINT PK_PROCEEDING PRIMARY KEY(PCD_NO);

-- 외래키 추가
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPT_NO)
        REFERENCES DEPARTMENT(DEPT_NO);
ALTER TABLE PROCEEDING
    ADD CONSTRAINT FK_PROCEEDING_PJT FOREIGN KEY(PJT_NO)
        REFERENCES PJT(PJT_NO);
ALTER TABLE PROCEEDING
    ADD CONSTRAINT FK_PROCEEDING_EMPLOYEE FOREIGN KEY(EMP_NO)
        REFERENCES EMPLOYEE(EMP_NO);


-- 외래키 제거
-- DEPARTMENT 테이블의 DEPT_NO 칼럼을 참조하는 외래키 제약조건을 제거해야
-- DEPARTMENT 테이블의 DEPT_NO 칼럼에 추가된 기본키 제약조건을 제거할 수 있음
ALTER TABLE EMPLOYEE
    DROP CONSTRAINT FK_EMPLOYEE_DEPARTMENT;

-- 기본키 제거
-- FK에 의해서 참조되고 있는 PK는 제거할 수 없음
-- 먼저 FK를 제거해야 함
ALTER TABLE DEPARTMENT
    DROP CONSTRAINT PK_DEPARTMENT;  -- EMPLOYEE의 FK를 먼저 제거해야 실행할 수 있음
-- ALTER TABLE DEPARTMENT
--     DROP PRIMARY KEY;