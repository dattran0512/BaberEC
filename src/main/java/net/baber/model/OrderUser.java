package net.baber.model;

public class OrderUser {
	private String idString;
	private int idCuaHang;
	private int idAccount;
	private String cName;
	private String cPhone;
	private String orderDate;
	private long TotalPrice;
	private int Payment;
	
	
	
	
	public OrderUser(String idString, int idCuaHang, int idAccount, String cName, String cPhone, String orderDate,
			long totalPrice, int payment) {
		super();
		this.idString = idString;
		this.idCuaHang = idCuaHang;
		this.idAccount = idAccount;
		this.cName = cName;
		this.cPhone = cPhone;
		this.orderDate = orderDate;
		TotalPrice = totalPrice;
		Payment = payment;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public int getIdCuaHang() {
		return idCuaHang;
	}
	public void setIdCuaHang(int idCuaHang) {
		this.idCuaHang = idCuaHang;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public long getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getPayment() {
		return Payment;
	}
	public void setPayment(int payment) {
		Payment = payment;
	}
	
	
	
	
}
