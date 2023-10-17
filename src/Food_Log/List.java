package Food_Log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class List extends JFrame{
<<<<<<< HEAD
	private static final int VERTICAL_PADDING = 5;
	private JPanel jp;
	private JLabel lblList;
	private DefaultListModel<String> li;
	private JList<String> list;
	private JScrollPane scroll;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnBack;

	private ImageIcon Back = new ImageIcon("./img/BackLogo.png");

	public static void main(String[] args) { 

		private ImageIcon Back = new ImageIcon("./img/Icon_Back.png");

		public static void main(String[] args) {
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


			list = new JList<String>();

			String[] review = {"2022-09-09","2022-10-05"};
			list.setBounds(50, 100, 400, 500);

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
			btnBack.setBounds(20,20,40,40);
			jp.add(btnBack);
			add(jp);

			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Main(); //selectmenu로 가게 만들기
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
							setVisible(false);
						}
					});
				}
			}
=======
	//private static JFrame frame;
	private static JPanel panel;
	private static JButton btnDelete;
	private static JButton btnInsert;
	private static JButton btnBack;
	private static ImageIcon Back =new ImageIcon("./img/Icon_Back.png");
	private static JLabel title;
	private static JList<String> list;
	private static JScrollPane scrollPane;
	
	public static void main(String[] args) {
		new List();
	}
	
	public List() {
		setTitle("맛집 리스트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setLocationRelativeTo(null);
        
        //삭제버튼
        btnDelete = new JButton("삭제");
		btnDelete.setBounds(330,500,200,50);
		btnDelete.setBackground(Color.white);
		btnDelete.setFont(new Font("EF_watermelonSalad", Font.PLAIN, 25));
		add(btnDelete);
		
		//뒤로가기
		btnBack = new JButton(Back);
		btnBack.setBounds(20,20,40,40);
		add(btnBack);

        // 제목을 담을 JLabel 생성
        title = new JLabel("나의 맛집 리스트");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 50));
        title.setBounds(250, 30, 500, 100);

        // JList에 표시할 데이터 생성
        Vector<String> data = new Vector<String>();
        for (int i = 0; i < 100; i++) {
            data.add("test"+i);
        }

        // JList 생성
        list = new JList<>(data);

        // JScrollPane 생성 및 JList를 JScrollPane에 추가
        scrollPane = new JScrollPane(list);

        // JPanel을 생성하여 제목과 JScrollPane를 추가
        panel = new JPanel(new BorderLayout());
        
        // 좌우로 10px의 공백을 추가
        panel.setBorder(new EmptyBorder(50, 90, 70, 90));
        
        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // JPanel을 프레임에 추가
        getContentPane().add(panel);

        // 프레임을 표시
        setVisible(true);
        
        btn_set();
    }//main
    
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
			}
		});
    }//btn_set
}
>>>>>>> 7088dcd00adeb36c8498d46986ba735d944057f0
