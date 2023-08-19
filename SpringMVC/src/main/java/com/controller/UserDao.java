package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
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
	
	public User getDataById(int id) {
		
		User u = this.hibernateTemplate.get(User.class, id);
		return u;
	}
	
	public List<User> getAllUsers(){
		List<User> list = this.hibernateTemplate.loadAll(User.class);
		return list;
	}
	
	@Transactional
	public void deleteUser(int id) {
		User u = this.hibernateTemplate.get(User.class, id);
		this.hibernateTemplate.delete(u);
	}
}
