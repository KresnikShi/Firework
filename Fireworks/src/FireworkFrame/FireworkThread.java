package FireworkFrame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class FireworkThread extends Thread {

	private int x;
	private int y;
	private JFrame frame;
	
	static private int v = 1;   // speed
	static private int width = 10;
	static private int height = 20;
	static private int nums = 100;
	
	public FireworkThread(int x,int y,JFrame frame) {
		this.x = x;
		this.y = y;
		this.frame = frame;
	}
			
	public void run() {
		// before exploring
		for(int i = frame.getHeight();i >= y ;i -= v) {
			paint(frame.getGraphics(),x,i);
			frame.repaint();
			try {
				Thread.sleep(5);
			} catch(Exception e) {
				
			}
		}
		
		// explore
		for(int j = 1;j <= nums;j += v) {
//			Random rand = new Random();
//			int xchange = rand.nextInt(x+200)+(x-200);
//			int ychange = rand.nextInt(y+200)+(y-200);
			
//			while(Math.sqrt(Math.pow(xchange-x, 2)+Math.pow(ychange-y, 2))>200) {
//				ychange = rand.nextInt(y+200)+(y-200);
//			}
//			OneFirework onefire = new OneFirework(x,y,xchange,ychange,frame);
			OneFirework onefire = new OneFirework(x,y,360/nums*j,frame);
			onefire.start();
			frame.repaint();
			try {
				Thread.sleep(20);
			} catch(Exception e) {
				
			}
		}
		
		frame.repaint();
		try {
			Thread.sleep(20);
		} catch(Exception e) {
			
		}
	}
	
	public void paint(Graphics g,int x,int y) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
	
}
