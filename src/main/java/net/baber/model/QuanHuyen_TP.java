package net.baber.model;

public class QuanHuyen_TP {

	private int id; 
	private String name;
	private int nameTP;
	
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

	public int getNameTP() {
		return nameTP;
	}

	public void setNameTP(int nameTP) {
		this.nameTP = nameTP;
	}

	public QuanHuyen_TP(int id, String name, int nameTP) {
		super();
		this.id = id;
		this.name = name;
		this.nameTP = nameTP;
	}
	
	
}
