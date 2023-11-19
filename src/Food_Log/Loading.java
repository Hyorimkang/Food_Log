package Food_Log;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Loading implements ActionListener {
	Review r;
	public Loading(Review Loading) {
		this.r = Loading;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		final SwingWorker<Void, Void> loading = new SwingWorker<Void, Void>() {
			
			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				for(int i = 0; i<=100; i++) {
					r.loadingbar.setValue(i);
					try {
						Thread.sleep(5);
					}catch(InterruptedException ex) {}
				}
				return null;
			}
			
			@Override
			protected void done() {
                // 작업이 완료된 후에 EDT에서 실행되도록 SwingUtilities.invokeLater 사용
                SwingUtilities.invokeLater(() -> {
                    // NaverMap 동작을 여기에 추가 
                	ActionEvent e = null;
                	NaverMap naverMap = new NaverMap(r, r.f_address.getText());
                    naverMap.actionPerformed(e);
                });
			}
		};
		loading.execute();
	}
	
}
