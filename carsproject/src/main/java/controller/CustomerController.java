package controller;

import java.io.IOException;




import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.ServicemanDao;
import model.Customer;
import model.ServiceMan;
import service.services;
/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			Customer s = new Customer();
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			CustomerDao.insertCustomer(s);
			request.setAttribute("msg", "Data Inserted Successfully");
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);		
		}
		else if (action.equalsIgnoreCase("login")) {
			Customer s = new Customer();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = CustomerDao.checkEmail(email);
			if (flag == true) {
				Customer s1 = CustomerDao.CustomerLogin(s);
				if (s1 == null) {
					request.setAttribute("msg2", "Password is Incorrect");
					request.getRequestDispatcher("customer-login.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("customer-home.jsp").forward(request, response);
					
				}
			}
			else {
				request.setAttribute("msg1", "Account not Registered");
				request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("update")) {
			Customer s = new Customer();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			CustomerDao.updateCustomer(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("customer-profile.jsp").forward(request, response);
			
		}	
		else if(action.equalsIgnoreCase("change password")) {
			
			Customer s = new Customer();
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = CustomerDao.checkOldPassword(email, op);   
			if(flag == true ) {
				if(np.equals(cnp)) {
						CustomerDao.updatePassword(email, cnp);
						response.sendRedirect("customer-home.jsp");
				}
				else {
					request.setAttribute("msg", "New Password & Confirm New Password Is Not Matched");
					request.getRequestDispatcher("customer-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "Old Password is Incorrect");
				request.getRequestDispatcher("customer-change-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = CustomerDao.checkEmail(email);
			
			if(flag == true) {
				
				Random r = new Random();
				int num = r.nextInt(999999);
				services s = new services();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("customer-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Account not Registered");
				request.getRequestDispatcher("customer-forgot-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
					request.setAttribute("email", email);
					request.getRequestDispatcher("customer-new-password.jsp").forward(request, response);
			}
			else {
				
			}
		}
		else if (action.equalsIgnoreCase("update password")){
			
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
			  CustomerDao.updatePassword(email, np);
				response.sendRedirect("customer-login.jsp");
			}
		}
		
		else if (action.equalsIgnoreCase("update")) {
			Customer s = new Customer();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			CustomerDao.updateCustomerList(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("admin-Customer-edit-list.jsp").forward(request, response);
		}
	}
	}

