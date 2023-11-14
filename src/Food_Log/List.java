package Food_Log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List extends JFrame{
	private static JPanel panel;
	private static JPanel p_list;
	private static JButton btnDelete;
	private static JButton btnBack;
	private static ImageIcon Back =new ImageIcon("./img/Icon_Back.png");
	private static JLabel title;
	private static JList<String> list;
	private static JScrollPane scrollPane;
	private static Vector<String> data = new Vector<String>();
	private static int data_idx = -1;
	private Setting s;
	String user_id;
	private FileReader fr;  // 유저 정보 받아오기
	BufferedReader br;
	PreparedStatement ps;
	ResultSet rs;

	public List() {
		try {
			s = new Setting();
		}catch(Exception e) {
			System.out.println(e.toString());
		}

		setTitle("맛집 리스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setLocationRelativeTo(null);

		try {
			fr = new FileReader(Login.userInfo);
			br = new BufferedReader(fr);
			user_id = br.readLine();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		// 배경 패널
		panel = new JPanel();
		panel.setBounds(0, 0, 900, 600);
		panel.setBackground(Color.white);

		//삭제버튼
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(330,490,200,50);
		btnDelete.setBackground(Color.white);
		btnDelete.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		add(btnDelete);

		//뒤로가기
		btnBack = new JButton(Back);
		btnBack.setBounds(15, 15, 50, 50);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		// 제목을 담을 JLabel 생성
		title = new JLabel("나의 맛집 리스트");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 50));
		title.setBackground(Color.white);
		title.setOpaque(true); //투명하게
		title.setBounds(250, 30, 500, 100);

		// JList에 표시할 데이터 생성
		list_DB();

		// JList 생성
		create_list();

		// 위치 조정
		panel.setBorder(new EmptyBorder(50, 0, 70, 0));

		// JScrollPane 생성 및 JList를 JScrollPane에 추가
		scrollPane = new JScrollPane(list);
		// 크기 조정
		scrollPane.setPreferredSize(new Dimension(550,350));

		// JPanel을 생성하여 제목과 JScrollPane를 추가
		p_list = new JPanel(new BorderLayout());

		p_list.add(title, BorderLayout.NORTH);
		p_list.add(scrollPane, BorderLayout.CENTER);

		// 화면 추가
		panel.add(p_list);
		add(panel);

		// 프레임을 표시
		setVisible(true);

		btn_set();
	}//main

	// 리스트 생성 메소드
	public void create_list() {
		list = new JList<>(data);
		// 칸 간격 조정
		list.setFixedCellHeight(40);
		list.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

		list.addListSelectionListener(new ListSelectionListener() {  // 리스트 선택 이벤트
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					create_food_page();
				}
			}
		});
	}

	public void create_food_page() {
		
	}

	// 맛집 정보 받아오기 메소드
	public void list_DB() {
		try {
			String sql;

			sql = "SELECT food_name, food_star FROM food_log.food_list WHERE user_id = '" + user_id + "'";
			ps = s.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				data.add(rs.getString("food_name") + "  (★" + rs.getString("food_star") + ")");
			}
			System.out.println("DB 호출 성공");

		}catch(Exception e) {
			System.out.println("DB 호출 실패 : " + e.toString());
		}
	}

	public void btn_set() {
		//삭제
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 삭제하는 쿼리문
				
			}
		});    	

		//뒤로가기
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Select();
				setVisible(false);
				data.clear();  // 리스트 보기 재클릭시 생기는 중복 리스트 버그 방지
			}
		});
	}//btn_set

	public static void main(String[] args) {
		try {
			new List();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}