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
		User user = userMapper.selectById(1);
		Assertions.assertEquals(18, user.getAge());
	}
}
