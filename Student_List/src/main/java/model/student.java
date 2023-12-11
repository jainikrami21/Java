package model;

public class student {
	
	private String firstName;
	private String lastName;
	private String image;
	private String Status;
	private String Dob;
	private String CreatedDate;
	private int id;
	private int standard_id;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(int standard_id) {
		this.standard_id = standard_id;
	}
	@Override
	public String toString() {
		return "student [firstName=" + firstName + ", lastName=" + lastName + ", image=" + image + ", Status=" + Status
				+ ", Dob=" + Dob + ", CreatedDate=" + CreatedDate + ", id=" + id + ", standard_id=" + standard_id + "]";
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
