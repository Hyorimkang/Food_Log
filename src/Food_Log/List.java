package Food_Log;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class List {
	
    public static void main(String[] args) {
    	 // JFrame 생성
        JFrame frame = new JFrame("맛집 리스트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        
        //삭제버튼
        JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(300,500,100,50);
		frame.add(btnDelete);
		
		//삽입버튼
		JButton btnInsert = new JButton();
		btnInsert.setBounds(450,500,100,50);
		frame.add(btnInsert);
		
		//뒤로가기
		ImageIcon Back = new ImageIcon("./img/Icon_Back.png");
		JButton btnBack = new JButton(Back);
		btnBack.setBounds(20,20,40,40);
		frame.add(btnBack);

        // 제목을 담을 JLabel 생성
        JLabel title = new JLabel("나의 맛집 리스트");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("땅스부대찌개 Bold", Font.PLAIN, 50));
        title.setBounds(250, 30, 500, 100);

        // JList에 표시할 데이터 생성
        Vector<String> data = new Vector<String>();
        for (int i = 0; i < 100; i++) {
            data.add("test"+i);
        }

        // JList 생성
        JList<String> list = new JList<>(data);

        // JScrollPane 생성 및 JList를 JScrollPane에 추가
        JScrollPane scrollPane = new JScrollPane(list);

        // JPanel을 생성하여 제목과 JScrollPane를 추가
        JPanel panel = new JPanel(new BorderLayout());
        
        // 좌우로 10px의 공백을 추가
        panel.setBorder(new EmptyBorder(50, 90, 70, 90));
        
        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // JPanel을 프레임에 추가
        frame.getContentPane().add(panel);

        // 프레임을 표시
        frame.setVisible(true);
    }
}
