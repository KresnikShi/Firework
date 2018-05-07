package MyHeartWillGoOn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;

public class Descartes extends Thread {
	
	private JFrame frame;
	private int x;
	private int y;
	
	public Descartes(JFrame frame,int x,int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
	}

	public void run() {
		for(int d = 0;d <= 200;d++) {
			paint(frame,x,y,d);
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				
			}
			frame.repaint();
		}
//		frame.repaint();
	}
	
	public void paint(JFrame frame,int x0,int y0,int d) {
		Graphics g = frame.getGraphics();
		for (int theta = 0; theta <= 360; theta++) {
			double r = d * (1 - Math.sin(theta));
			double x = r * Math.cos(theta);
			double y = - r * Math.sin(theta);

			Random rand = new Random();
			float R = (float) (rand.nextFloat() / 2f + 0.5);
			float G = (float) (rand.nextFloat() / 2f + 0.5);
			float B = (float) (rand.nextFloat() / 2f + 0.5);
			Color c = new Color(R, G, B);
	
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(c);
			g2d.fillOval((int) x + x0, (int) y + y0, 5, 5);
//			g2d.rotate(45, x + 300, y + 300);
		}
	}

}
