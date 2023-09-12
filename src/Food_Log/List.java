package Food_Log;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class List extends JFrame{
	private static final int VERTICAL_PADDING = 5;
	private JPanel jp;
	private JLabel lblList;
	private DefaultListModel<String> li;
	private JList<String> list;
	private JScrollPane scroll;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnBack;
<<<<<<< HEAD
	
	private ImageIcon Back = new ImageIcon("./img/BackLogo.png");
	
	public static void main(String[] args) { 
=======

	private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");

	public static void main(String[] args) {
>>>>>>> 090d3c13e8a21b26b53398f1a6c31502bcaad5a7
		new List();
	}

	public List() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("맛집 리스트");
		setLocationRelativeTo(null);

		jp = new JPanel();
		jp.setSize(900,600);
		jp.setLayout(null);
		jp.setVisible(true);
		jp.setBackground(Color.white);

		List_txt();
		List();
		btnBack();

		setVisible(true);
	}

	//리스트 제목 텍스트
	public void List_txt() {
		lblList = new JLabel("나의 맛집 리스트");
		lblList.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 50));
		lblList.setBounds(250, 30, 500, 100);
		jp.add(lblList);
		add(jp);
	}

	//리스트 생성
	public void List() {
<<<<<<< HEAD
		li = new DefaultListModel<String>();
		for(int i = 0; i<20; i++) { //table사이즈까지 반복하기
			li.addElement("테스트");  //쿼리문 작성
		}
		
		list = new JList<String>(li);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //list 값 중 하나만 선택되도록
		list.setBounds(140, 120, 600, 400);
		
		Border outline = BorderFactory.createLineBorder(Color.black,2); //테두리
		list.setBorder(outline);
		
		list.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 20));
		JLabel l = new JLabel();
		
		//스크롤바 : 나오게하기
		list.setVisibleRowCount(10);
		scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(500, 600));
		
		
=======
		list = new JList<String>();

		String[] review = {"2022-09-09","2022-10-05"};
		list.setBounds(50, 100, 400, 500);

>>>>>>> 090d3c13e8a21b26b53398f1a6c31502bcaad5a7
		jp.add(list);
		jp.add(scroll);
		
		add(jp);
		
	}
	
	//삭제 버튼
	public void btnDelete() {
		btnDelete = new JButton();
		btnDelete.setBounds(700,250,100,50);
		jp.add(btnDelete);
		add(jp);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Delete_list();			
			}
		});
	}
	
	//삽입 버튼
	public void btnInsert() {
		btnInsert = new JButton();
		btnInsert.setBounds(700,200,100,50);
		jp.add(btnInsert);
		add(jp);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//후기추가로 가게 만들기
				setVisible(false);
				
			}
		});
	}



	//뒤로가기 버튼
	public void btnBack() {
		btnBack = new JButton(Back);
<<<<<<< HEAD
		btnBack.setBounds(20,20,40,40);
		jp.add(btnBack);
		add(jp);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main(); //selectmenu로 가게 만들기
=======
		btnBack.setBounds(20, 20, 70, 70);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);

		jp.add(btnBack);
		add(jp);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Select(); //selectmenu로 가게 만들기
>>>>>>> 090d3c13e8a21b26b53398f1a6c31502bcaad5a7
				setVisible(false);
			}
		});
	}
}
