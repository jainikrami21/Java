package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.DBConnection;
import model.User;

public class UserDao {
	
	public static void insertUser(User u) {
		
		Session session = new DBConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	
	public static boolean checkEmail(String email) {
		
		boolean flag = false;
		
		Session session = new DBConnection().getSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		List results = query.list();
		
		if (!results.isEmpty()) {
				flag = true;
			System.out.println(flag);
				
		}
		tx.commit();
		session.close();
		return flag;
	}
	
	public static User userlogin(User u) {
		
		Session session = new DBConnection().getSession();
		Transaction tx = session.beginTransaction();
		String hql = "From User u where u.email=:email and u.password=:password";
		Query query = session.createQuery(hql);
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPassword());
		List results = query.list();
		User u1 = (User) results.get(0);
		
		tx.commit();
		session.close();
		
		return u1;
		
	}
	
}
