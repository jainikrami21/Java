package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.SellerDao;
import Dao.UserDao;
import Model.Seller;
import Model.User;
import Services.Service;






@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			User c = new User();
			c.setName(request.getParameter("name"));
			c.setContact(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			UserDao.insertCustomer(c);
			response.sendRedirect("user-login.jsp");
		}
		else if(action.equalsIgnoreCase("login")) {
			User c = new User();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			User c1 = UserDao.loginCustomer(c);
			if(c1 == null) {
				request.setAttribute("msg", "password is incorrect");
				request.getRequestDispatcher("user-login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", c1);
				request.getRequestDispatcher("user-home.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("update")) {
			User s = new User();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			UserDao.updateProfileuser(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("user-home.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("change password")) {
			User s = new User();
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = UserDao.checkOldPassword(id, op);
			if (flag == true) {
				if (np.equals(cnp)) {
					UserDao.changePasswrod(id, np);
					response.sendRedirect("user-home.jsp");
				} else {
					request.setAttribute("msg1", "old password and new password not matched");
					request.getRequestDispatcher("user-change-password.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Old password incorrect");
				request.getRequestDispatcher("user-change-password.jsp").forward(request, response);
			}
		}
		
		else if (action.equalsIgnoreCase("GET OTP")) {
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			if (flag == true) {
				Service s = new Service();
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Account not Registered");
				request.getRequestDispatcher("user-forgot-password.jsp").forward(request, response);
			}
		}
		
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("user-new-password.jsp").forward(request, response);
			} else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg", "otp not matched");
				request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("Update Password")){
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
				UserDao.changeNewPasswrod(email, np);
				response.sendRedirect("user-login.jsp");
			} else {
				request.setAttribute("msg", "np and cnp not matched");
				request.setAttribute("email", email);
				request.getRequestDispatcher("user-new-password.jsp").forward(request, response);
			}
		}
		
		
	}
	
}
