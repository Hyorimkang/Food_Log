package Food_Log;

import java.io.File;
import java.io.FileWriter;

public class Update_user_info {
	public static final String userInfo = "./user_info.txt";  // 유저 아이디 저장 파일 경로
	public static String user_id;
	
	// 유저 정보 저장 파일 생성
	public Update_user_info(String u_id) {
		user_id = u_id;
		try {
			File file = new File(userInfo);
			FileWriter fw = new FileWriter(userInfo);
			fw.write(user_id);
			fw.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}

	}
}
