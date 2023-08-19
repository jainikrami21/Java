package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnecion;
import Model.User;

public class UserDao {
	
	
	public static void insertUser(User u) {
		
		try {
			
			Connection conn = DBConnecion.createConnection();
			String sql = "insert into User(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName()); 
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			
			System.out.println("User Register");
			
		} catch (Exception e) {
			
				e.printStackTrace();
		}
		
	}
	
	public static User UserLogin(User u) {
		
		User u1 = null;	
		
		try {
			Connection conn = DBConnecion.createConnection();
			String sql="select * from users where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				u1 = new User();
				u1.setId(rs.getInt("id"));
				u1.setName(rs.getString("name"));
				u1.setContact(rs.getLong("contact"));
				u1.setAddress(rs.getString("address"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u1;
	}
	
	public static boolean checkEmail(String email) {
    	
    	boolean flag = false;
    	
    	try {
    		Connection conn = DBConnecion.createConnection();
    		String sql = "select * from users where email=?";
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
}