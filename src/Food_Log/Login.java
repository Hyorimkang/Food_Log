package Food_Log;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame{
	private JPanel jp;
	private JLabel lblLogin;
	private JLabel lblId;
	private JTextField userId;
	private JLabel lblPw;
	private JPasswordField userPw;
	private JButton btnLogin;
	
	public static void main(String[] args) {
		new Login();
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("로그인");
		
		jp = new JPanel();
		jp.setSize(900,600);
		jp.setLayout(null);
		jp.setVisible(true);
		
		lblLogin();
		btnLogin();
		userId();
		userPw();
		
		setVisible(true);
	}
	public void lblLogin() {
		lblLogin = new JLabel("LOGIN");
<<<<<<< HEAD
		lblLogin.setBounds(370, 100, 200, 80);
=======
>>>>>>> 9874e32 ([:lipstick:] Login Font 추가)
		lblLogin.setBounds(350, 100, 200, 80);
		lblLogin.setFont(new Font("땅스부대찌개 Bold", Font.BOLD, 40));
		jp.add(lblLogin);
		add(jp);
	}
	
	public void btnLogin() {
		btnLogin = new JButton();
		btnLogin.setBounds(330, 400, 200, 50);
		jp.add(btnLogin);
		add(jp);
	}
	
	public void userId() {
		lblId = new JLabel("아이디");
		lblId.setBounds(210, 200, 100, 50);
		lblId.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblId);
		add(jp);
		
		userId = new JTextField(10);
		userId.setBounds(320, 200, 300, 50);
		jp.add(userId);
		add(jp);
	}
	
	public void userPw() {
		lblPw = new JLabel("비밀번호");
		lblPw.setBounds(210, 300, 100, 50);
		lblPw.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblPw);
		add(jp);
		
		userPw = new JPasswordField();
		userPw.setBounds(320, 300, 300, 50);
		jp.add(userPw);
		add(jp);
	}
	
	public void btnBack() {
		
	}
		
		
//		userId = new JTextField();
//		userId.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
//		userId.setBounds(133, 200, 254, 118);
//		jp.add(userId);
//		userId.setColumns(10); 
//		userId.setLayout(getLayout());
	
		
//		userPw = new JPasswordField();
//		userPw.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
//		userPw.setBounds(133, 400, 254, 118);
//		getContentPane().add(userPw);
//		userPw.setColumns(10);
//		
//		btnLogin = new JButton("로그인");
//		btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
//		btnLogin.setBounds(133, 500, 254, 118);
//		getContentPane().add(btnLogin);
//		btnLogin.setVisible(true);
	}
	
	//배경이미지
	//private Image background = new ImageIcon(Main.class.getResource("C:\\\\Food_Log\\\\Food_Log\\\\img\\\\Login.png")).getImage();
	
//	//이미지 넣기
//	private void Image() {
//		JLabel imgLabel = new JLabel();
//        
//        // 아이콘 생성
//        ImageIcon icon = new ImageIcon(
//            Login.class.getResource("/img/Login.png")
//        );
//        
//        // 라벨에 아이콘(이미지) 설정
//        imgLabel.setIcon(icon);
//        
//        // 라벨 설정(크기, 정렬...)
//        imgLabel.setBounds(210, 30, 165, 150);
//        imgLabel.setHorizontalAlignment(JLabel.CENTER);
//		
//        //프레임에 컴포넌트 추가
//    	getContentPane().add(imgLabel);
//	}//Image
	
	
	
		
	
	

