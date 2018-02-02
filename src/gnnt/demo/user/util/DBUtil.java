package gnnt.demo.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn=null;
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@//172.18.3.15:1521/gnnt";
        conn = DriverManager.getConnection(url,"trade_peixun","peixunsjk");       
		return conn;
	}

	public static void closeConnection(Connection conn) throws SQLException{
		if(conn!=null){
			conn.close();
		}
	}
}
