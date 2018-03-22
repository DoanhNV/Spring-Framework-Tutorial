package com.entity.projection;

public interface UserElement {
	public String getUserName();
	public Country getCountry();
	
	interface Country {
		public String getCountryName();
	}
	
	default String getFullName() {
		return getUserName().concat(getCountry().getCountryName());
	}
}
