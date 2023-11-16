package Food_Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.event.ListDataEvent;

public class List_data {
	public static String user_id = "";
	private static String food_name = "";
	private static String food_place = "";
	private static String food_time = "";
	private static int food_star = 0;
	private static String food_hash = "";
	private static String food_write = "";
	private static String sql = "";

	public static PreparedStatement ps;
	public static ResultSet rs;

	public static FileReader fr;  // 유저 정보 받아오기
	public static BufferedReader br;

	public List_data() {
		try {
			Setting s = new Setting();
			fr = new FileReader(Update_user_info.userInfo);
			br = new BufferedReader(fr);
			user_id = br.readLine();
			sql = "SELECT * FROM food_log." + user_id;

			ps = s.conn.prepareStatement(sql);
			rs = ps.executeQuery();
		}catch(Exception e) {
			System.out.println("리스트 데이터 호출 실패: " + e.toString());
		}
	}
	public List_data(String sql) {
		this.sql = sql;
		try {
			Setting s = new Setting();
			fr = new FileReader(Update_user_info.userInfo);
			br = new BufferedReader(fr);
			user_id = br.readLine();
			ps = s.conn.prepareStatement(this.sql);
			rs = ps.executeQuery();
		}catch(Exception e) {
			System.out.println("리스트 데이터 호출 실패: " + e.toString());
			e.printStackTrace();
		}
	}
	public static String getFoodName() throws Exception {
		food_name = rs.getString("food_name");
		return food_name;
	}
	public static String getFoodPlace() throws Exception {
		food_place = rs.getString("food_place");
		return food_place;
	}
	public static String getFoodTime() throws Exception {
		food_time = rs.getString("food_time");
		return food_time;
	}
	public static int getFoodStar() throws Exception {
		food_star = rs.getInt("food_star");
		return food_star;
	}
	public static String getFoodHash() throws Exception {
		food_hash = rs.getString("food_hash");
		return food_hash;
	}
	public static String getFoodWrite() throws Exception {
		food_write = rs.getString("food_write");
		return food_write;
	}
}
