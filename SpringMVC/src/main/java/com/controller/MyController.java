package com.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MyController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/")
	public String indexPage(Model m) {
		m.addAttribute("num", 1);
		List<String> list = new ArrayList<String>();
		list.add("C");
		list.add("C++");
		list.add("Java");
		list.add("Python");
		list.add("Kotlin");
		list.add(".Net");
		m.addAttribute("list", list);
		return "index";
	}
	 
	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}	
	
	@RequestMapping("/home")
		public String home(Model m) {
			List<User> list = this.dao.getAllUsers();
			m.addAttribute("list", list);
			return "home";
			
		}
	
	
	@RequestMapping("/register")
	public String getRequest(@ModelAttribute User u,Model m) {
		this.dao.insertUpdateUser(u);
		List<User> list = this.dao.getAllUsers();
		m.addAttribute("list", list);
		return "home";
		
	}
	
	@RequestMapping(value="/update/{id}")
	public ModelAndView update(@PathVariable("id") int id) {
		User u = this.dao.getDataById(id);
		ModelAndView m = new ModelAndView();
		m.addObject("user", u);
		m.setViewName("update");
		return m;
		
	}
	
	@RequestMapping(value="/delete/{id}")
	public RedirectView delete(@PathVariable()int id,Model m,HttpServletRequest request){
		this.dao.deleteUser(id);
		List<User> list = this.dao.getAllUsers();
		m.addAttribute("list", list);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath()+"/home");
		return r;
		
	}
	
//	@RequestMapping("/register")
//	public void getRequest(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String con = request.getParameter("contact");
//		System.out.println(name + " "+con);
//	}
	
}
