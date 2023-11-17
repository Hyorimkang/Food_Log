package Food_Log;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
	private static JScrollPane scrollPane;
	private static int data_idx = 0;

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
		JButton btnBack = new JButton(Back);
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

		// 제목을 담을 JLabel 생성
		title = new JLabel("태그 검색");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 40));
		title.setBackground(Color.white);
		title.setOpaque(true); //투명하게

		//검색창
		String searchText = "검색할 태그를 입력하세요";
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
				if(search.getText().isEmpty()) {
					search.setText(searchText);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(search.getText().equals("검색할 태그를 입력하세요")) {
					search.setText("");
				}
			}
		});

		btn_search = new JButton("검색");
		btn_search.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 30));
		btn_search.setBounds(700, 115, 50, 40);
		btn_search.setBackground(Color.white);

		p_search.add(search);
		p_search.add(btn_search);

		// JList에 표시할 데이터 생성
		data = new Vector<String>();
		list_DB();

		// 리스트 생성
		create_list();
		
		// 위치 조정
		panel.setBorder(new EmptyBorder(60, 0, 70, 0));

		// JScrollPane 생성 및 JList를 JScrollPane에 추가
		scrollPane = new JScrollPane(list);
		// 크기 조정
		scrollPane.setPreferredSize(new Dimension(550,350));

		// JPanel을 생성하여 제목과 JScrollPane를 추가
		p_list = new JPanel(new BorderLayout());

		p_list.add(title, BorderLayout.NORTH);
		p_list.add(p_search, BorderLayout.CENTER);
		p_list.add(scrollPane, BorderLayout.SOUTH);

		// 화면 추가
		add(btnBack);
		panel.add(p_list);
		add(panel);

		// 프레임을 표시
		setVisible(true);
	}
	
	// 리스트 생성 메소드
		public void create_list() {
			// JList 생성
			list = new JList<>(data);
			// 칸 간격 조정
			list.setFixedCellHeight(40);
			list.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));

			list.addListSelectionListener(new ListSelectionListener() {  // 리스트 선택 이벤트
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					data_idx = list.getSelectedIndex() + 1;
				}
			});

		}

	public void list_DB() {
		try {
			List_data l = new List_data();
			while(l.rs.next()) {
				data.add(l.getFoodName() + "  |  " + l.getFoodHash());
			}
			System.out.println("DB 호출 성공");
		}catch(Exception e) {

		}
	}

	public static void main(String[] args) {
		new HashTag();
	}
}
