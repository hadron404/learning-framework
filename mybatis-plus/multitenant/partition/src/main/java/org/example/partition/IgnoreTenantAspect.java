package com.xjjk.promotionengine.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

@Aspect
@Slf4j
@Component
@Order(Integer.MIN_VALUE)
public class IgnoreTenantAspect {

    /**
     * 切入点
     */
    @Pointcut("@within(com.xxx.IgnoreTenant) ||@annotation(com.xxx.IgnoreTenant)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            Class<?> targetClass = point.getTarget().getClass();
            IgnoreTenant classIgnoreTenant = targetClass.getAnnotation(IgnoreTenant.class);
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            IgnoreTenant methodIgnoreTenant = method.getAnnotation(IgnoreTenant.class);
            boolean isClassAnnotated = AnnotationUtils.isAnnotationDeclaredLocally(IgnoreTenant.class, targetClass);
            boolean isMethodAnnotated = Objects.nonNull(methodIgnoreTenant);
            if (isClassAnnotated) {
                MybatisPlusSaasConfig.MybatisTenantContext.set(classIgnoreTenant.isIgnore());
            }
            if (isMethodAnnotated) {
                MybatisPlusSaasConfig.MybatisTenantContext.set(methodIgnoreTenant.isIgnore());
            }
            return point.proceed();
        } finally {
            MybatisPlusSaasConfig.MybatisTenantContext.clear();
        }
    }
}

