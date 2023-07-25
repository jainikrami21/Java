package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Owner o1 = new Owner();
		o1.setId(1);
		o1.setName("Jainik");
		o1.setAddress("Ahmedabad");
		
		Owner o2 = new Owner();
		o2.setId(2);
		o2.setName("Nirav");
		o2.setAddress("Ahmedabad");
		
		Vehicle v1 = new Vehicle();
		v1.setId(1);
		v1.setModel("BAJAJ");
		
		Vehicle v2 = new Vehicle();
		v2.setId(2);
		v2.setModel("TVS");
		
		o1.setVehicleName(v1);
		v1.setOwnerName(o1);
		
		o2.setVehicleName(v2);
		v2.setOwnerName(o2);
		
		session.save(o1);
		session.save(o2);
		session.save(v1);
		session.save(v2);
		
		tx.commit();
		session.close();
		sf.close();
	} 

}
