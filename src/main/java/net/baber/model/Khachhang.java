package net.baber.model;

public class Khachhang {
	private int id;
	private String ten;
	private String SDT;
	private String email;
	private int idAccount;
	
	public Khachhang(int id, String ten, String sDT, String email, int idAccount) {
		super();
		this.id = id;
		this.ten = ten;
		SDT = sDT;
		this.email = email;
		this.idAccount = idAccount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	
}
