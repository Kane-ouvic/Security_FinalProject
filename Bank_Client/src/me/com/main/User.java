package me.com.main;

public class User {
	
	private String name;
	private String password;
	private String check_code;
	private int money;
	
	public User(String name, String password, String check_code, int money) {
		
		this.name = name;
		this.password = password;
		this.check_code = check_code;
		this.money = money;
	}
	
	public String  getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getCheckCode() {
		return this.check_code;
	}
	
	public int getMoney() {
		return this.money;
	}
}
