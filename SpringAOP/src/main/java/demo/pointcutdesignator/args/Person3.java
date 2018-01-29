package demo.pointcutdesignator.args;

public class Person3 implements Animal3 {
	
	public Person3() {
		System.out.println("init");
	}
	
	public void showName(Long age) {
		System.out.println("Hello Person");
	}

	public void display() {
		System.out.println("Display");
	}

	public void printAge(Long age) {
		System.out.println("age: "+ age);
	}

	public void printPerson(Long age, String name) {
		System.out.println("age: " + age + " name: " + name);
	}

}
