package org.example.partition;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

	@Select("select * from m_user t1 left join m_user_info t2 on t1.Id = t2.user_id where t2.phone = #{phone}")
	User selectByPhone(String phone);
}
