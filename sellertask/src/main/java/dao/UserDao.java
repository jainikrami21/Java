package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.User;

public class UserDao {

	public static void insertUser(User s) {
		try {
			
			Connection conn = DBConnection.createConnection();
			String sql = "insert into users(name,email,password,contact)values(?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, s.getName());
				pst.setString(3, s.getEmail());
				pst.setString(2, s.getPassword());
				pst.setLong(4, s.getContact());
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
			String sql = "select * from users where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static User UserLogin(User s) {
		
		User s1= null;
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from users where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				s1 = new User();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
				s1.setContact(rs.getLong("contact"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
}
