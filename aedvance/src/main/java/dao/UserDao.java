package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import model.User;

public class UserDao {

	public static void insertUser(User u) {
		try {
			Connection conn = DbConnection.createConnection();
			String sql = "insert into user(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			System.out.println("Data Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;

		try {
			Connection conn = DbConnection.createConnection();
			String sql = " select * from user where email=?";
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

	public static User userLogin(User u) {
		User u1 = null;
		try {
			Connection conn = DbConnection.createConnection();
			String sql = "select * from user where email=? and password=?";
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
		
		public static List<User> getAllUsers() {
			List<User> list = new ArrayList<User>();
			try {
				Connection conn = DbConnection.createConnection();
				String sql = "select * from user";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					User u1 = new User();
					u1.setId(rs.getInt("id"));
					u1.setName(rs.getString("name"));
					u1.setContact(rs.getLong("contact"));
					u1.setAddress(rs.getString("address"));
					u1.setEmail(rs.getString("email"));
					u1.setPassword(rs.getString("password"));
					list.add(u1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

	}
		
		public static User getUserById(int id) {
			User u1 = null;
			try {
				Connection conn = DbConnection.createConnection();
				String sql = "select * from user where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
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
		public static void updateUser(User u) {
			
			try {
				Connection conn = DbConnection.createConnection();
				String sql = "update user set name=?,contact=?,address=?,email=?,password=? where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, u.getName());
				pst.setLong(2, u.getContact());
				pst.setString(3, u.getAddress());
				pst.setString(4, u.getEmail());
				pst.setString(5, u.getPassword());
				pst.setInt(6, u.getId());
				pst.executeUpdate();
				System.out.println("Data Updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void deleteUser(int id) {
			
			try {
				Connection conn = DbConnection.createConnection();
				String sql = "delete from user where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("Data Delete");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
