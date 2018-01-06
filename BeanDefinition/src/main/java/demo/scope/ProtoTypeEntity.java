package demo.scope;

public class ProtoTypeEntity {
	private String userName;

	public ProtoTypeEntity(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return " [userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
