package net.baber.model;



public class OrderdetailUser {
	private int id;
	private int idDichVu;
	private String idOrder;
	
	public OrderdetailUser(int id, int idDichVu, String idOrder) {
		super();
		this.id = id;
		this.idDichVu = idDichVu;
		this.idOrder = idOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDichVu() {
		return idDichVu;
	}

	public void setIdDichVu(int idDichVu) {
		this.idDichVu = idDichVu;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	
}
