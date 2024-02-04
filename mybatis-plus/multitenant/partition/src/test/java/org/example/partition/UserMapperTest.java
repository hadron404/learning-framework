package org.example.partition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;


	@Test
	void name() {
		MybatisConfiguration.TenantContext.setCurrentTenant("123");
		User user = userMapper.selectById(1);
		Assertions.assertEquals(18, user.getAge());
	}

	/**
	 *
	 * SELECT *
	 * FROM m_user t1
	 * LEFT JOIN m_user_info t2 ON t1.Id = t2.user_id AND t2.tenant_id = '123'
	 * WHERE t2.phone = ? AND t1.tenant_id = '123'
	 * */
	@Test
	void name2() {
		MybatisConfiguration.TenantContext.setCurrentTenant("123");
		User user = userMapper.selectByPhone("1");
	}
}
