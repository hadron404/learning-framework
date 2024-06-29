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

		// 返回 true 表示不走租户逻辑
		@Override
		public boolean ignoreTable(String tableName) {
			if (Objects.nonNull(MybatisTenantContext.get())) {
				return MybatisTenantContext.get();
			}
			//默认租户隔离
			return false;
		}
	}
	public static class MybatisTenantContext {
		private static final ThreadLocal<Boolean> TENANT_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

		public static Boolean get() {
			return TENANT_CONTEXT_THREAD_LOCAL.get();
		}

		public static void set(boolean isIgnore) {
			TENANT_CONTEXT_THREAD_LOCAL.set(isIgnore);
		}

		public static void clear() {
			TENANT_CONTEXT_THREAD_LOCAL.remove();
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
