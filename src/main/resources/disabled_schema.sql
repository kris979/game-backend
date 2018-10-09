ALTER TABLE TEST.CARD_ENTITY
 DROP PRIMARY KEY CASCADE;

DROP TABLE TEST.CARD_ENTITY CASCADE CONSTRAINTS;

CREATE TABLE TEST.CARD_ENTITY
(
  ID          NUMBER(19)                        NOT NULL,
  ATTACK      NUMBER(10),
  CARD_CLASS  VARCHAR2(255 CHAR),
  CARD_TYPE   NUMBER(10),
  COST        NUMBER(10),
  HEALTH      NUMBER(10),
  NAME        VARCHAR2(255 CHAR),
  RACE        VARCHAR2(255 CHAR),
  RARITY      VARCHAR2(255 CHAR)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;


--  There is no statement for index TEST.SYS_C007203.
--  The object is created when the parent object is created.

ALTER TABLE TEST.CARD_ENTITY ADD (
  PRIMARY KEY
  (ID)
  USING INDEX
    TABLESPACE SYSTEM
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
                BUFFER_POOL      DEFAULT
               )
  ENABLE VALIDATE);
