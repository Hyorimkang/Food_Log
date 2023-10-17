package Food_Log;

public class Create_Table_food_list extends Create_Schema {
	Create_Table_food_list() throws Exception {
		String table_name = "food_list";
		String check_table = "CHECK TABLE " + schema_name + "." + table_name;
		boolean table_exists = false;
		
		new Setting();
		new Create_Schema();
		
		// user_info 테이블 존재 여부 확인
		table_exists = false;
		if (stmt.execute(check_table))
			if (stmt.getResultSet().next())
				table_exists = true;

		if(!table_exists) {
			stmt.execute("CREATE TABLE `" + schema_name + "`.`" + table_name + "` (\r\n"
					+ "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "`food_name` VARCHAR(50), \r\n"
					+ "`food_place` VARCHAR(70), \r\n"
					+ "`food_time` DATE, \r\n"
					+ "`food_star` INT);"); // 식당 이름, 주소, 방문한 날짜, 별점

			System.out.println("food_list 테이블 생성");
		}
	}
	public static void main(String args[]) {
		try {
			new Create_Table_food_list();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
}
