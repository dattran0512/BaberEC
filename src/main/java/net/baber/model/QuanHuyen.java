package net.baber.model;

public class QuanHuyen {
	private int id; 
	private String name;
	private int idTP;
	
	
	public QuanHuyen(int id, String name, int idTP) {
		super();
		this.id = id;
		this.name = name;
		this.idTP = idTP;
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
	public int getIdTP() {
		return idTP;
	}
	public void setIdTP(int idTP) {
		this.idTP = idTP;
	}
	
	
}
