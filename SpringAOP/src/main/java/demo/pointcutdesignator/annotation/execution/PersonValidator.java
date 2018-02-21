package demo.pointcutdesignator.annotation.execution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.PARAMETER,ElementType.METHOD})
public @interface PersonValidator {
	
	public boolean isRun() default true;
	
	public static final String ANNOTATION_TYPE = Integer.class.toString();
	public static final String ANNOTATION_PRIMITIVE_TYPE = "int";
}
