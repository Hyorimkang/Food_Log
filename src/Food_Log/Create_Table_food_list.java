package Food_Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

public class Create_Table_food_list extends Create_Schema {
	private FileReader fr;
	private BufferedReader br;
	private String user_id;
	
	public Create_Table_food_list() throws Exception {
		// File에 아이디 저장
		fr = new FileReader(Update_user_info.userInfo);
		br = new BufferedReader(fr);
		user_id = br.readLine();
		
		// user_info 테이블 존재 여부 확인
		String sql = "SHOW TABLES LIKE '" + user_id + "'";
		ResultSet rs = stmt.executeQuery(sql);

		if (!rs.next()) {
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + user_id + "` (\r\n"
					+ "`food_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`food_name` VARCHAR(50) NOT NULL, \r\n"
					+ "`food_place` VARCHAR(70) NOT NULL, \r\n"
					+ "`food_time` DATE NOT NULL, \r\n"
					+ "`food_star` INT NOT NULL, \r\n"
					+ "`food_hash` VARCHAR(50) NOT NULL, \r\n"
					+ "`food_write` VARCHAR(1000) NOT NULL);"); 
			// 유저 아이디, 식당 이름, 주소, 방문한 날짜, 별점, 해시태그, 후기
		}
	}
}
