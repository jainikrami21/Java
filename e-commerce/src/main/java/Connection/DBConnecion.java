package Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnecion {
	public static Connection createConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}





