package Food_Log;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Delete_list extends JFrame{
	private JTextField store;
	private JButton btnDelete;
	
	public static void main(String[] args) {
		new Delete_list();
	}
	
	public Delete_list() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setTitle("맛집 리스트");
		setLocationRelativeTo(null);
		
		
	}
}
