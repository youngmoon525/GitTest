--���� , ���� , ����
--DCL ( DATA CONTROL Language ) - ���� (GRANT (���Ѻο�), REVOKE ( ���ѻ���) <- ���� x
--DML ( DATA MANIPULATION lANGUAGE ) - ���� INSERT , UPDATE , DELETE ( SELECT )
--CRUD ( WEB���� �⺻ 4���� ������ ��� CRUD��� ǥ���� �Ѵ� )
--DDL ( Data Definition Language) -���� CREATE , ALTER ,DROP (���̺��� �����ϰ� , �����ϰ� , ���� )

-- JAVA (JDBC)-> (SQL)DBMS ->DB(Exceló�� ���常 �ϴ� â��)

SELECT 1 FROM DUAL;
-- KEY �����ͺ��̽��� ����ȭ ������ ��ġ�µ� �� �� �����͸� �ϳ��� ���� �Ǵ� �����ϰ� �Ҽ��ְ����ִ�
-- �ĺ��� ( ������� ġ�� �� �ĺ��� : �ֹε�Ϲ�ȣ , �� �ĺ��� : �θ���� �ֹε�Ϲ�ȣ )
-- NUMBER(int) , VARCHAR2(String) , NVARCHAR2(String)
CREATE TABLE KYM ( -- String col1 , col4 ; int col2 ;
    COL1 VARCHAR2(1000),
    COL2 NUMBER, 
    COL3 VARCHAR2(1000),
    COL4 VARCHAR2(1000),
    COL5 VARCHAR2(1000)
);
--DROP TABLE KYM;


INSERT INTO KYM (COL1, COL2, COL3, COL4, COL5) VALUES ('��ȣ��1', '1', '1000', 'D', 'E');
INSERT INTO KYM (COL1, COL2, COL3, COL4, COL5) VALUES ('��ȣ��2', '1', '10000', 'D', 'E');
INSERT INTO KYM (COL1, COL2, COL3, COL4, COL5) VALUES ('��ȣ��2', '1', '10000', 'D', 'E');

COMMIT;
-- ��� �۾��� ��� �͵��� �ǵ�����. ( ROLLBACK ) ; ROLLBACK �Ǵ� COMMIT�� �Ҷ��� �����ϰ� �Ѵ�.
-- ��� �۾��� ���� Ȯ�� ( COMMIT ) ;
--Ʈ����� : ��� �۾��� �ּ��� ���� : DBMS�� �۾��� �س��� Ȯ���Ҳ����� ��ٸ��»���.
SELECT * FROM KYM;

ROLLBACK;

UPDATE KYM SET COL1 = '��ȣ��ٲ�' WHERE COL3='10000';

DELETE FROM KYM;

--DATA TYPE :  NUMBER (int) , VARCHAR2 (String) 
-- CREATE TABLE ���̺��̸� (      
-- �÷��̸� ������Ÿ��(ũ��) ,<- �÷��� ��������� �޸��� �������� �÷� �̸� ������Ÿ�Ժκ��� �ݺ�
--);

ROLLBACK;
DROP TABLE KYM;
CREATE TABLE KOREA_PEOPLE (
    JUMIN_NUM NUMBER PRIMARY KEY, --�ߺ��Ǹ� �ȵǴ� ������(key,�ĺ���)�� �ǹ���.
    NAME VARCHAR2(20),
    GENDER NUMBER 
);


SELECT * FROM korea_people;

COMMIT;
-- ��ȣ�� : �ҳ��� , �ָ޴� :��� , �ּ�: ~~~~ , ����:11 
--���� ���������� ���п��� ������ �����͸� ���� DB�� ������ �ϰ�ʹٸ� ��� �ؾ��ұ�?
--�ش� ������ ������ ���̺��� ����� , INSERT���� �̿��ؼ� �����͸� �־��(2��)
--��ȸ



