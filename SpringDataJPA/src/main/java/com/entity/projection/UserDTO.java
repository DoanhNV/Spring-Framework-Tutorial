package com.entity.projection;

import com.entity.AbstractEntity;

public class UserDTO extends AbstractEntity {
	private String userName;
	private int age;

	public UserDTO(String userName, int age) {
		this.userName = userName;
		this.age = age;
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

}
