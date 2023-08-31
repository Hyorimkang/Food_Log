package Food_Log;

import javax.swing.*;

public class Main extends JFrame {
	Main() {
		setTitle("맛집의 지도");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel main_img = new JLabel(new ImageIcon("./img/MainPage.png"));
		main_img.setBounds(0, 0, 900, 600);
		
		add(main_img);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
