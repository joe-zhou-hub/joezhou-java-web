CREATE SCHEMA SERVLET DEFAULT CHARSET UTF8MB4;

USE SERVLET;

DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT
(
    ID       INT AUTO_INCREMENT COMMENT '主键',
    USERNAME VARCHAR(50) NOT NULL COMMENT '账号' UNIQUE,
    PASSWORD VARCHAR(50) NULL COMMENT '密码',
    PRIMARY KEY (ID)
)
    COMMENT '账号表';

INSERT INTO ACCOUNT (USERNAME, PASSWORD)
VALUES ('admin', ''),
       ('zhaosi', '123'),
       ('liuneng', '456');
COMMIT;