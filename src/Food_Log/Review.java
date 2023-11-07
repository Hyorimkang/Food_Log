package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Review extends JFrame {	
	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
	private ImageIcon img_star = new ImageIcon("./img/star.png");
	
	private JPanel review;
	private JLabel name;
	private JTextField f_name;
	private JLabel star;
	private JLabel l_star;
	private JLabel address;
	JTextField f_address;
	private JButton btn_address;
	private JLabel tag;
	private JTextField f_tag;
	private JLabel write;
	private JTextArea t_review;
	private JButton btn_submit;

	Review() {
		setTitle("리뷰 작성하기");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		
		review();
		map();
		btnBack();
		
		setVisible(true);
	}
	
	public void review() {
		review = new JPanel();
		review.setBounds(350, 0, 550, 600);
		review.setLayout(null);
		review.setBackground(Color.WHITE);
		
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
		star.setBounds(30, 85, 100, 30);
		star.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		JButton star1 = new JButton("1");
		star1.setBounds(130, 85, 45, 35);
		star1.setBackground(Color.white);
		star1.setFocusPainted(false);
		
		JButton star2 = new JButton("2");
		star2.setBounds(175, 85, 45, 35);
		star2.setBackground(Color.white);
		star2.setFocusPainted(false);
		
		JButton star3 = new JButton("3");
		star3.setBounds(220, 85, 45, 35);
		star3.setBackground(Color.white);
		star3.setFocusPainted(false);
		
		JButton star4 = new JButton("4");
		star4.setBounds(265, 85, 45, 35);
		star4.setBackground(Color.white);
		star4.setFocusPainted(false);
		
		JButton star5 = new JButton("5");
		star5.setBounds(309, 85, 45, 35);
		star5.setBackground(Color.white);
		star5.setFocusPainted(false);
		
		//버튼 이벤트 처리
		star1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setBackground(Color.YELLOW);
                star2.setBackground(Color.white);
                star3.setBackground(Color.white);
                star4.setBackground(Color.white);
                star5.setBackground(Color.white);}
		});
		
		star2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setBackground(Color.white);
                star2.setBackground(Color.YELLOW);
                star3.setBackground(Color.white);
                star4.setBackground(Color.white);
                star5.setBackground(Color.white);}
		});
		
		star3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setBackground(Color.white);
                star2.setBackground(Color.white);
                star3.setBackground(Color.YELLOW);
                star4.setBackground(Color.white);
                star5.setBackground(Color.white);}
		});
		
		star4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setBackground(Color.white);
                star2.setBackground(Color.white);
                star3.setBackground(Color.white);
                star4.setBackground(Color.YELLOW);
                star5.setBackground(Color.white);}
		});
		
		star5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setBackground(Color.white);
                star2.setBackground(Color.white);
                star3.setBackground(Color.white);
                star4.setBackground(Color.white);
                star5.setBackground(Color.YELLOW);}
		});
		
		//주소
		address = new JLabel("주소");
		address.setBounds(30, 130, 300, 50);
		address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		f_address = new JTextField();
		f_address.setBounds(130, 130, 400, 45);
		f_address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		//주소 삽입을 위한 버튼
		btn_address = new JButton("주소 검색");
		btn_address.setBounds(130, 180, 150, 35);
		btn_address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		btn_address.setBackground(Color.white);
		btn_address.setFocusPainted(false);
		btn_address.addActionListener(new NaverMap(null));
		
		//태그
		tag = new JLabel("태그");
		tag.setBounds(30, 230, 100, 50);
		tag.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		f_tag = new JTextField();
		f_tag.setBounds(130, 230, 400, 45);
		f_tag.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		
		//후기 작성
		write = new JLabel("후기");
		write.setBounds(30, 290, 100, 50);
		write.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		t_review = new JTextArea();
		t_review.setBounds(130, 300, 400, 200);
		t_review.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		t_review.setBorder(new LineBorder(Color.BLACK));
		
		//완료 버튼
		btn_submit = new JButton("리뷰 작성 완료");
		btn_submit.setBounds(130, 510, 250, 40);
		btn_submit.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		btn_submit.setBackground(Color.white);
		btn_submit.setFocusPainted(false);
		
		review.add(name);
		review.add(f_name);
		
		review.add(address);
		review.add(star);
		review.add(star1);
		review.add(star2);
		review.add(star3);
		review.add(star4);
		review.add(star5);
		review.add(f_address);
		review.add(btn_address);
		review.add(tag);
		review.add(f_tag);
		review.add(write);
		review.add(t_review);
		review.add(btn_submit);
		add(review);
	}
	
	//지도
	public void map() {
		JPanel map = new JPanel();
		map.setBounds(0,0,350,600);
		
		
		JLabel l_map = new JLabel("지도");
		l_map.setBounds(0, 0, 100, 50);
		l_map.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		map.add(l_map);
		
		add(map);
		
	}

	//뒤로가기 버튼
	public void btnBack() {
		JButton btnBack = new JButton(Back);
		btnBack.setBounds(15, 15, 50, 50);
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
