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
	String accountNo;
	double amount;
	int pin;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL)
	List<transaction> t;
	
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Account(String name, String type, String status, String accountNo, double amount, int pin, Customer customer,
			List<transaction> t) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
		this.accountNo = accountNo;
		this.amount = amount;
		this.pin = pin;
		this.customer = customer;
		this.t = t;
	}




	public Account(String name, String type, String status, int pin, String accountNo,Customer c) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
		this.pin = pin;
		this.accountNo = accountNo;
		this.customer = c;
		this.amount =0;
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
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
	
	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
