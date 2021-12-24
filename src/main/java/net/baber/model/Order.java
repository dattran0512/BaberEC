package net.baber.model;

public class Order {
	private int id;
	private String CustomerName;
	private String CustomerPhone;
	private String orderDate;
	private long priceTotal;
	private Cuahang cuahang;
	
	
	public Order() {
		super();
	}
	public Order(int id, String customerName, String customerPhone, String buyDate, long priceTotal, Cuahang cuahang) {
		super();
		this.id = id;
		CustomerName = customerName;
		CustomerPhone = customerPhone;
		this.orderDate = buyDate;
		this.priceTotal = priceTotal;
		this.cuahang = cuahang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}
	public String getorderDate() {
		return orderDate;
	}
	public void setorderDate(String buyDate) {
		this.orderDate = buyDate;
	}
	public long getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Cuahang getCuahang() {
		return cuahang;
	}
	public void setCuahang(Cuahang cuahang) {
		this.cuahang = cuahang;
	}
	
	
}
