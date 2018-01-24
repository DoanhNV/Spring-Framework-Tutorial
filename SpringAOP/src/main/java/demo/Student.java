package demo;

public class Student {
	private String userName;
	
	public Student() {

	}
	
	public Student(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void showName() {
		System.out.println("my name is " +  userName);
	}
	
	public void testThrow () throws Exception {
		throw new Exception();
	}
	
	public void testAround() throws Exception {
		System.out.println("I'm around!");
		throw new Exception();
	}
}
