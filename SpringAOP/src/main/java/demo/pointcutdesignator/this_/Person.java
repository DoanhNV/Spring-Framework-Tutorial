package demo.pointcutdesignator.this_;

public class Person extends Animal {
	
	private String name;
	
	public void showName() {
		System.out.println("Hello Person");
	}

	@Override
	public void display() {
		System.out.println("Display");
	}
	
}
