package demo.pointcutdesignator.args;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnimalAspect3 {
	// non-arg
	@Pointcut("execution(* demo.pointcutdesignator.arg.Animal3.*())")
	public void createPointCutNoneArg() {

	}

	@Before("createPointCutNoneArg()")
	public void doActionNonArg() {
		System.out.println("Hello Action Non ARG");
	}

	// one arg
	@Pointcut("execution(* demo.pointcutdesignator.arg.Animal3.*(Long))")
	public void createPointCut() {

	}

	@Before("createPointCut()")
	public void doAction() {
		System.out.println("Hello Action");
	}

	// many
	@Pointcut("execution(* demo.pointcutdesignator.arg.Animal3.*(Long,..))")
	public void createPointCutManyArg() {

	}

	@Before("createPointCutManyArg()")
	public void doActionManyArg() {
		System.out.println("Hello Action many arg");
	}

	// And Operator
	@Pointcut("execution(* demo.pointcutdesignator.arg.Animal3.*(..)) && args(Long,..)")
	public void createPointCutAndCondition() {

	}

	@Before("createPointCutAndCondition()")
	public void doActionAndCondition() {
		System.out.println("Hello Action And(&&) Operator");
	}

}
