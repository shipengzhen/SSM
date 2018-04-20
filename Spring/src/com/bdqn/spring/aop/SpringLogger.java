package com.bdqn.spring.aop;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class SpringLogger {
	
	private static final Logger log = Logger.getLogger(SpringLogger.class);

	//前置增强
	public void before(JoinPoint jp) {
	    log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参:"+Arrays.toString(jp.getArgs()));
	}
	
	//后置增强
	public void afterReturning(JoinPoint jp, Object result) {
	    log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法返回值:" + result);
	}

	//增强异常
	public void afterThrowing(JoinPoint jp,RuntimeException e){
		log.error(jp.getSignature().getName()+"方法发生异常:"+e);
	}
	
	//最终增强
	public void afterLogger(JoinPoint jp){
		log.info(jp.getSignature().getName()+"方法结束执行。");
	}
	
	//环绕增强
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		//前
		log.info("调用 "+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参:"+Arrays.toString(jp.getArgs()));
		Object result=null;
		try {
			//后
			result = jp.proceed();//执行目标方法并获取返回值
			log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法返回值:"+result);
		} catch (Throwable e) {
			//异常
			log.error(jp.getSignature().getName()+"方法发生异常:"+e);
		} finally {
			//最终
            log.info(jp.getSignature().getName()+"方法结束执行。");
        }
		return result;
	}
}