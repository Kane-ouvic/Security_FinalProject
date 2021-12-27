package me.com.main;

public class User {
	
	private String name;
	private String password;
	private String check_code;
	private int money;
	
	public User() {
		
		this.name = null;
		this.password = null;
		this.check_code = null;
		this.money = -1;
	}
	
	public User(String name, String password, String check_code, int money) {
		
		this.name = name;
		this.password = password;
		this.check_code = check_code;
		this.money = money;
	}
	
	public void defaultStats() {
		this.name = null;
		this.password = null;
		this.check_code = null;
		this.money = -1;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String  getName() {
		return this.name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setCheckCode(String check_code) {
		this.check_code = check_code;
	}
	
	public String getCheckCode() {
		return this.check_code;
	}
	
	public void setMoney(String money) {
		this.money = Integer.parseInt(money);
	}
	
	
	public int getMoney() {
		return this.money;
	}
}
