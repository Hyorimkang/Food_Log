package Food_Log;

import javax.swing.JFrame;

public interface initialize{
	public default void initialize() {
		JFrame jf = new JFrame();
		jf.setTitle("Login");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(900,600);
		jf.setVisible(true);
		jf.getContentPane().setLayout(null);
	}
}
