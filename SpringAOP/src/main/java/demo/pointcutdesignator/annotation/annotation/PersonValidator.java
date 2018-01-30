package demo.pointcutdesignator.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.PARAMETER,ElementType.METHOD})
public @interface PersonValidator {
	
	public boolean isRun() default true;
}