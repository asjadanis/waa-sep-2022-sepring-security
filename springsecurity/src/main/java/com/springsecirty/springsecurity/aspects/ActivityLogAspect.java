package com.springaop.assignment4.aspects;

import com.springaop.assignment4.models.ActivityLog;
import com.springaop.assignment4.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {

    private final HttpServletRequest httpServletRequest;
    private final ActivityLogRepository repo;

    @Pointcut("@annotation(com.springaop.assignment4.aspects.ExecutionTime)")
    public void execTimeAnnotation(){
    }

    @Around("execTimeAnnotation()")
    public Object calculateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - start;
        Date date = new Date();

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(date);
        activityLog.setDuration(duration);
        activityLog.setOperation(joinPoint.toShortString());

        repo.save(activityLog);

        return result;
    }

    @Pointcut("execution(* com.springaop.assignment4.service.*.*(..))")
    public void executionPointCut(){

    }

    @Before("executionPointCut()")
    public void serviceGuardForPostMethods(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        if(httpServletRequest.getMethod().equals("POST")){
            if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
                throw new AopIsAwesomeHeaderException("required AOP-IS-AWESOME header missing");
            }
        }
    }
}