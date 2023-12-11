package Model;

public class Cart {

	private int cid,pid,Cusid,pprice,pqty,total;
	private String pname,payment_status;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCusid() {
		return Cusid;
	}
	public void setCusid(int cusid) {
		Cusid = cusid;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", Cusid=" + Cusid + ", pprice=" + pprice + ", pqty=" + pqty
				+ ", total=" + total + ", pname=" + pname + ", payment_status=" + payment_status + "]";
	}
	
	
	
	
	
	
	
	

	

	
	
}
