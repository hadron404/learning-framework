DELETE
FROM tenant;
INSERT INTO tenant (id, tenant_id,
                    data_source_url, data_source_username, data_source_password,
                    data_source_driver, data_source_pool_name)
VALUES (1, 'tenant_a', 'jdbc:h2:mem:test', 'root', 'test', 'org.h2.Driver', 'default'),
       (2, 'tenant_b', 'jdbc:mysql://127.0.0.1:3306', 'root', 'root', 'com.mysql.cj.jdbc.Driver', 'default'),
       (3, 'tenant_c', 'jdbc:mysql://127.0.0.1:3307', 'root', 'root', 'com.mysql.cj.jdbc.Driver', 'default');
