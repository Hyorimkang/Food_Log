package Food_Log;

import java.sql.ResultSet;

public class Create_Table_user_info extends Create_Schema {
	public static final String table_name = "user_info";
	public Create_Table_user_info() throws Exception {
		// 유저 테이블 존재 여부 확인
		String sql = "SHOW TABLES LIKE '" + table_name + "'";
        ResultSet resultSet = stmt.executeQuery(sql);
        
        if (!resultSet.next()) {
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name + "` (\r\n"
					+ "`user_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`user_name` VARCHAR(20) NOT NULL, \r\n"
					+ "`user_id` VARCHAR(20) NOT NULL, \r\n"
					+ "`user_pw` VARCHAR(45) NOT NULL);");
		}
	}
}
