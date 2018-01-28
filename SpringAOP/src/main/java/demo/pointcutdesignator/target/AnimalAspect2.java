package demo.pointcutdesignator.target;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnimalAspect2 {
	
	@Pointcut("target(demo.pointcutdesignator.target.Animal2)")
	public void createPointCut() {
		
	}
	
	@Before("createPointCut()")
	public void doAction () {
		System.out.println("Hello Action");
	}
}
