package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Seller s1 = new Seller();
		s1.setSid(1);
		s1.setSname("Jainik");
		
		Products p1 = new Products();
		p1.setPid(1);
		p1.setPname("Mobile");
		p1.setPprice(16000);
		
		Products p2 = new Products();
		p2.setPid(2);
		p2.setPname("Laptop");
		p2.setPprice(25000);
		
		List<Products> list = new ArrayList<Products>();
		list.add(p1);
		list.add(p2);
		
		s1.setPlist(list);
		p1.setSellerName(s1);
		p2.setSellerName(s1);
		
		session.save(s1);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		sf.close();
	}
}
