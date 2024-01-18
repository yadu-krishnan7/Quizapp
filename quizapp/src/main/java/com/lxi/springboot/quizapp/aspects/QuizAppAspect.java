package com.lxi.springboot.quizapp.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class QuizAppAspect {
    
    @Before("* com.lxi.springboot.quizapp.service.AttemptService.*(..)) ||"+
    " * com.lxi.springboot.quizapp.service.UserService.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint){
         
        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());

        log.info("Method before execution: {} with arguments: {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
}
