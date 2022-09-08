DROP TABLE CONTACT;
CREATE TABLE CONTACT(
	CONTACT_NO NUMBER 		       NOT NULL,
	NAME 	   VARCHAR2 (20 BYTE)  NOT NULL,
	TEL		   VARCHAR2 (15 BYTE)  NULL,
	EMAIL	   VARCHAR2 (100 BYTE) NULL,
	REG_DATE   DATE 			   NOT NULL
);

ALTER TABLE CONTACT
	ADD CONSTRAINT PK_CONTACT PRIMARY KEY (CONTACT_NO);

DROP SEQUENCE CONTACT_SEQ;
CREATE SEQUENCE CONTACT_SEQ
	NOCACHE
	NOORDER;

SELECT CONTACT_NO, NAME, TEL, EMAIL, REG_DATE FROM CONTACT;