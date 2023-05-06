package Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String type;
	String status;
	String aadhar;
	String accountNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL)
	List<transaction> t;
	
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String name, String type, String status, String aadhar, String accountNo, Customer c) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
		this.aadhar = aadhar;
		this.accountNo = accountNo;
		this.customer = c;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public List<transaction> getT() {
		return t;
	}

	public void setT(List<transaction> t) {
		this.t = t;
	}

	public Customer getC() {
		return customer;
	}

	public void setC(Customer c) {
		this.customer = c;
	}
	
	
	
	
	
	
}
