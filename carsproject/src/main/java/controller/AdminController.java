package controller;

import java.io.IOException;


import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import model.Admin;
import service.services;


/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
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
			Admin s = new Admin();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			AdminDao.insertAdmin(s);
			request.setAttribute("msg", "Data Inserted Successfully");
			request.getRequestDispatcher("admin-login.jsp").forward(request, response);		
		}
		
		if (action.equalsIgnoreCase("login")) {
			Admin s = new Admin();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = AdminDao.checkEmail(email);
			if (flag == true) {
				Admin s1 = AdminDao.AdminLogin(s);
				if (s1 == null) {
					request.setAttribute("msg2", "Password is Incorrect");
					request.getRequestDispatcher("admin-login.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("admin-home.jsp").forward(request, response);
					
				}
			}
			else {
				request.setAttribute("msg1", "Account not Registered");
				request.getRequestDispatcher("admin-login.jsp").forward(request, response);
			}
		}
		
		
		
		else if (action.equalsIgnoreCase("update")) {
			Admin s = new Admin();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setEmail(request.getParameter("email"));
			AdminDao.updateAdmin(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("admin-profile.jsp").forward(request, response);
			
		}	
		
		else if(action.equalsIgnoreCase("change password")) {
			
			Admin s = new Admin();
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = AdminDao.checkOldPassword(email, op);   
			if(flag == true ) {
				if(np.equals(cnp)) {
						AdminDao.updatePassword(email, cnp);
						response.sendRedirect("admin-home.jsp");
				}
				else {
					request.setAttribute("msg", "New Password & Confirm New Password Is Not Matched");
					request.getRequestDispatcher("admin-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "Old Password is Incorrect");
				request.getRequestDispatcher("admin-change-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = AdminDao.checkEmail(email);
			
			if(flag == true) {
				
				Random r = new Random();
				int num = r.nextInt(999999);
				services s = new services();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("admin-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Account not Registered");
				request.getRequestDispatcher("admin-forgot-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
					request.setAttribute("email", email);
					request.getRequestDispatcher("admin-new-password.jsp").forward(request, response);
			}
			else {
				
			}
		}
		else if (action.equalsIgnoreCase("update password")){
			
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
			  AdminDao.updatePassword(email, np);
				response.sendRedirect("admin-login.jsp");
			}
		}

	
	}

}
