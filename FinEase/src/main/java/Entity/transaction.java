package Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	double amount;
	LocalDate date;
	String acountNum;
	String toAccountNum;
	String fromAccountNum;
	boolean withdraw;
	boolean deposite;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account acc;
	
	public transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public transaction(double amount, LocalDate date, String acountNum, String fromAccountNum, boolean deposite, Account acc) {
		super();
		this.amount = amount;
		this.date = date;
		this.acountNum = acountNum;
		this.fromAccountNum = fromAccountNum;
		
		this.deposite = deposite;
		this.acc = acc;
	}




	public transaction(double amount, LocalDate date, String acountNum, String toAccountNum, boolean withdraw,
			boolean deposite, Account acc) {
		super();
		
		this.amount = amount;
		this.date = date;
		this.acountNum = acountNum;
		this.toAccountNum = toAccountNum;
		this.withdraw = withdraw;
		this.deposite = deposite;
		this.acc = acc;
	}




	public transaction(double amount, LocalDate date, String acountNum, String toAccountNum,Account acc) {
		super();
		this.amount = amount;
		this.date = date;
		this.acountNum = acountNum;
		this.toAccountNum = toAccountNum;
		this.acc = acc;
	}
	
	
	
	
	
	public String getFromAccountNum() {
		return fromAccountNum;
	}




	public void setFromAccountNum(String fromAccountNum) {
		this.fromAccountNum = fromAccountNum;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public boolean isWithdraw() {
		return withdraw;
	}




	public void setWithdraw(boolean withdraw) {
		this.withdraw = withdraw;
	}




	public boolean isDeposite() {
		return deposite;
	}




	public void setDeposite(boolean deposite) {
		this.deposite = deposite;
	}




	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAcountNum() {
		return acountNum;
	}
	public void setAcountNum(String acountNum) {
		this.acountNum = acountNum;
	}
	public String getToAccountNum() {
		return toAccountNum;
	}
	public void setToAccountNum(String toAccountNum) {
		this.toAccountNum = toAccountNum;
	}




	@Override
	public String toString() {
		return "transaction [id=" + id + ", amount=" + amount + ", date=" + date + ", acountNum=" + acountNum
				+ ", toAccountNum=" + toAccountNum + ", fromAccountNum=" + fromAccountNum + ", withdraw=" + withdraw
				+ ", deposite=" + deposite + ", acc=" + acc + "]";
	}
	
	
}
