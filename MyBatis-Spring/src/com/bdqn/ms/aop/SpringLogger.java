package com.bdqn.ms.aop;

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
 * ʹ��ע�ⶨ������
 */
@Aspect
public class SpringLogger {
	private static final Logger log = Logger.getLogger(SpringLogger.class);

	@Pointcut("execution(* com ..*.*(..))")
	public void pointcut() {}
	
	//ǰ����ǿ
	@Before("pointcut()")
	public void before(JoinPoint jp) {
	    log.info("���� "+jp.getTarget()+"��"+jp.getSignature().getName()+"�������������:"+Arrays.toString(jp.getArgs()));
	}
	
	//������ǿ
	@AfterReturning(pointcut="pointcut()", returning ="result")
	public void afterReturning(JoinPoint jp, Object result) {
	    log.info("���� "+jp.getTarget()+"��"+jp.getSignature().getName()+"��������������ֵ:"+result);
	}

	//��ǿ�쳣
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowing(JoinPoint jp,RuntimeException e){
		log.error(jp.getSignature().getName()+"���������쳣:"+e);
	}
	
	//������ǿ
	@After("pointcut()")
	public void afterLogger(JoinPoint jp){
		log.info(jp.getSignature().getName()+"��������ִ�С�");
	}
	
	//������ǿ
	@Around("pointcut()")
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		log.info("���� "+jp.getTarget()+"��"+jp.getSignature().getName()+"�������������:"+Arrays.toString(jp.getArgs()));
		try {
			Object result = jp.proceed();
			log.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()+"��������������ֵ:"+result);
			return result;
		} catch (Throwable e) {
			log.error(jp.getSignature().getName()+"���������쳣:"+e);
			throw e;
		} finally {
            log.info(jp.getSignature().getName()+"��������ִ�С�");
        }
	}
}