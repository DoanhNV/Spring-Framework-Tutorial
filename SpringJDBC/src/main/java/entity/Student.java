package entity;

public class Student {
	private int id;
	private String userName;
	private int age;

	public Student() {

	}
	
	public Student(String userName, int age) {
		this.userName = userName;
		this.age = age;
	}

	public Student(int id, String userName, int age) {
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", age=" + age + "]";
	}
	
}
