package Entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public
class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	int age;
	String mobile;
	String email;
	String password;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Address> li;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	Set<Account> acc;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, int age, String mobile, String email, String password, List<Address> li) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.li = li;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Address> getLi() {
		return li;
	}
	public void setLi(List<Address> li) {
		this.li = li;
	}
	
	
	
	
}