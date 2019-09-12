package objekt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "store", name = "product")
public class Product {
	
	@Id
	@Column(name = "pno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;
	private String pName;
	private float priceInEuro;
	private String imageFile;
	public Product(int pno, String pName, float priceInEuro, String imageFile) {
		super();
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}
	
	public Product() {
		
	}
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getPriceInEuro() {
		return priceInEuro;
	}
	public void setPriceInEuro(float priceInEuro) {
		this.priceInEuro = priceInEuro;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	
}
