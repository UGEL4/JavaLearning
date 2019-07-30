package entity;

public class Product {
	private String name;
	private String id;
	private double price;
	
	public Product(String name, String id, double price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "商品 [名称=" + name + ", 编号=" + id + ", 价格=" + price + "]";
	}
}
