package packageOne;

public class Employee {
	private String pib;
	private String position;
	private String email;
	private String phone;
	private int age;
	
	public Employee(String pib, String position, String email, String phone, int age) {
		this.pib = pib;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}
		
	public void setPib(String pib) {
		this.pib = pib;
	}
	
	public String getPib() {
		return pib;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
}
