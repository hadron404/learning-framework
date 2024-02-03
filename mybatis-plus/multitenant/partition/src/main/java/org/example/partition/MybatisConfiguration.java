package org.example.partition;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor result = new MybatisPlusInterceptor();
		result.addInnerInterceptor(new TenantLineInnerInterceptor(new MyTenantLineHandler()));
		return result;
	}

	static class MyTenantLineHandler implements TenantLineHandler {
		@Override
		public Expression getTenantId() {
			return new StringValue(TenantContext.getCurrentTenant());
		}

		@Override
		public String getTenantIdColumn() {
			// 这里对应的是数据库的列名
			return "tenant_id";
		}

		@Override
		public boolean ignoreTable(String tableName) {
			// 如果那些表不需要做租户隔离的，在这里配置
			return false;
		}
	}

	static class TenantContext {
		private static final String tenantId = null;

		private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

		public static String getCurrentTenant() {
			return currentTenant.get();
		}

		public static void setCurrentTenant(String tenantId) {
			currentTenant.set(tenantId);
		}

		public static void clear() {
			currentTenant.remove();
		}
	}

}
