package FireworkFrame;

import java.awt.*;

import javax.swing.*;

/**
 * Do you want to see fireworks?
 * Created on 2017-07-23
 * @author SHIJun
 *
 */
public class Fireworks extends JFrame {
	private static final long serialVersionUID = 1L;
	ClickListener cl = new ClickListener(this);

	public void initFrame() {
		this.setTitle("花火大会");
		this.setSize(1200, 1200);
		this.getContentPane().setBackground(Color.black);
		this.addMouseListener(cl);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	// main function
	public static void main(String args[]) {
		Fireworks fireworks = new Fireworks();
		fireworks.initFrame();
	}

}