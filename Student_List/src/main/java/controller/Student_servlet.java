package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StudentDao;
import model.student;

/**
 * Servlet implementation class Student_servlet
 */
@WebServlet("/Student_servlet")
public class Student_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_servlet() {
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
		private String extractfilename(Part file) {
			String cd = file.getHeader("content-disposition");
			System.out.println(cd);
			String[] items = cd.split(";");
			
			for(String string : items) {
				if(string.trim().startsWith("filename")) {
					return string.substring(string.indexOf("=") + 2, string.length()-1);
					
			}
		}
			return "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("AddStudent")) {
			
			String savepath = "C:\\Users\\PARUL\\eclipse-workspace\\Student_List\\src\\main\\webapp\\image";
					File fileSaveDir=new File(savepath);
					if(!fileSaveDir.exists()) {
						fileSaveDir.mkdir();
					}
					Part file1 = request.getPart("image");
					String fileName = extractfilename(file1);
					file1.write(savepath + File.separator + fileName);
					String filePath = savepath + File.separator + fileName;
					
					String savepath2 = "C:\\Users\\PARUL\\eclipse-workspace\\Student_List\\src\\main\\webapp\\image";
					
					File imgSaveDir = new File(savepath2);
					if(!imgSaveDir.exists()) {
						imgSaveDir.mkdir();
					}
					
					student s = new student();
					
					s.setFirstName(request.getParameter("firstName"));
					s.setLastName(request.getParameter("lastName"));
					s.setDob(request.getParameter("Dob"));
					s.setImage(request.getParameter("image"));
					s.setCreatedDate(request.getParameter("CreatedDate"));
					s.setStatus(request.getParameter("Status"));
					
					StudentDao.insertedStudent(s);
					
					request.setAttribute("msg", "data inserted sucessfully");
					request.getRequestDispatcher("list_student.jsp").forward(request, response);
		}
	}

}
