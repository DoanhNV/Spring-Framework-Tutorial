package demo.pointcutdesignator.annotation.execution;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

// tham khảo cách lấy tham số http://tutorials.jenkov.com/java-reflection/annotations.html
@Aspect
public class PersonAspect {
	
	@Pointcut("execution(public * *(..))")
	public void createPointCut () {}
	
	// tham khảo: https://stackoverflow.com/questions/29681675/how-to-write-an-aspect-pointcut-based-on-an-annotated-parameter
	@Before("execution(public * *(.., @PersonValidator (*), ..))")
	public void doAction (JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {
		System.out.println(joinPoint);
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
		}
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName();
		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
		Annotation[][] parameterAnnotations = joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getParameterAnnotations();
		int i = 0;
		Parameter[] parameter = signature.getMethod().getParameters();
		for (Parameter parameter2 : parameter) {
		}
		
		for (Annotation[] annotations : parameterAnnotations) {
			for (Annotation annotation : annotations) {
				if(annotation.annotationType() == PersonValidator.class) {
					System.out.println(i + " - " + annotation + " - " + args[i].getClass());
					System.out.println(parameterTypes[i]);
				}
			}
			i++;
		}
	}
	
	// Chỉ hoạt động khi method có duy nhất 1 tham số và tham số đó được mark with annotation
	// (in annotation-style syntax this time because in Spring AOP you cannot use native AspectJ syntax
	@Before("execution(* *(@PersonValidator (*)))")
    public void advice(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
		}
    }
}
