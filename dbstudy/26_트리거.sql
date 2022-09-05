/*
    트리거
    
    1. Trigger
    2. DML( INSERT, UPDAT, DELETE) 수행 후 트리거가 자동으로 수행된다.
    3. DML 직전에 수행되는 BEFORE 트리거, 직후에 수행되는 AFTER 트리거가 있다.
    4. 기본적으로 작업 수행되는 행(ROW) 단위로 트리거가 적용된다.
    5. 형식
        CREATE [OR REPLACE] TRIGGER 트리거_이름
        [ALTER | BEFORE]
        [INSERT OR UPDATE OR DELETE]
        [ON 테이블_이름]
        [FOR EACH ROW]
        BEGIN
            트리거 작업
        END [트리거_이름];
*/

