package Model;

public class Cart {

	private int uid,pid,Cusid;

	

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
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

	@Override
	public String toString() {
		return "Cart [uid=" + uid + ", pid=" + pid + ", Cusid=" + Cusid + "]";
	}
	
	
}
