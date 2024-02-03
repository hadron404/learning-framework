DELETE
FROM m_user;

INSERT INTO m_user (id, tenant_id, name, age, email)
VALUES (1, '123', 'Jone', 18, 'test1@baomidou.com'),
       (2, '1323', 'Jack', 20, 'test2@baomidou.com'),
       (3, '1323', 'Tom', 28, 'test3@baomidou.com'),
       (4, '123', 'Sandy', 21, 'test4@baomidou.com'),
       (5, '1323', 'Billie', 24, 'test5@baomidou.com');
