package dao;

import connection.DBConnection;

import model.BookService;
import model.ServiceMan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class BookingDao {
	public static void bookService(BookService b) {
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into book_services(cid,service_id,serviceman_id,service_status,payment_status) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, b.getCid());
			pst.setInt(2, b.getSid());
			pst.setInt(3, b.getServiceman_id());
			pst.setString(4, b.getBooking_status());
			pst.setString(5, b.getPayment_status());
			pst.executeUpdate();
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<BookService> getPendingServiceByCustomerId(int id){
		List<BookService> list = new ArrayList<BookService>();
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from book_services where cid=? and service_status='pending'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<BookService> getPendingServiceByServicemanId(int id){
		List<BookService> list = new ArrayList<BookService>();
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from book_services where serviceman_id=? and service_status='pending'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void updateBookingStatus(int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update book_services set service_status='confirm' where bid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Status Update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<BookService> getCompleteServiceByServicemanId(int id){
		List<BookService> list  = new ArrayList<BookService>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from book_services where serviceman_id=? and service_status='confirm'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<BookService> getCompleteServiceByCustomerId(int id){
		List<BookService> list  = new ArrayList<BookService>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from book_services where cid=? and service_status='confirm'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void updatesBookingStatus(int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update book_services set service_status='reject' where bid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Status Updates");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<BookService> getRejectServiceByServicemanId(int id){
		List<BookService> list  = new ArrayList<BookService>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from book_services where serviceman_id=? and service_status='reject'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<BookService> getRejectServiceByCustomerId(int id){
		List<BookService> list  = new ArrayList<BookService>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from book_services where cid=? and service_status='reject'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("service_id"));
				b.setServiceman_id(rs.getInt("serviceman_id"));
				b.setBooking_status(rs.getString("service_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public static List<BookService> getAllBookService(){
	    	List<BookService> list = new ArrayList<BookService>();
	    	try {
	    		Connection conn = DBConnection.createConnection();
				String sql="select * from book_services";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					BookService s1 = new BookService();
					s1.setBid(rs.getInt("bid"));
					s1.setCid(rs.getInt("cid"));
					s1.setSid(rs.getInt("service_id"));
					s1.setServiceman_id(rs.getInt("serviceman_id"));
					s1.setBooking_status(rs.getString("service_status"));
					s1.setPayment_status(rs.getString("payment_status"));
					list.add(s1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return list;
	    }
	
	
	
}
