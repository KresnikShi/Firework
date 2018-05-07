package MyHeartWillGoOn;

import java.awt.Color;

import javax.swing.JFrame;

public class HeartFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private HeartClickListener cl = new HeartClickListener(this);
	
	public void initFrame() {
		this.setTitle("My heart will go on");
		this.setSize(1200, 1200);
		this.getContentPane().setBackground(Color.black);
		this.addMouseListener(cl);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeartFrame hf = new HeartFrame();
		hf.initFrame();
	}

}
