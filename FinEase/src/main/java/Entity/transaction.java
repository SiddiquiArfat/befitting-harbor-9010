package Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int amount;
	LocalDate date;
	String acountNum;
	String toAccountNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account acc;
	
	public transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public transaction(int amount, LocalDate date, String acountNum, String toAccountNum,Account acc) {
		super();
		this.amount = amount;
		this.date = date;
		this.acountNum = acountNum;
		this.toAccountNum = toAccountNum;
		this.acc = acc;
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
	public int getAmount() {
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
	
	
}
