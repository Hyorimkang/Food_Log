package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Review extends JFrame {	
	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
	private ImageIcon img_star = new ImageIcon("./img/star.png");
	
	private JPanel review;
	private JLabel name;
	private JTextField f_name;
	private JLabel star;
	private JLabel address;
	private JTextField f_address;
	private JLabel tag;
	private JTextField f_tag;
	private JLabel write;
	private JTextArea t_review;

	Review() {
		setTitle("리뷰 작성하기");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		
		review();
		btnBack();
		
		setVisible(true);
	}
	
	public void review() {
		review = new JPanel();
		review.setBounds(350, 0, 550, 600);
		review.setLayout(null);
		
		//식당 이름
		name = new JLabel("식당 이름 ");
		name.setBounds(10, 20, 300, 50);
		name.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		f_name = new JTextField();
		f_name.setBounds(130, 20, 400, 45);
		f_name.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		//식당 사진
		
		//식당 별점
		star = new JLabel("별점");
		star.setBounds(30, 100, 100, 30);
		star.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
//		JPanel sp = new JPanel();
//		sp.setLayout(new GridLayout(1,5));
//		JButton[] star = new JButton[5];
//		//int x = 100;
//		for(int i =0; i<star.length; i++) {
//			star[i].setBounds(100, 100, 50, 50);
//			star[i].setBackground(Color.white);
//			star[i].setFocusPainted(false);
//			star[i].setBorderPainted(false);
//		}
		
		//주소
		address = new JLabel("주소");
		address.setBounds(30, 150, 300, 50);
		address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		f_address = new JTextField();
		f_address.setBounds(130, 150, 400, 45);
		f_address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		//태그
		tag = new JLabel("태그");
		tag.setBounds(30, 200, 100, 50);
		tag.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		f_tag = new JTextField();
		f_tag.setBounds(130, 210, 400, 45);
		f_tag.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		//후기 작성
		write = new JLabel("후기");
		write.setBounds(30, 250, 100, 50);
		write.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		t_review = new JTextArea();
		t_review.setBounds(130, 280, 400, 250);
		t_review.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		review.add(name);
		review.add(f_name);
		review.add(star);
		review.add(address);
		review.add(f_address);
		review.add(tag);
		review.add(f_tag);
		review.add(write);
		review.add(t_review);
		add(review);
	}

	//뒤로가기 버튼
	public void btnBack() {
		JButton btnBack = new JButton(Back);
		btnBack.setBounds(20, 20, 50, 50);
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
		new Review();
	}
}
