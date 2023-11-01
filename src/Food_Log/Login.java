package Food_Log;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
	
	public static void main(String[] args) {
		new Login();
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("로그인");
		setLocationRelativeTo(null);
		
		jp = new JPanel();
		jp.setSize(900,600);
		jp.setLayout(null);
		jp.setVisible(true);
		jp.setBackground(Color.white);
		
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
		btnLogin.setBackground(Color.white);
		btnLogin.setFocusPainted(false);
		btnLogin.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		jp.add(btnLogin);
		add(jp);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String u_id = userId.getText();
				String u_pw = userPw.getText();
				
				try {
					Setting s = new Setting();
					String sql = "SELECT user_pw FROM user_info where user_id = ?";
					s.pstmt = s.conn.prepareStatement(sql);
					s.pstmt.setString(1, u_id);
					ResultSet rs = s.pstmt.executeQuery();
					if(rs.next()) {
						if(rs.getString(1).equals(u_pw)) {
							JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인", JOptionPane.INFORMATION_MESSAGE);
						}
					}
//					sql = "SELECT * FROM user_info where user_pw = " + u_pw;
//					ResultSet pw = s.stmt.executeQuery(sql);
//					
//					if(u_id.equals(id)&&u_pw.equals(pw)) {
//						JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인", JOptionPane.INFORMATION_MESSAGE);
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인", JOptionPane.INFORMATION_MESSAGE);
//					}
					
					
				}catch(Exception e1) {
					System.out.println("데이터 조회 실패 이유 : " + e1.toString());
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인", JOptionPane.INFORMATION_MESSAGE);
				}
				new Select();
				setVisible(false);
			}
		});
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
		btnBack = new JButton(Back);
		btnBack.setBounds(20,20,70, 70);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		jp.add(btnBack);
		add(jp);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				setVisible(false);
			}
		});
	}
		
	
}