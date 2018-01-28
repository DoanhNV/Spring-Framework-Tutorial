package demo.pointcutdesignator.within;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnimalAspect {
	
	// math all type in demo.pointcutdesignator package
	// within(demo.pointcutdesignator..*)
	
	// => within not apply for class that extend parent
	
	@Pointcut("within(demo.pointcutdesignator.within.Person)")
	public void createPointCut () {}
	
	@Before("createPointCut()")
	public void doAction () {
		System.out.println("Hello Action!");
	}
	
}
