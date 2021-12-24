package net.baber.model;

public class account {
	private int id;
	private String name;
	private String phone;
	private String taikhoan;
	private String matkhau;
	
	
	public account(String taikhoan, String matkhau) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}


	public account(int id, String name, String phone, String taikhoan, String matkhau) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTaikhoan() {
		return taikhoan;
	}


	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}


	public String getMatkhau() {
		return matkhau;
	}


	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
	
	
	
	


	
}
