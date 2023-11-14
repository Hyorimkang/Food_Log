package Food_Log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame{
	private JLabel loading;
	public static Font main_font = new Font("EF_watermelonSalad", Font.PLAIN, 30);
	private JPanel panel;
	private JPanel bg;
	private JProgressBar loadingbar;
	
	void Loading(){
		setTitle("맛집의 지도");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bg = new JPanel();
		bg.setBounds(0, 0, 900, 600);
		bg.setBackground(Color.white);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(300,200, 300, 200);
		panel.setBackground(Color.white);
		panel.setBorder(new EmptyBorder(230, 0, 200, 0));
		
		loading = new JLabel("로딩중");
		loading.setHorizontalAlignment(JLabel.CENTER);
		loading.setFont(main_font);
		loading.setBounds(380, 200, 200, 50);
		
		loadingbar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		
		panel.add(loading, BorderLayout.NORTH);
		panel.add(loadingbar, BorderLayout.CENTER);
		
		ActionEvent evt = null;
		Loading_bar(evt);
		
		
		bg.add(panel);
		add(bg);
		
		setVisible(true);
	}
	
	void Loading_bar(ActionEvent evt) {
		final SwingWorker<Void, Void> loading = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				for(int i = 0; i<=100; i++) {
					loadingbar.setValue(i);
					
					try {
						Thread.sleep(10);
					}catch(InterruptedException ex) {}
				}
				return null;
			}
		};
		loading.execute();
	}
	
	public static void main(String[] args) {
		new Loading();
	}
}
