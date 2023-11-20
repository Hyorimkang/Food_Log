package Food_Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HashTag extends JFrame {
	private static JPanel panel;
	private static JPanel p_list;
	private static JButton btnBack;
	private static ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
	private static JLabel title;
	private static JPanel p_search;
	private static JButton btn_search;
	private static JTextField search;
	private static JList<String> list;
	private static Vector<String> data;
	private static DefaultListModel<String> listModel;
	private static JScrollPane scrollPane;
	private static JButton btnInfo;
	private static Vector<Integer> data_no = new Vector<>();
	private static int data_idx = -1;
	private static String hashText = "";
	private static List_data l;

	// 해시태그 검색하기
	HashTag() {
		setTitle("해시태그 검색하기");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);

		list();

		setVisible(true);
	}

	public void list() {
		// 배경 패널
		panel = new JPanel();
		panel.setBounds(0, 0, 900, 600);
		panel.setBackground(Color.white);

		// 뒤로가기 버튼
		btnBack();

		// 제목을 담을 JLabel 생성
		title = new JLabel("태그 검색");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 40));
		title.setBackground(Color.white);
		title.setOpaque(true); //투명하게

		//검색창
		String searchText = "검색할 태그를 입력하세요\t";  // \t로 검색바 크기 조정
		p_search = new JPanel();
		p_search.setBounds(175, 115, 550, 40);
		p_search.setBackground(Color.WHITE);

		search = new JTextField(searchText);
		search.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 30));

		// 검색창 클릭 시 "검색할 태그를 입력하세요" 글씨 제거
		search.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(search.getText().equals("#")) {
					search.setText(searchText);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(search.getText().equals(searchText)) {
					search.setText("#");
				}
			}
		});

		btn_search = new JButton("검색");
		btn_search.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 30));
		btn_search.setBounds(700, 115, 50, 40);
		btn_search.setBackground(Color.white);
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					hashText = search.getText();
					l = new List_data();
					String sql = "SELECT * FROM food_log." + l.user_id + " WHERE food_hash LIKE '%" + hashText + "%'";
					new List_data(sql);
					data.clear();
					while(l.rs.next()) {
						data.add(l.getFoodName() + "  |  " + l.getFoodHash());
						data_no.add(l.getFoodNo());
					}
					updateList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p_search.add(search);
		p_search.add(btn_search);

		// JList에 표시할 데이터 생성
		data = new Vector<String>();
		listDB();

		// 리스트 생성
		createList();

		// 위치 조정
		panel.setBorder(new EmptyBorder(60, 0, 70, 0));

		// JScrollPane 생성 및 JList를 JScrollPane에 추가
		scrollPane = new JScrollPane(list);
		// 크기 조정
		scrollPane.setPreferredSize(new Dimension(550,300));

		// JPanel을 생성하여 제목과 JScrollPane를 추가
		p_list = new JPanel(new BorderLayout());

		p_list.add(title, BorderLayout.NORTH);
		p_list.add(p_search, BorderLayout.CENTER);
		p_list.add(scrollPane, BorderLayout.SOUTH);

		// 보기 버튼
		btnInfo = new JButton("보기");
		btnInfo.setBounds(350, 480, 200, 50);
		btnInfo.setBackground(Color.WHITE);
		btnInfo.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		infoSet();
		add(btnInfo);

		// 화면 추가
		panel.add(p_list);
		add(panel);

		// 프레임을 표시
		setVisible(true);
	}

	public void infoSet() {
		btnInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				create_food_info();
			}
		});
	}

	// 맛집 정보
	public static void create_food_info() {
		try {
			String sql = "SELECT * FROM food_log.`" + l.user_id + "` WHERE food_no = " + data_no.get(data_idx);
			new List_data(sql);
			if(l.rs.next()) {
				String food_name = l.getFoodName();
				String food_place = l.getFoodPlace();
				String food_time = l.getFoodTime();
				String food_star = String.valueOf(l.getFoodStar());
				String food_hash = l.getFoodHash();
				String food_write = l.getFoodWrite();

				JFrame f_page = new JFrame();
				JLabel f_name, f_star, f_address, f_time;
				JTextArea f_hash, f_write;
				f_page.setSize(500, 450);
				f_page.setResizable(false);
				f_page.setLocationRelativeTo(null);
				f_page.setLayout(null);
				f_page.getContentPane().setBackground(Color.WHITE);

				// 식당 이름
				f_name = new JLabel(food_name);
				f_name.setBounds(0, 10, 485, 50);
				f_name.setHorizontalAlignment(JLabel.CENTER);  // 가운데 정렬
				f_name.setFont(new Font("EF_watermelonSalad", Font.BOLD, 25));

				// 별점
				f_star = new JLabel("★ (5/" + food_star + ")");
				f_star.setBounds(10, 50, 100, 50);
				f_star.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 15));

				// 해시태그
				f_hash = new JTextArea(food_hash);
				f_hash.setBounds(10, 100, 450, 50);
				f_hash.setEditable(false);  // 수정 불가능하게 설정
				f_hash.setLineWrap(true);  // 자동 줄 바꿈 설정
				f_hash.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

				// 주소
				f_address = new JLabel("주소 : \n" + food_place);
				f_address.setBounds(10, 150, 450, 50);
				f_address.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

				f_write = new JTextArea("<후기>\n" + food_write);
				f_write.setBounds(10, 230, 450, 300);
				f_write.setEditable(false);
				f_write.setLineWrap(true);
				f_write.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

				f_time = new JLabel("작성 날짜: " + food_time);
				f_time.setBounds(340, 360, 200, 70);
				f_time.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 13));

				f_page.setVisible(true);

				f_page.add(f_name);
				f_page.add(f_star);
				f_page.add(f_time);
				f_page.add(f_hash);
				f_page.add(f_address);
				f_page.add(f_write);

				l.fr.close();
				l.br.close();
			} else {
				JOptionPane.showMessageDialog(null, "해당 맛집 정보를 불러올 수 없습니다.", "error", JOptionPane.ERROR_MESSAGE);
				System.out.println("해당 맛집 정보를 찾을 수 없습니다.");
			}
		}catch(Exception e) {
			System.out.println("페이지 호출 실패: " + e.toString());
			e.printStackTrace();
		}
	}

	// 리스트 생성 메소드
	public void createList() {
		// JList 생성
		listModel = new DefaultListModel<>();  // 실시간으로 검색 결과 출력해줄 ListModel
		list = new JList<>(listModel);

		// 칸 간격 조정
		list.setFixedCellHeight(40);
		list.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

		list.addListSelectionListener(new ListSelectionListener() {  // 리스트 선택 이벤트
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				data_idx = list.getSelectedIndex();
			}
		});
	}

	public void updateList() {
		listModel.clear();
		for(String i : data) {
			listModel.addElement(i);
		}
	}

	public void listDB() {
		try {
			List_data l = new List_data();
			while(l.rs.next()) {
				data.add(l.getFoodName() + "  |  " + l.getFoodHash());
				listModel.add(l.getFoodNo(), l.getFoodName());
				System.out.println(listModel.get(l.getFoodNo()));
			}
			System.out.println("DB 호출 성공");
		}catch(Exception e) {

		}
	}

	// 뒤로가기 버튼
	public void btnBack() {
		btnBack = new JButton(Back);
		btnBack.setBounds(15, 15, 50, 50);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Select();
				setVisible(false);
				data.clear();  // 리스트 재생성 방지
			}
		});

		add(btnBack);
	}

	public static void main(String[] args) {
		new HashTag();
	}
}
