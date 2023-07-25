package controller;

import java.io.IOException;





import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ServicemanDao;
import model.ServiceMan;
import service.services;



/**
 * Servlet implementation class ServicemanController
 */
@WebServlet("/ServicemanController")
public class ServicemanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicemanController() {
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
			ServiceMan s = new ServiceMan();
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			ServicemanDao.insertServiceman(s);
			request.setAttribute("msg", "Data Inserted Successfully");
			request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);	
			
		}
		else if (action.equalsIgnoreCase("login")) {
			ServiceMan s = new ServiceMan();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = ServicemanDao.checkEmail(email);
			if (flag == true) {
				ServiceMan s1 = ServicemanDao.servicemanLogin(s);
				if (s1 == null) {
					request.setAttribute("msg2", "Password is Incorrect");
					request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("serviceman-home.jsp").forward(request, response);
					
				}
			}
			
			else {
				request.setAttribute("msg1", "Account not Registered");
				request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("update")) {
			ServiceMan s = new ServiceMan();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			ServicemanDao.updateServiceMan(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("serviceman-profile.jsp").forward(request, response);
			
		}
		
		else if(action.equalsIgnoreCase("change password")) {
			
			ServiceMan s = new ServiceMan();
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = ServicemanDao.checkOldPassword(email,op);
			if(flag == true ) {
				if(np.equals(cnp)) {
						ServicemanDao.updatePassword(email, np);
						response.sendRedirect("serviceman-home.jsp");
				}
				else {
					request.setAttribute("msg", "New Password & Confirm New Password Is Not Matched");
					request.getRequestDispatcher("serviceman-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "Old Password is Incorrect");
				request.getRequestDispatcher("serviceman-change-password.jsp").forward(request, response);
			}
		}
		
		else if (action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = ServicemanDao.checkEmail(email);
			
			if(flag == true) {
				
				Random r = new Random();
				int num = r.nextInt(999999);
				services s = new services();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("serviceman-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Account not Registered");
				request.getRequestDispatcher("serviceman-forgot-password.jsp").forward(request, response);
			}
		}
		
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
					request.setAttribute("email", email);
					request.getRequestDispatcher("serviceman-new-password.jsp").forward(request, response);
			}
			else {
				
			}
		}
		else if (action.equalsIgnoreCase("update password")){
			
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
				ServicemanDao.updatePassword(email, np);
				response.sendRedirect("serviceman-login.jsp");
			}
		}
		else if (action.equalsIgnoreCase("update")) {
			ServiceMan s = new ServiceMan();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			ServicemanDao.updateServiceManList(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("admin-edit-list.jsp").forward(request, response);
		}
	}
	
			
		}
	
	
	



