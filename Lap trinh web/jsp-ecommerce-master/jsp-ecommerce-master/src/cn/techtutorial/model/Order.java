package cn.techtutorial.model;

public class Order extends Product{
	private int orderId;
	private int uid;
	private int qunatity;
	private String date;
	
	private String name;
	private String sdt;
	private String diachi;
	
	private String size;
	
	public Order() {
	}
	
	public Order(int orderId, int uid, int qunatity, String date, String name, String sdt, String diachi, String size) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
		this.name=name;
		this.sdt=sdt;
		this.diachi=diachi;
		this.size=size;
		
	}

	public Order(int uid, int qunatity, String date, String name, String sdt, String diachi, String size) {
		super();
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
		this.name=name;
		this.sdt=sdt;
		this.diachi=diachi;
		this.size=size;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSize() {
		return date;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
