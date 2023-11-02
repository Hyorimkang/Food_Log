package Food_Log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private static JPanel panel;
	private static JPanel p_list;
	private static JButton btnDelete;
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
        Vector<String> data = new Vector<String>();
        for (int i = 0; i < 100; i++) {
            data.add("test"+i);
        }

        // JList 생성
        list = new JList<>(data);
        // 칸 간격 조정
        list.setFixedCellHeight(40);
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
