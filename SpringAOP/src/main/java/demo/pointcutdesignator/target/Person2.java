package demo.pointcutdesignator.target;

public class Person2 implements Animal2 {
	
	public Person2() {
		System.out.println("init");
	}
	
	public void showName() {
		System.out.println("Hello Person");
	}

	public void display() {
		System.out.println("Display");
	}

}
