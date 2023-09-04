package Food_Log;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame{
	private JPanel jp;
	private JLabel lblSignup;
	
	private JLabel lblName;
	private JTextField userName;
	private JLabel lblId;
	private JTextField userId;
	private JLabel lblPw;
	private JPasswordField userPw;
	private JLabel lblPwCheck;
	private JPasswordField userPwCheck;
	
	private JButton btnSignup;
	private JButton btnBack;
	
	public static void main(String[] args) {
		new SignUp();
	}
	
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("회원가입");
		
		jp = new JPanel();
		jp.setSize(900,600);
		jp.setLayout(null);
		jp.setVisible(true);
		
		Signup();
		userName();
		userId();
		userPw();
		userPwCheck();
		btnSignup();
		btnBack();
		
		setVisible(true);
	}
	
	//회원가입 
	public void Signup() {
		lblSignup = new JLabel("회원가입");
		lblSignup.setBounds(350, 50, 200, 50);
		lblSignup.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 40));
		jp.add(lblSignup);
		add(jp);
	}
	
	//이름 
	public void userName() {
		lblName = new JLabel("이름");
		lblName.setBounds(240, 140, 100, 50);
		lblName.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblName);
		add(jp);
		
		userName = new JTextField(14);
		userName.setBounds(380, 140, 250, 50);
		jp.add(userName);
		add(jp);
	}
	
	//아이디
	public void userId() {
		lblId = new JLabel("아이디");
		lblId.setBounds(240, 240, 100, 50);
		lblId.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblId);
		add(jp);
		
		userId = new JTextField(10);
		userId.setBounds(380, 240, 250, 50);
		jp.add(userId);
		add(jp);
	}
	
	//비밀번호
	public void userPw() {
		lblPw = new JLabel("비밀번호");
		lblPw.setBounds(240, 340, 100, 50);
		lblPw.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblPw);
		add(jp);
		
		userPw = new JPasswordField();
		userPw.setBounds(380, 340, 250, 50);
		jp.add(userPw);
		add(jp);
	}
	
	//비밀번호 확인
	public void userPwCheck() {
		lblPwCheck = new JLabel("비밀번호 확인");
		lblPwCheck.setBounds(240, 440, 150, 50);
		lblPwCheck.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		jp.add(lblPwCheck);
		add(jp);
		
		userPwCheck = new JPasswordField();
		userPwCheck.setBounds(380, 440, 250, 50);
		jp.add(userPwCheck);
		add(jp);
	}
	
	//회원가입 버튼
	public void btnSignup() {
		btnSignup = new JButton("회원가입");
		btnSignup.setBounds(700, 500, 150, 50);
		btnSignup.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		jp.add(btnSignup);
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
