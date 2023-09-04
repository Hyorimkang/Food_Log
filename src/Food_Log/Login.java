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
	private JButton btnBack;
	
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
		btnBack();
		
		setVisible(true);
	}
	
	public void lblLogin() {
		lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(370, 100, 200, 80);
		lblLogin.setBounds(350, 100, 200, 80);
		lblLogin.setFont(new Font("땅스부대찌개 Bold", Font.BOLD, 40));
		jp.add(lblLogin);
		add(jp);
	}
	
	//로그인 버튼
	public void btnLogin() {
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(330, 400, 200, 50);
		btnLogin.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		jp.add(btnLogin);
		add(jp);	
	}
	
	//아이디 입력
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
	
	//비밀번호 입력
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
	
	//뒤로가기 버튼
	public void btnBack() {
		btnBack = new JButton();
		btnBack.setBounds(20,20,40,40);
		jp.add(btnBack);
		add(jp);
	}
		
	
}