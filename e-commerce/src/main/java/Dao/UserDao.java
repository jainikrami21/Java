package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Model.Seller;
import Model.User;


public class UserDao {
	
	public static void insertCustomer(User c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into user(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setLong(2, c.getContact());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static User loginCustomer(User c) {
		User c1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from user where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getEmail());
			pst.setString(2, c.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				c1 = new User();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c1;
	}
	public static List<User> getAllCustomers(){
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from user";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				User c1 = new User();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getLong("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPassword(rs.getString("password"));
				list.add(c1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static User getCustomerById(int id) {
		User s1 = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from user where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			ResultSet rSet = pst.executeQuery();
			if(rSet.next()) {
				s1 = new User();
				s1.setId(rSet.getInt("id"));
				s1.setName(rSet.getString("name"));
				s1.setContact(rSet.getLong("contact"));
				s1.setAddress(rSet.getString("address"));
				s1.setEmail(rSet.getString("email"));
				s1.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
		
	}
	public static void updateProfileuser(User s) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update user set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getName());
			pst.setLong(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(int id,String op) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from user where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rSet = pst.executeQuery();
			if(rSet.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void changePasswrod(int id,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update user set password=? where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="select * from user where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, email);
			ResultSet rs  = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void changeNewPasswrod(String email,String np) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="update user set password=? where email=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password changed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteCustomer(int id){
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString="delete from user where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
