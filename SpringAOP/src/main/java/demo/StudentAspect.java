package demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StudentAspect {
	
	// Pointcut expression
	public static final String ADVICE_PATTERN = "execution (* demo.*.showName(..))";
	public static final String GET_ADVICE_PATTERN = "execution (* demo.*.get*(..))";
	
	@Pointcut(ADVICE_PATTERN)
	public void advicePointcut() {
		
	}
	
	@Pointcut(GET_ADVICE_PATTERN)
	public void createGetPointCut() {
		
	}
	
	/**
	 * 1.Beafore Advice
	 */
	
	@Before(ADVICE_PATTERN)
	public void doBeforeAction() {
		System.out.println("I will say my name");
	}
	
	/**
	 * 2.After Advice
	 */
	
	@After(ADVICE_PATTERN)
	public void doAfterAdvice() {
		System.out.println("Thank you!");
	}
	
	@AfterReturning(value = "createGetPointCut()", returning = "student")
	public void doAfterReturn(Object student) {
		System.out.println("return entity: " + student);
	}
	
	@AfterThrowing(value = "execution (* demo.*.testThrow(..))", throwing = "e")
	public void doAfterThrow(Exception  e) {
		System.out.println("print ex");
		e.printStackTrace();
	}
	
	/**
	 * 3.Around advice
	 */
	@Around("execution (* demo.*.testAround(..))")
	public void doAround(ProceedingJoinPoint pJoinPoint) {
		System.out.println("Begin around JoinPoint");
		try {
			pJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("Hello! I'm exception from joinpoint");
		}
		System.out.println("After Around JoinPoint");		
	}
	
	
}
