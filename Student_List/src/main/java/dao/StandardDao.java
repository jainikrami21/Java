package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.standard;
import model.student;



public class StandardDao {
	
	public StandardDao() {
		
	}
	
	public static void insertStandard(standard s) {
		
		try {
	         Connection con = DBConnection.createConnection();
	         String sql = "insert into standard (s_id,name,status)values(?,?,?)";
	         PreparedStatement pst = con.prepareStatement(sql);
	         
	         pst.setInt(1, s.getS_id());
	         pst.setString(2, s.getName());
	         pst.setString(3, s.getStatus());
	         
	         pst.executeUpdate();
	         System.out.println("data inserted");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}
	 public static List<standard> getAllstandard(){
	    	List<standard> list = new ArrayList<standard>();
	    	try {
	    		Connection conn = DBConnection.createConnection();
				String sql="select * from standard";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					standard s1 = new standard();
					s1.setS_id(rs.getInt("s_id"));;
					s1.setName(rs.getString("name"));
					s1.setStatus(rs.getString("status"));
					
					list.add(s1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return list;
	    }
}
