package orm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class Dao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void insertUpdateUser(User u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
	
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	
	public List<User> getAllUser(){
		
		return this.hibernateTemplate.loadAll(User.class);
	}
	
	@Transactional
	public void deleteUser(User u) {
		this.hibernateTemplate.delete(u);
	}
}
