package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	private int star_idx;

	Review() {
		setTitle("리뷰 작성하기");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);

		btnBack();
		review();
		map();

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

		JButton[] stars = new JButton[5];

		int bounds_x = 130;
		for(int i = 0; i < stars.length; i++) {
			stars[i] = new JButton(String.valueOf(i + 1));
			stars[i].setBounds(bounds_x, 85, 45, 35);
			bounds_x += 44;
			stars[i].setBackground(Color.white);
			stars[i].setFocusPainted(false);
		}

		for(int i = 0; i < stars.length; i++) {
			final int idx = i;
			stars[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// 모든 별점 버튼을 흰색으로
					for (JButton star : stars) {
						star.setBackground(Color.white);
					}

					// 선택한 별점 버튼까지 노란색으로
					for (int j = 0; j <= idx ; j++) {
						stars[j].setBackground(Color.yellow);
						star_idx = idx;
					}
				}
			});
		}


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
		btn_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Create_Table_food_list();
					String user_id;
					String food_name = f_name.getText();
					String food_place = f_address.getText();
					String food_time = LocalDate.now().toString();
					int food_star = star_idx + 1;  // 인덱스 + 1
					String food_hash = f_tag.getText();
					String food_write = t_review.getText();
					String sql;
					
					// File에 아이디 저장
					FileReader fr = new FileReader(Login.userInfo);
					BufferedReader br = new BufferedReader(fr);
					user_id = br.readLine();
					
					sql = "INSERT INTO " + Setting.db_name + "." + Create_Table_food_list.table_name + "("
							+ "user_id, food_name, food_place, food_time, food_star, food_hash, food_write) values("
							+ "'" + user_id + "','" + food_name + "','" + food_place + "','" + food_time + "','" + food_star + "',"
							+ "'" + food_hash + "','" + food_write + "')";

					Setting.stmt.execute(sql);
					System.out.println("리뷰 작성 성공");
					JOptionPane.showMessageDialog(null, "리뷰 작성 완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
					new Review();
					setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "리뷰 작성 실패", "메세지", JOptionPane.ERROR_MESSAGE);
					System.out.println("리뷰 작성 실패 : " + e1.toString());
					e1.printStackTrace();
				}
			}
		});

		review.add(name);
		review.add(f_name);

		review.add(address);
		review.add(star);
		for(int i = 0; i < stars.length; i++)
			review.add(stars[i]);
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
