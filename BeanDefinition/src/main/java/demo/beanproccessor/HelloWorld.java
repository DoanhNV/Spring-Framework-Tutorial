package demo.beanproccessor;

public class HelloWorld {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public void init() {
		System.out.println("init Hellowrod");
	}
	
	public void destroy() {
		System.out.println("destroy Helloworld");
	}

	@Override
	public String toString() {
		return " [message=" + message + "]";
	}
	
}
