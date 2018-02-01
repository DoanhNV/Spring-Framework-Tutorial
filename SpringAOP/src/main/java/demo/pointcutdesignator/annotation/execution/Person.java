package demo.pointcutdesignator.annotation.execution;

public class Person  {
	
	public void say(@PersonValidator Pencil pencil, String name) {
		System.out.println("Hello I'am person! Hello " + name);
	}
}
