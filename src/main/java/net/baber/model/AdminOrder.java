package net.baber.model;

import java.util.List;

public class AdminOrder {
	private String id;
	private String cName;
	private String cPhone;
	private List<String> listDichVu;
	private String storeName;
	private int totalPrice;
	private String dateTime;
	private int payment;
	
	public AdminOrder(String id, String cName, String cPhone, List<String> listDichVu, String storeName, int totalPrice,
			String dateTime, int payment) {
		super();
		this.id = id;
		this.cName = cName;
		this.cPhone = cPhone;
		this.listDichVu = listDichVu;
		this.storeName = storeName;
		this.totalPrice = totalPrice;
		this.dateTime = dateTime;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public List<String> getListDichVu() {
		return listDichVu;
	}

	public void setListDichVu(List<String> listDichVu) {
		this.listDichVu = listDichVu;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
