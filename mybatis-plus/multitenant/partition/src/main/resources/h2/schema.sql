DROP TABLE IF EXISTS m_user;

CREATE TABLE m_user
(
    id        BIGINT      NOT NULL COMMENT '主键ID',
    tenant_id VARCHAR(60) NULL DEFAULT NULL COMMENT '租户id',
    name      VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age       INT         NULL DEFAULT NULL COMMENT '年龄',
    email     VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS m_user_info;

CREATE TABLE m_user_info
(
    id        BIGINT      NOT NULL COMMENT '主键ID',
    tenant_id VARCHAR(60) NULL DEFAULT NULL COMMENT '租户id',
    user_id   BIGINT      NULL DEFAULT NULL COMMENT 'user_id',
    phone     VARCHAR(50) NULL DEFAULT NULL COMMENT '手机',
    PRIMARY KEY (id)
);
