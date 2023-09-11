package Food_Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HashTag extends JFrame {
	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");

	HashTag() {
		setTitle("해시태그 검색하기");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);

		btnBack();

		setVisible(true);
	}

	//뒤로가기 버튼
	public void btnBack() {
		JButton btnBack = new JButton(Back);
		btnBack.setBounds(20, 20, 70, 70);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);

		add(btnBack);

		// Select로 이동
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Select();
				setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		new HashTag();
	}
}
