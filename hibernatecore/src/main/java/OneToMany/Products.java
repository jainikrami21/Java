package OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_data" )
public class Products {
	
	@Id
	@Column(name="product_id")
	private int pid;
	private String pname;
	private double pprice;
	@ManyToOne
	@JoinColumn(name="seller_name")
	private Seller sellerName;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public Seller getSellerName() {
		return sellerName;
	}
	public void setSellerName(Seller sellerName) {
		this.sellerName = sellerName;
	}
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", sellerName=" + sellerName + "]";
	}
	
	
}
