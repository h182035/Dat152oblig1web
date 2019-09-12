package objekt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema = "store", name = "description")
public class Description {
	
	@Id
	@Column(name = "pno")
	private int pno;
	@Id
	private String langCode;
	private String text;
	
	
	public Description(int pno, String langCode, String text) {
		super();
		this.pno = pno;
		this.langCode = langCode;
		this.text = text;
	}
	
	public Description() {
		
	}
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
