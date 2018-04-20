package com.bdqn.spring.aop;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用注解定义切面
 */
@Aspect
public class SpringLogger {
	
	private static final Logger log = Logger.getLogger(SpringLogger.class);

	@Pointcut("execution(* com ..*.*(..))")
	public void pointcut() {}
	
	//前置增强
	@Before("pointcut()")
	public void before(JoinPoint jp) {
	    log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参:"+Arrays.toString(jp.getArgs()));
	}
	
	//后置增强
	@AfterReturning(pointcut="pointcut()", returning ="result")
	public void afterReturning(JoinPoint jp, Object result) {
	    log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法返回值:"+result);
	}

	//增强异常
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowing(JoinPoint jp,RuntimeException e){
		log.error(jp.getSignature().getName()+"方法发生异常:"+e);
	}
	
	//最终增强
	@After("pointcut()")
	public void afterLogger(JoinPoint jp){
		log.info(jp.getSignature().getName()+"方法结束执行。");
	}
	
	//环绕增强
	@Around("pointcut()")
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参:"+Arrays.toString(jp.getArgs()));
		try {
			Object result = jp.proceed();
			log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法返回值:"+result);
			return result;
		} catch (Throwable e) {
			log.error(jp.getSignature().getName()+"方法发生异常:"+e);
			throw e;
		} finally {
            log.info(jp.getSignature().getName()+"方法结束执行。");
        }
	}
}