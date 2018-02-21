package demo.pointcutdesignator.annotation.execution;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

// tham khảo cách lấy tham số http://tutorials.jenkov.com/java-reflection/annotations.html
// tham khảo pointcut expression: http://www.eclipse.org/aspectj/doc/released/progguide/language-joinPoints.html
// https://stackoverflow.com/questions/2781771/how-can-i-validate-two-or-more-fields-in-combination
// https://lmonkiewicz.com/programming/get-noticed-2017/spring-boot-rest-request-validation/
@Aspect
public class PersonAspect {
	
	@Pointcut("execution(public * *(..))")
	public void createPointCut() {
	}

	// tham khảo:
	// https://stackoverflow.com/questions/29681675/how-to-write-an-aspect-pointcut-based-on-an-annotated-parameter
	@Before("execution(public * *(.., @PersonValidator (*), ..))")
	public void doAction(JoinPoint joinPoint) throws Exception {
		System.out.println(joinPoint);
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
		}
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName();
		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
		Annotation[][] parameterAnnotations = joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes)
				.getParameterAnnotations();
		int i = 0;
		int j = 0;
		Parameter[] parameter = signature.getMethod().getParameters();
		System.out.println("========================NAME================================");
		System.out.println(parameterTypes);
		for (Parameter parameter2 : parameter) {
			PersonValidator annotation = parameter2.getAnnotation(PersonValidator.class);
			if (annotation != null) {
				System.out.println(parameter2 + " " + args[j]);
				if (parameterTypes[j].equals(String.class)) {
					System.out.println("equal");
				}
				// check valid type for annotation 
				System.out.println(parameterTypes[j]);
				if(!parameterTypes[j].toString().equals(annotation.ANNOTATION_TYPE) && !parameterTypes[j].toString().equals(annotation.ANNOTATION_PRIMITIVE_TYPE)){
					System.out.println("Not equal");
				}
				/*if (args[j] == null) {
					throw new NullPointerException(parameterTypes[j] + " must be not null");
				}*/
			}
			j++;
		}

		System.out.println("========================================================");
		for (Annotation[] annotations : parameterAnnotations) {
			for (Annotation annotation : annotations) {
				if (annotation.annotationType() == PersonValidator.class) {
					PersonValidator pAnnotation = (PersonValidator) annotation;
					System.out.println(pAnnotation.isRun());
					System.out.println(pAnnotation.ANNOTATION_TYPE);
					System.out.println(parameterTypes[i]);
				}
			}
			i++;
		}
		System.out.println("=========================================================");
		System.out.println();
		System.out.println("=======================END==================================");

	}

	// Chỉ hoạt động khi method có duy nhất 1 tham số và tham số đó được mark
	// with annotation
	// (in annotation-style syntax this time because in Spring AOP you cannot
	// use native AspectJ syntax
	@Before("execution(* *(@PersonValidator (*)))")
	public void advice(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
		}
	}
	
}
