package demo.pointcutdesignator.this_;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnimalAspect {
	
	@Pointcut("this(demo.pointcutdesignator.this_.Animal)")
	public void createPointCut() {
		
	}
	
	@Before("createPointCut()")
	public void doAction () {
		System.out.println("Hello Action");
	}
}
