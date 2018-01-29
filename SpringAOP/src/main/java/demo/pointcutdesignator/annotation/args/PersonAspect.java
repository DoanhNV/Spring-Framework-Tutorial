package demo.pointcutdesignator.annotation.args;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonAspect {
	
	@Pointcut("@args(demo.pointcutdesignator.annotation.args.PersonValidator)")
	public void createPointCut () {}
	
	@Before("createPointCut()")
	public void doAction (JoinPoint joinPoint) {
		System.out.println("joinpoint: " + joinPoint.getArgs());
	}
	
}
