package demo.entity;

public class Student {

	private Pencil pencil;
	
	public Student() {

	}
	
	public void init() {
		System.out.println("init method");
	}
	
	public void clean() {
		System.out.println("clean all data");
	}
	
	public Student(Pencil pencil) {
		this.pencil = pencil;
	}

	public Pencil getPencil() {
		return pencil;
	}

	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}

	@Override
	public String toString() {
		return "Student [pencil=" + pencil + "]";
	}

}
