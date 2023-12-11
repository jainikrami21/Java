package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import Model.Admin;


public class AdminDao {
		
		
		public static Admin AdminLogin(Admin u) {
			
			Admin u1 = null;	
			
			try {
				Connection conn = DBConnection.createConnection();
				String sql="select * from admin where email=? and password=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, u.getEmail());
				pst.setString(2, u.getPassword());
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					u1 = new Admin();
					u1.setId(rs.getInt("id"));
					u1.setEmail(rs.getString("email"));
					u1.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return u1;
		}
		
		
	}


