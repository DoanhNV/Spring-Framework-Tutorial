package demo.pointcutdesignator.annotation.annotation;

public class Person  {
	
	public void say(@PersonValidator Pencil pencil, String userName) {
		System.out.println("Hello I'am person!");
	}
}
