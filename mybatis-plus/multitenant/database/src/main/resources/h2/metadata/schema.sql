DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant
(
    id                    BIGINT       NOT NULL COMMENT '主键ID',
    tenant_id             varchar(30)  NOT NULL comment '租户id',
    data_source_url       varchar(100) NOT NULL comment '数据源URL',
    data_source_username  varchar(30)  NOT NULL comment '数据源密码',
    data_source_password  varchar(68)  NOT NULL comment '数据源驱动',
    data_source_driver    varchar(50)  NOT NULL comment '数据源密码',
    data_source_pool_name varchar(50)  NOT NULL comment '数据源池名称',
    PRIMARY KEY (id)
);
