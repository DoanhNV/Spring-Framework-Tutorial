package demo.scope;

public class SingletonEntity {
	private String userName;

	public SingletonEntity(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return " [userName=" + userName + "]";
	}

}
