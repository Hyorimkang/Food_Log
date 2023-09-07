package Food_Log;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class List extends JFrame{
	private JPanel jp;
	private JLabel lblList;
	private JList<String> list;
	private JButton btnBack;
	
	private ImageIcon Back = new ImageIcon("./img/BackLogo.png");
	
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
		list = new JList<String>();
		
		String[] review = {"2022-09-09","2022-10-05"};
		list.setBounds(50, 100, 400, 500);
		
		jp.add(list);
		add(jp);	
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
					setVisible(false);
				}
			});
		}
}
