package demo.injectcollection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private List<String> marks;
	private Set<Integer> cars;
	private Map<String, String> companies;
	private Properties address;

	public List<String> getMarks() {
		return marks;
	}

	public void setMarks(List<String> marks) {
		this.marks = marks;
	}

	public Set<Integer> getCars() {
		return cars;
	}

	public void setCars(Set<Integer> cars) {
		this.cars = cars;
	}

	public Map<String, String> getCompanies() {
		return companies;
	}

	public void setCompanies(Map<String, String> companies) {
		this.companies = companies;
	}

	public Properties getAddress() {
		return address;
	}

	public void setAddress(Properties address) {
		this.address = address;
	}

}
