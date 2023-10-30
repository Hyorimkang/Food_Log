package Food_Log;

import java.sql.*;

// DB 초기 세팅
public class Setting {
	private String url = "jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true";
	static String user = "root";
	static String password = "0178";
	public Connection conn;
	public Statement stmt;
	Setting() throws Exception {
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
	}
}