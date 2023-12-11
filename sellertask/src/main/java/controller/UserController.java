package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
			
			User s = new User();
			s.setName(request.getParameter("name"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			UserDao.insertUser(s);
			request.setAttribute("msg", "Data Inserted Successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);			
		}
		else if (action.equalsIgnoreCase("login")) {
			
			User s = new User();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			System.out.println(flag);
			if(flag == true) {
				User s1 = UserDao.UserLogin(s);
				if(s1 == null) {
					request.setAttribute("msg2", "Password is Incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "Account Not Registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
	

}
