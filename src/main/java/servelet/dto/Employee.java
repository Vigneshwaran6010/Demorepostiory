package servelet.dto;

public class Employee 
{
	private int id;
	private String Name;
	private String Email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		Name = name;
		Email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", Email=" + Email + "]";
	}
	
	

}
