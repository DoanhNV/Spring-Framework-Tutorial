package demo.pointcutdesignator.annotation.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonAspect {
	
	@Pointcut("execution(public * *(..)) && @args(PersonValidator)")
	public void createPointCut () {}
	
	@Before("createPointCut()")
	public void doAction (JoinPoint joinPoint, PersonValidator validator) {
		System.out.println("sdfsdf");
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			/*Pencil pencil = (Pencil) object;
			pencil.sayHello();*/
			System.out.println(object);
		}
	}
	
	@Before("execution(* *(@PersonValidator (*)))")
    public void advice(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
		}
    }
}
