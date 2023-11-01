package Food_Log;

public class Create_Table_user_info extends Create_Schema {

	public Create_Table_user_info() throws Exception {
		String table_name = "user_info";
		boolean table_exists = false;
		String check_table = "CHECK TABLE " + schema_name + "." + table_name;

		new Setting();
		new Create_Schema();
		
		// user_info 테이블 존재 여부 확인
		if (stmt.execute(check_table))
			if (stmt.getResultSet().next())
				table_exists = true;

		if(!table_exists) {  // 테이블이 존재하지 않으면 테이블 생성
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name + "` (\r\n"
					+ "`no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`user_name` VARCHAR(20), \r\n"
					+ "`user_id` VARCHAR(20), \r\n"
					+ "`user_pw` VARCHAR(45));");

			System.out.println("user_info 테이블 생성");
		}
	}
}
