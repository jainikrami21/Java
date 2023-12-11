package model;

public class standard {
	
	private int s_id;
	private String name;
	private String status;

	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "standard [s_id=" + s_id + ", name=" + name + ", status=" + status + "]";
	}
	
	public standard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
