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
