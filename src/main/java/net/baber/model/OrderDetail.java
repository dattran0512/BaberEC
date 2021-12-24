package net.baber.model;

public class OrderDetail {
	private int id;
	private long unitPrice;
	private Order order;
	private DichVu dichvu;
	
	
	public OrderDetail() {
		super();
	}
	public OrderDetail(int id, long unitPrice, Order order, DichVu dichvu) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.order = order;
		this.dichvu = dichvu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	
	

	
}
