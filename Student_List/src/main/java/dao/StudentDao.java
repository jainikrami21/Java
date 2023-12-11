package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.student;

public class StudentDao {
	
	public StudentDao() {
	   }
	
	 public static void insertedStudent(student s) {
	      try {
	         Connection con = DBConnection.createConnection();
	         String sql = "insert into student (standard_id,firstName,lastName,Dob,image,CreatedDate,Status)values(?,?,?,?,?,?,?)";
	         PreparedStatement pst = con.prepareStatement(sql);
	         pst.setInt(1, s.getStandard_id());
	         pst.setString(2, s.getFirstName());
	         pst.setString(3, s.getLastName());
	         pst.setString(4, s.getDob());
	         pst.setString(5, s.getImage());
	         pst.setString(6, s.getCreatedDate());
	         pst.setString(7, s.getStatus());
	         pst.executeUpdate();
	         System.out.println("data inserted");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	  }
	 
	      
	      public static List<student> getAllstudent(){
		    	List<student> list = new ArrayList<student>();
		    	try {
		    		Connection conn = DBConnection.createConnection();
					String sql="select * from student";
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						student s1 = new student();
						s1.setId(rs.getInt("id"));
						s1.setStandard_id(rs.getInt("standard_id"));
						s1.setFirstName(rs.getString("firstName"));
						s1.setLastName(rs.getString("lastName"));
						s1.setDob(rs.getString("Dob"));
						s1.setImage(rs.getString("image"));
						s1.setCreatedDate(rs.getString("CreatedDate"));
						s1.setStatus(rs.getString("Status"));
						
						list.add(s1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	return list;
		    }
			
			
	 
}
