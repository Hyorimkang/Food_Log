package Food_Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Select extends JFrame {
	static JFrame frame = new JFrame();
	static ImageIcon review = new ImageIcon("./img/Select_Review.png");
	static ImageIcon list = new ImageIcon("./img/Select_List.png");
	static ImageIcon search = new ImageIcon("./img/Select_Search.png");
	static ImageIcon back_btn = new ImageIcon("./img/Icon_Back.png");
	public static Font select_font = new Font("EF_watermelonSalad", Font.PLAIN, 26);

	Select() {
		frame.setTitle("맛집의 지도");
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);

		// 제목
		JLabel title = new JLabel("맛집의 지도");
		title.setFont(Main.main_font);
		title.setBounds(200, 80, 550, 120);

		frame.add(title);
		WriteReview();
		ViewList();
		SearchHashTag();
		btnBack();

		frame.setVisible(true);
	}

	// 리뷰 작성하기
	static void WriteReview() {

		// 리뷰 작성하기 버튼
		JButton review_img = new JButton(review);
		review_img.setBounds(100, 250, 166, 166);
		review_img.setBackground(Color.white);
		review_img.setFocusPainted(false);
		review_img.setBorderPainted(false);

		// 리뷰 작성하기 라벨
		JLabel jl_review = new JLabel("리뷰 작성하기");
		jl_review.setBounds(100, 400, 166, 100);
		jl_review.setFont(select_font);

		frame.add(review_img);
		frame.add(jl_review);
	}

	// 리스트 보기
	static void ViewList() {
		// 리스트 보기 버튼
		JButton list_img = new JButton(list);
		list_img.setBounds(365, 250, 166, 166);
		list_img.setBackground(Color.white);
		list_img.setFocusPainted(false);
		list_img.setBorderPainted(false);

		// 리스트 보기 라벨
		JLabel jl_list = new JLabel("리스트 보기");
		jl_list.setFont(select_font);
		jl_list.setBounds(380, 400, 166, 100);

		frame.add(list_img);
		frame.add(jl_list);
	}

	// 해시태그 검색하기
	static void SearchHashTag() {
		// 해시태그 검색하기 버튼
		JButton search_img = new JButton(search);
		search_img.setBounds(620, 250, 166, 166);
		search_img.setBackground(Color.white);
		search_img.setFocusPainted(false);
		search_img.setBorderPainted(false);

		// 해시태그 검색하기 라벨
		JLabel jl_search = new JLabel("해시태그 검색하기");
		jl_search.setFont(select_font);
		jl_search.setBounds(600, 400, 230, 100);

		frame.add(search_img);
		frame.add(jl_search);
	}
	
	// 뒤로가기 버튼
	public void btnBack() {
		JButton btnBack = new JButton(back_btn);
		btnBack.setBounds(20,20,70, 70);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		
		frame.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		new Select();
	}
}
