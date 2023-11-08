package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
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
	private JButton btn_pwCheck;
	private JButton btn_idCheck;

	private JButton btnSignup;
	private JButton btnBack;

	private boolean checkId = false, checkPass = false;

	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");

	private Setting s;

	public static void main(String[] args) {
		try {
			new SignUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SignUp() throws Exception {
		s = new Setting();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("회원가입");
		setLocationRelativeTo(null);

		jp = new JPanel();
		jp.setSize(900,600);
		jp.setLayout(null);
		jp.setVisible(true);
		jp.setBackground(Color.white);


		Signup();
		userName();
		userId();
		btn_idCheck();
		userPw();
		userPwCheck();
		btn_pwCheck();
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

	// 아이디 중복확인 버튼
	public void btn_idCheck() {
		btn_idCheck = new JButton("중복확인");
		btn_idCheck.setBounds(650, 250, 100, 30);
		btn_idCheck.setBackground(Color.white);
		btn_idCheck.setFocusPainted(false);
		btn_idCheck.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 15));
		jp.add(btn_idCheck);
		add(jp);

		btn_idCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Create_Table_user_info info = new Create_Table_user_info();
					String u_id = userId.getText();
					String sql = "SELECT EXISTS (SELECT * FROM " + info.schema_name + "." + info.table_name
							+ " WHERE user_id = ?)";
					PreparedStatement ps = info.conn.prepareStatement(sql);
					ps.setString(1, u_id);

					ResultSet rs = ps.executeQuery();

					if(rs.next()) {
						int exists = rs.getInt(1);
						if(exists == 1) {
							JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다.", "알림", JOptionPane.ERROR_MESSAGE);
							checkId = false;
						}
						else if(exists == 0) {
							JOptionPane.showMessageDialog(null, "아이디를 사용할 수 있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
							checkId = true;
						}
					}

				} catch (Exception e1) {
					System.out.println("데이터 조회 실패 이유 : " + e1.toString());
				}
			}
		});
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

	//비밀번호 확인 버튼
	public void btn_pwCheck() {
		btn_pwCheck = new JButton("확인");
		btn_pwCheck.setBounds(650, 450, 70, 30);
		btn_pwCheck.setBackground(Color.white);
		btn_pwCheck.setFocusPainted(false);
		btn_pwCheck.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 15));
		jp.add(btn_pwCheck);
		add(jp);

		btn_pwCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String u_pw = userPw.getText();
				String u_pwcheck = userPwCheck.getText();

				//비밀번호 확인
				if(u_pw.equals(u_pwcheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.", "비밀번호 확인", JOptionPane.INFORMATION_MESSAGE);
					checkPass = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호가 불일치합니다.", "비밀번호 확인", JOptionPane.ERROR_MESSAGE);
					checkPass = false;
				}
			}
		});
	}

	//회원가입 버튼
	public void btnSignup() {
		btnSignup = new JButton("회원가입");
		btnSignup.setBounds(700, 500, 150, 50);
		btnSignup.setBackground(Color.white);
		btnSignup.setFocusPainted(false);
		btnSignup.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		jp.add(btnSignup);
		add(jp);

		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//문자화
				String u_name = userName.getText();
				String u_id = userId.getText();
				String u_pw = userPw.getText();

				try {
					if(checkId == true && checkPass == true) {
						//삽입 쿼리문
						String sql = "INSERT INTO user_info(user_name, user_id, user_pw) values('" + u_name + "','" + u_id + "','" + u_pw + "')";
						s.stmt.execute(sql);
						JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입 확인", JOptionPane.INFORMATION_MESSAGE);
						new Login();
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인해주십시오.", "회원가입 확인", JOptionPane.ERROR_MESSAGE);
					}

				}catch(Exception e1) {
					System.out.println("데이터 조회 실패 이유 : " + e1.toString());
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입 확인", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
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
