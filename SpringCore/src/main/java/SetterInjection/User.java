package SetterInjection;

public class User {
	
	private int id;
	private String name;
	private long contact;
	
	public int getId() {
		System.out.println("Getter Id");
		return id;
	}
	public void setId(int id) {
		System.out.println("Setter Id");
		this.id = id;
	}
	public String getName() {
		System.out.println("Getter Name");
		return name;
	}
	public void setName(String name) {
		System.out.println("Setter Name");
		this.name = name;
	}
	public long getContact() {
		System.out.println("Getter Contact");
		return contact;
	}
	public void setContact(long contact) {
		System.out.println("Setter Contact");
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
	
	
	
}
