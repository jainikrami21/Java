package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class User {
	
	private int id;
	private String name;
	private long contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		
//		System.out.println("bean destroyed");
//		
//	}
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		
//		System.out.println("bean Started");
//		
//	}
	
	
//	public void start() {
//		System.out.println("bean started");
//	}
//	
//	public void stop() {
//		System.out.println("bean destroyed");
//	}
	
	@PostConstruct
	public void start() {
		System.out.println("bean started");
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("bean destroyed");
	}

}
