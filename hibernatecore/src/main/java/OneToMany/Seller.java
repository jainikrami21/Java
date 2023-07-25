package OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seller_data")
public class Seller {
	@Id
	@Column(name="seller_id")
	private int sid;
	private String sname;
	@OneToMany(mappedBy = "sellerName")
	private List<Products> plist;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Products> getPlist() {
		return plist;
	}
	public void setPlist(List<Products> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + "]";
	}
	
	

}
