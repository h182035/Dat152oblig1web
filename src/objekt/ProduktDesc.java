package objekt;

public class ProduktDesc {
	private Product product;
	private String desc;
	
	public ProduktDesc(Product p, String d) {
		this.product = p;
		this.desc = d;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
