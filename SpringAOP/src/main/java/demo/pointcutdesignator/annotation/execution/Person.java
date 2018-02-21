package demo.pointcutdesignator.annotation.execution;

public class Person  {
	
	public void say(@PersonValidator Pencil pencil,@PersonValidator String name,@PersonValidator(isRun = false) int age,String address) {
		System.out.println("Hello I'am person! Hello " + name + " age " + age);
	}
}
