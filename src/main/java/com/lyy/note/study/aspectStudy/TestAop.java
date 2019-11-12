package com.lyy.note.study.aspectStudy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP拦截
 */

@Component
@Aspect //使用@Aspect注解声明一个切面
public class TestAop {
	
	//第一个*代表返回类型不限，第二个*表示所有类，第三个*表示所有方法，..两个点表示方法里的参数不限。 public * com.lyy.note.study.aspectStudy.*.*(..))
    private final String POINT_CUT = "execution(public * com.lyy.note.study.aspectStudy.TestService.*(..))";
	
	
	@Around(value = POINT_CUT)
	public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("#################aop:" + proceedingJoinPoint.getSignature().getName());
	    //获取传入参数的值
		String param="";
		Object[] args = proceedingJoinPoint.getArgs();
		if(args.length>0) {
			param=(String) args[0];
			System.out.println("###############origin param:"+param);
		}
		String proceed;
//		try {
//			proceed = (String)proceedingJoinPoint.proceed();
//			String replace = proceed.replace(param, "changed");
//			System.out.println("###############origin param changed:--->"+replace);
//			return replace;
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		param = "哈哈";
		System.out.println("###############origin changed:"+param);
		return param;
	}
	
}
