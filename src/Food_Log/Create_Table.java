package Food_Log;

import java.sql.*;

public class Create_Table extends Setting {

	public Create_Table() throws Exception {
		String schema_name = "food_log";
		String table_name_user = "user_info";
		String table_name_list = "food_list";
		boolean schema_exists = false;
		boolean table_exists = false;
		String check_schema = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME = '" + schema_name + "'";
		String check_table_user = "CHECK TABLE " + schema_name + "." + table_name_user;
		String check_table_list = "CHECK TABLE " + schema_name + "." + table_name_list;

		new Setting();

		// 스키마 존재 여부 확인
		if (stmt.execute(check_schema))
			if (stmt.getResultSet().next())
				schema_exists = true;

		if (!schema_exists) { // 스키마가 존재하지 않으면 스키마 생성
			stmt.execute("CREATE SCHEMA `" + schema_name + "` DEFAULT CHARACTER SET utf8;");
			stmt.execute("SET GLOBAL local_infile = 1");
			System.out.println("스키마 생성");
		}


		// user_info 테이블 존재 여부 확인
		if (stmt.execute(check_table_user))
			if (stmt.getResultSet().next())
				table_exists = true;

		if(!table_exists) {  // 테이블이 존재하지 않으면 테이블 생성
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name_user + "` (\r\n"
					+ "`no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`user_name` VARCHAR(20), \r\n"
					+ "`user_id` VARCHAR(20), \r\n"
					+ "`user_pw` VARCHAR(45));");

			System.out.println("user_info 테이블 생성");
		}

		// user_info 테이블 존재 여부 확인
		table_exists = false;
		if (stmt.execute(check_table_list))
			if (stmt.getResultSet().next())
				table_exists = true;

		if(!table_exists) {
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name_list + "` (\r\n"
					+ "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`food_name` VARCHAR(50), \r\n"
					+ "`food_place` VARCHAR(70), \r\n"
					+ "`food_time` DATE, \r\n"
					+ "`food_star` INT);"); // 식당 이름, 주소, 방문한 날짜, 별점

			System.out.println("food_list 테이블 생성");
		}

	}

	public static void main(String[] args) {
		try {
			new Create_Table();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
}
