package Food_Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Select extends JFrame {
	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
	private ImageIcon review = new ImageIcon("./img/Select_Review.png");
	private ImageIcon list = new ImageIcon("./img/Select_List.png");
	private ImageIcon search = new ImageIcon("./img/Select_Search.png");
	private ImageIcon back_btn = new ImageIcon("./img/Icon_Back.png");
	private Font select_font = new Font("EF_watermelonSalad", Font.PLAIN, 26);

	Select() {
		setTitle("맛집의 지도");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);

		// 제목
		JLabel title = new JLabel("맛집의 지도");
		title.setFont(Main.main_font);
		title.setBounds(200, 80, 550, 120);

		add(title);
		WriteReview();
		ViewList();
		SearchHashTag();
<<<<<<< HEAD

		btnBack();

=======



>>>>>>> ba5e4cead3780ee79aa110bf198fa9abeeadcfbe
		setVisible(true);
	}

	// 리뷰 작성하기
	public void WriteReview() {

		// 리뷰 작성하기 버튼
		JButton review_btn = new JButton(review);
		review_btn.setBounds(100, 250, 166, 166);
		review_btn.setBackground(Color.white);
		review_btn.setFocusPainted(false);
		review_btn.setBorderPainted(false);

		// 리뷰 작성 페이지로 이동
		review_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Review();
				setVisible(false);
			}
		});

		// 리뷰 작성하기 라벨
		JLabel jl_review = new JLabel("리뷰 작성하기");
		jl_review.setBounds(100, 400, 166, 100);
		jl_review.setFont(select_font);

		add(review_btn);
		add(jl_review);
	}

	// 리스트 보기
	public void ViewList() {
		// 리스트 보기 버튼
		JButton list_btn = new JButton(list);
		list_btn.setBounds(365, 250, 166, 166);
		list_btn.setBackground(Color.white);
		list_btn.setFocusPainted(false);
		list_btn.setBorderPainted(false);

		// 리뷰 작성 페이지로 이동
		list_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new List();
				setVisible(false);
			}
		});

		// 리스트 보기 라벨
		JLabel jl_list = new JLabel("리스트 보기");
		jl_list.setFont(select_font);
		jl_list.setBounds(380, 400, 166, 100);

		add(list_btn);
		add(jl_list);
	}

	// 해시태그 검색하기
	public void SearchHashTag() {
		// 해시태그 검색하기 버튼
		JButton search_btn = new JButton(search);
		search_btn.setBounds(620, 250, 166, 166);
		search_btn.setBackground(Color.white);
		search_btn.setFocusPainted(false);
		search_btn.setBorderPainted(false);

		// 해시태그 검색하기 라벨
		JLabel jl_search = new JLabel("해시태그 검색하기");
		jl_search.setFont(select_font);
		jl_search.setBounds(600, 400, 230, 100);

<<<<<<< HEAD
		// 해시태그 검색 페이지로 이동
		search_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HashTag();
				setVisible(false);
			}
		});

		add(search_btn);
=======
		add(search_img);
>>>>>>> ba5e4cead3780ee79aa110bf198fa9abeeadcfbe
		add(jl_search);
	}

	//뒤로가기 버튼
	public void btnBack() {
		JButton btnBack = new JButton(Back);
		btnBack.setBounds(20, 20, 70, 70);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);

		add(btnBack);
<<<<<<< HEAD

=======
		
>>>>>>> ba5e4cead3780ee79aa110bf198fa9abeeadcfbe
		// 메인화면으로 이동
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
