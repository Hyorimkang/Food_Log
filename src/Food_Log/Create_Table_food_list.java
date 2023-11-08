package Food_Log;

import java.sql.ResultSet;

public class Create_Table_food_list extends Create_Schema {
	public static String table_name = "food_list";
	
	Create_Table_food_list() throws Exception {
		// user_info 테이블 존재 여부 확인
		String sql = "SHOW TABLES LIKE '" + table_name + "'";
        ResultSet resultSet = stmt.executeQuery(sql);

        if (!resultSet.next()) {
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name + "` (\r\n"
					+ "`no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`user_id` VARCHAR(20), \r\n"
					+ "`food_name` VARCHAR(50), \r\n"
					+ "`food_place` VARCHAR(70), \r\n"
					+ "`food_time` DATE, \r\n"
					+ "`food_star` INT, \r\n"
					+ "`food_hash` VARCHAR(50), \r\n"
					+ "`food_write` VARCHAR(1000));"); 
			// 유저 아이디, 식당 이름, 주소, 방문한 날짜, 별점, 해시태그, 후기

			System.out.println("food_list 테이블 생성");
		}
	}
}
