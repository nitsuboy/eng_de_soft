package entity;

import java.io.Serializable;

public class Feedback implements Serializable{
	
	private String desc;
	private String rate;
	private String user;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Feedback(String desc, String rate, String user) {
		super();
		this.desc = desc;
		this.rate = rate;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Feedback [desc=" + desc + ", rate=" + rate + ", user=" + user + "]";
	}
	
	

}
