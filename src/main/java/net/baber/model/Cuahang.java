package net.baber.model;

public class Cuahang {
	private int id;
	private String name;
	private String address;
	private int idQH;
	
	public Cuahang(int id, String name, String address, int idQH) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.idQH = idQH;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIdQH() {
		return idQH;
	}
	public void setIdQH(int idQH) {
		this.idQH = idQH;
	}
	
	
	
	
	
}
