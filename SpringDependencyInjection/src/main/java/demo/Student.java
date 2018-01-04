package demo;

public class Student {

	private Pencil pencil;
	private String StudentName;
	private int age;

	public Student() {

	}

	public Student(Pencil pencil) {
		this.pencil = pencil;
	}

	public Student(Pencil pencil, String userName) {
		this.pencil = pencil;
		this.StudentName = userName;
	}

	public Student(Pencil pencil, int age) {
		this.pencil = pencil;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [pencil=" + pencil + ", StudentName=" + StudentName + ", age=" + age + "]";
	}

	public Pencil getPencil() {
		return pencil;
	}

	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

}
