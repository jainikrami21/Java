package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StandardDao;
import model.standard;

/**
 * Servlet implementation class Standard_servlet
 */
@WebServlet("/Standard_servlet")
public class Standard_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Standard_servlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("AddStandard")) {
			
			standard s = new standard();
			
			s.setName(request.getParameter("name"));
			s.setStatus(request.getParameter("status"));
			
			StandardDao.insertStandard(s);
			
			request.setAttribute("msg", "data inserted successfully");
			request.getRequestDispatcher("list_standard.jsp").forward(request, response);
			
		}
	}

}
