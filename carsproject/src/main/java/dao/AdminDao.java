package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Admin;


public class AdminDao {

		public static void insertAdmin(Admin s) {
		        
				try {
					
					Connection conn = DBConnection.createConnection();
		    		String sql = "insert into admin(email,password) values(?,?)";
		    		PreparedStatement pst = conn.prepareStatement(sql);
		    		pst.setString(1,s.getEmail());
		    		pst.setString(2,s.getPassword());
		    		pst.executeUpdate();
		    		
		    		System.out.println("Data Inserted");
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}	
		    }
		
		public static boolean checkEmail(String email) {
		    	
		    	boolean flag = false;
		    	
		    	try {
		    		Connection conn = DBConnection.createConnection();
		    		String sql = "select * from admin where email=?";
		    		PreparedStatement pst = conn.prepareStatement(sql);
		    		pst.setString(1, email);
		    		ResultSet rs = pst.executeQuery();
		    		if(rs.next()) {
		    			flag = true;
		    		}
		    	}
		    	catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    	return flag;
		    }
			
		public static Admin AdminLogin(Admin s) {
	    	
			Admin s1 = null;
	    	try {
				Connection conn = DBConnection.createConnection();
				String sql="select * from admin where email=? and password=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, s.getEmail());
				pst.setString(2, s.getPassword());
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					s1 = new Admin();
				
					s1.setEmail(rs.getString("email"));
					s1.setPassword(rs.getString("password"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return s1;
	    }
		
		public static void updateAdmin(Admin s) {
			    	
			    	try {
			    		Connection conn = DBConnection.createConnection();
						String sql="update admin set email=? where id=?";
						PreparedStatement pst = conn.prepareStatement(sql);
						pst.setString(1, s.getEmail());
						pst.setInt(2, s.getId());
						pst.executeUpdate();
						System.out.println("Data Updated");
			    	} catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    }
		
		public static boolean checkOldPassword(String email, String op) {
    		boolean flag = false;
    		
    		try {
					
    			Connection conn = DBConnection.createConnection();
    			String sql = "select * from admin where email=? and password=?";
    			PreparedStatement pst = conn.prepareStatement(sql);
    			pst.setString(1, email);
    			pst.setString(2, op);
    			ResultSet rs = pst.executeQuery();
    			
    			if(rs.next()) {
    				flag = true;
    			}
    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return flag;
    }
    public static void updatePassword(String email, String np) {
    	try {
			
    		Connection conn = DBConnection.createConnection();
    		String sql = "update admin set password = ? where email = ?";
    		PreparedStatement pst = conn.prepareStatement(sql);
    		pst.setString(1, np);
    		pst.setString(2, email);
    		pst.executeUpdate();
    		System.out.println("Password Updated");
    		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

		
		
		
		
}
