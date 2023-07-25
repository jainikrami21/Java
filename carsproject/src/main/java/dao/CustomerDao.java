package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Customer;
import model.ServiceMan;



public class CustomerDao {
	
	public static void insertCustomer(Customer s) {
        
		try {
			
			Connection conn = DBConnection.createConnection();
    		String sql = "insert into customer(name,contact,address,email,password) values(?,?,?,?,?)";
    		PreparedStatement pst = conn.prepareStatement(sql);
    		pst.setString(1,s.getName());
    		pst.setLong(2,s.getContact());
    		pst.setString(3,s.getAddress());
    		pst.setString(4,s.getEmail());
    		pst.setString(5,s.getPassword());
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
		    		String sql = "select * from customer where email=?";
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
			
		public static Customer CustomerLogin(Customer s) {
	    	
			Customer s1 = null;
	    	try {
				Connection conn = DBConnection.createConnection();
				String sql="select * from customer where email=? and password=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, s.getEmail());
				pst.setString(2, s.getPassword());
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					s1 = new Customer();
					s1.setId(rs.getInt("id"));
					s1.setName(rs.getString("name"));
					s1.setContact(rs.getLong("contact"));
					s1.setAddress(rs.getString("address"));
					s1.setEmail(rs.getString("email"));
					s1.setPassword(rs.getString("password"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return s1;
	    }
		
		public static void updateCustomer(Customer s) {
	    	
	    	try {
	    		Connection conn = DBConnection.createConnection();
				String sql="update customer set name=?,contact=?,address=?,email=? where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1,s.getName());
				pst.setLong(2, s.getContact());
				pst.setString(3, s.getAddress());
				pst.setString(4, s.getEmail());
				pst.setInt(5, s.getId());
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
	    			String sql = "select * from customer where email=? and password=?";
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
	    		String sql = " update customer set password = ? where email = ?";
	    		PreparedStatement pst = conn.prepareStatement(sql);
	    		pst.setString(1, np);
	    		pst.setString(2, email);
	    		pst.executeUpdate();
	    		System.out.println("Password Updated");
	    		
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    }
		
		public static Customer getCustomerById(int id) {
			Customer s1 = null;
			try {
				Connection conn = DBConnection.createConnection();
				String sql="select * from customer where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					s1 = new Customer();
					s1.setId(rs.getInt("id"));
					s1.setName(rs.getString("name"));
					s1.setContact(rs.getLong("contact"));
					s1.setAddress(rs.getString("address"));
					s1.setPassword(rs.getString("password"));
				}
				
			} catch (Exception e) {
					e.printStackTrace();
			}
			return s1;
		}
		
		public static List<Customer> getAllCustomer(){
	    	List<Customer> list = new ArrayList<Customer>();
	    	try {
	    		Connection conn = DBConnection.createConnection();
				String sql="select * from customer";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					Customer s1 = new Customer();
					s1.setId(rs.getInt("id"));
					s1.setName(rs.getString("name"));
					s1.setContact(rs.getLong("contact"));
					s1.setAddress(rs.getString("address"));
					s1.setEmail(rs.getString("email"));
					s1.setPassword(rs.getString("password"));
					list.add(s1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return list;
	    }
		
		    
		    public static Customer getSingleCustomerByid(int id){
				Customer s = null;
				
				try {
					Connection conn = DBConnection.createConnection();
					String sql = "select * from customer where id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					ResultSet sr = pst.executeQuery();
					if(sr.next()) {
						 s = new Customer();
						s.setId(sr.getInt("id"));
						s.setName(sr.getString("name"));
						s.setContact(sr.getLong("contact"));
						s.setAddress(sr.getString("address"));
						s.setEmail(sr.getString("email"));
						s.setPassword(sr.getString("password"));
					
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return s;
			}
		    
		    public static void updateCustomerList(Customer s){
		    	try {
		    		Connection conn = DBConnection.createConnection();
					String sql="update customer set name=?,contact=?,address=?,email=? where id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, s.getName());
					pst.setLong(2, s.getContact());
					pst.setString(3, s.getAddress());
					pst.setString(4, s.getEmail());
					pst.setString(5, s.getPassword());
					pst.executeUpdate();
					System.out.println("Admin Customer List Updated");
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	
		    }
		    public static void deleteCustomer(int id) {
				try {
					Connection conn = DBConnection.createConnection();
					String sql= "delete from customer where id=?";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					pst.executeUpdate();
					System.out.println("Admin Customer List deleted");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		    


}
