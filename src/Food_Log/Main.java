package Food_Log;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Main extends JFrame {
	private ImageIcon LogIn = new ImageIcon("./img/Main_LoginBtn.png");
	private ImageIcon SignUp = new ImageIcon("./img/Main_SignupBtn.png");
	Main() {
		setTitle("맛집의 지도");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이미지
		JLabel main_img = new JLabel(new ImageIcon("./img/Main_Page.png")); 
		main_img.setBounds(0, 0, 900, 600);

		// 버튼
		JButton login_btn = new JButton(LogIn);
		login_btn.setBounds(124, 260, 646, 110);
		login_btn.setFont(new Font("EF_watermelonSalad", Font.BOLD, 40));
		login_btn.setBackground(Color.white);
		login_btn.setFocusPainted(false);
		login_btn.setBorderPainted(false);
		
		JButton signup_btn = new JButton(SignUp);
		signup_btn.setBounds(124, 380, 646, 110);
		signup_btn.setFont(new Font("EF_watermelonSalad", Font.BOLD, 40));
		signup_btn.setBackground(Color.white);
		signup_btn.setFocusPainted(false);
		signup_btn.setBorderPainted(false);
		
		// 제목
		JLabel title = new JLabel("맛집의 지도");
		title.setBounds(150, 110, 550, 120);
		title.setFont(new Font("땅스부대찌개 Bold", Font.BOLD, 95));
		
		add(title);
		add(login_btn);
		add(signup_btn);
		add(main_img);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
