package com.losevskiyfz.springaoptask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.losevskiyfz.springaoptask..*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("{} is being invoked.", joinPoint.getSignature().getName());
    }

}
