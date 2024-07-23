CREATE TABLE CUSTOMER (
                          ID NUMBER(12) PRIMARY KEY,
                          CUSTOMER_NAME VARCHAR2(40) NOT NULL ,
                          CUSTOMER_NATIONAL VARCHAR2(40)  ,
                          ACC_NO VARCHAR2(40)

);

CREATE TABLE CUSTOMER_CHECK (
                                ID NUMBER(12) PRIMARY KEY,
                                AMOUNT NUMERIC(10,2) NOT NULL,
                                CHECK_DATE DATE,
                                CUSTOMER_ID NUMBER(12)
);
ALTER TABLE CUSTOMER_CHECK
    ADD CONSTRAINT fk_customer
        FOREIGN KEY (CUSTOMER_ID)
            REFERENCES CUSTOMER (ID);



