package Food_Log;

import java.sql.*;

public class Setting {
	static void initDB() throws Exception {
		String url = "jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true";
		String user = "root";
		String password = "0178";
		var conn = DriverManager.getConnection(url, user, password);
		var stmt = conn.createStatement();
		
		System.out.println("연결 성공");
		
		stmt.execute("DROP SCHEMA IF EXISTS `맛집의지도`");
		stmt.execute("CREATE SCHEMA `맛집의지도` DEFAULT CHARACTER SET utf8;");
		stmt.execute("SET GLOBAL local_infile = 1");
		
		System.out.println("스키마 생성");

		stmt.execute("CREATE TABLE `맛집의지도`.`user_info` (\r\n"
				+ "`no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
				+ "`name` VARCHAR(20), \r\n"
				+ "`id` VARCHAR(20), \r\n"
				+ "`pw` VARCHAR(45));");
		
		System.out.println("테이블 생성");
	}
	
	public static void main(String[] args) {
		try {
			initDB();
			System.out.println("setting 성공");
		} catch (Exception e) {
			System.out.println("setting 실패");
			e.printStackTrace();
		}
	}
}
