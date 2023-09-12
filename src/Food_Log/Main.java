package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame {
	static JFrame frame = new JFrame();
	static ImageIcon LogIn = new ImageIcon("./img/Main_LoginBtn.png");
	static ImageIcon SignUp = new ImageIcon("./img/Main_SignupBtn.png");
	public static Font main_font = new Font("땅스부대찌개 Bold", Font.BOLD, 95);
	Main() {
		frame.setTitle("맛집의 지도");
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 배경화면
		JLabel main_img = new JLabel(new ImageIcon("./img/Main_Page.png")); 
		main_img.setBounds(0, 0, 900, 600);

		// 제목
		JLabel title = new JLabel("맛집의 지도");
		title.setFont(main_font);
		title.setBounds(150, 110, 550, 120);
		
		LogIn();
		SignUp();
		frame.add(title);
		frame.add(main_img);
		
		frame.setVisible(true);
	}
	
	// 로그인 버튼
	static void LogIn() {
		JButton login_btn = new JButton(LogIn);
		login_btn.setBounds(124, 260, 646, 110);
		login_btn.setFont(new Font("EF_watermelonSalad", Font.BOLD, 40));
		login_btn.setBackground(Color.white);
		login_btn.setFocusPainted(false);
		login_btn.setBorderPainted(false);
		
		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		
		frame.add(login_btn);
	}
	
	// 회원가입 버튼
	static void SignUp() {
		JButton signup_btn = new JButton(SignUp);
		signup_btn.setBounds(124, 380, 646, 110);
		signup_btn.setFont(new Font("EF_watermelonSalad", Font.BOLD, 40));
		signup_btn.setBackground(Color.white);
		signup_btn.setFocusPainted(false);
		signup_btn.setBorderPainted(false);

		signup_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				frame.setVisible(false);
			}
		});
		
		frame.add(signup_btn);		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}

