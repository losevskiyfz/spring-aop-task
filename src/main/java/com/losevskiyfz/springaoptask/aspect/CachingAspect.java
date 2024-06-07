package com.losevskiyfz.springaoptask.aspect;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CachingAspect {

    private final Map<MethodSignature,Object> cache = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @AllArgsConstructor
    @EqualsAndHashCode
    private static class MethodSignature{
        private Object[] args;
        private String methodName;
    }

    @Around("@annotation(com.losevskiyfz.springaoptask.aspect.Cacheable)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        MethodSignature methodSignature = new MethodSignature(args, methodName);

        if (cache.containsKey(methodSignature)) {
            logger.info("GET OBJECT FROM CACHE");
            return cache.get(methodSignature);
        }

        Object result = joinPoint.proceed();

        cache.put(methodSignature, result);
        logger.info("GET OBJECT FROM DATASOURCE");
        return result;
    }

}
