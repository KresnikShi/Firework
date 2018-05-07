package FireworkFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;

public class OneFirework extends Thread {

	private int x;
	private int y;
	private int xchange;
	private int ychange;
	private int degree;
	private JFrame frame;
	private double vx;
	private double vy;
	private double ratio;
	
	static private int radius = 240;
	static private int width = 10;
	static private int height = 10;
	static private int nums = 30;
	
	public OneFirework(int x,int y,int xchange,int ychange,JFrame frame) {
		this.x = x;
		this.y = y;
		this.xchange = xchange;
		this.ychange = ychange;
		this.frame = frame;
	}
	
	public OneFirework(int x,int y,int degree,JFrame frame) {
		this.x = x;
		this.y = y;
		this.degree = degree;
		this.frame = frame;
	}
	
	public void run() {
		//paintFireworks(frame.getGraphics(),x,y,xchange,ychange);
		paintFireworks(x,y,degree,frame.getGraphics());
	}
	
	// not used
	public void paintFireworks(Graphics g,int x,int y,int xchange,int ychange) {
		Random rand = new Random();
		float R = (float) (rand.nextFloat() / 2f + 0.5);
		float G = (float) (rand.nextFloat() / 2f + 0.5);
		float B = (float) (rand.nextFloat() / 2f + 0.5);
		
		Color c = new Color(R,G,B);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(c);
		g2d.setStroke(new BasicStroke(8f));
		
		ratio = Math.abs(x-xchange)/Math.abs(y-ychange);
		
		vx = ratio;
		vy = 1;
		
		for(int i=0,j=0;i<Math.abs(x-xchange)&&j<Math.abs(y-ychange);i+=vx,j+=vy) {
			if(x < xchange && y < ychange) {
				g2d.fillOval(i+x, j+y, width, height);
			} else if(x > xchange && y < ychange) {
				g2d.fillOval(x-i, j+y, width, height);
			} else if(x < xchange && y > ychange) {
				g2d.fillOval(x+i, y-j, width, height);
			} else {
				g2d.fillOval(x-i, y-j, width, height);
			}
			frame.repaint();
			try {
				Thread.sleep(5);
			} catch(Exception e) {
				
			}
		}
		
	}
	
	// draw fireworks after exploring
	public void paintFireworks(int x,int y,int degree,Graphics g) {
		Random rand = new Random();
		float R = (float) (rand.nextFloat() / 2f + 0.5);
		float G = (float) (rand.nextFloat() / 2f + 0.5);
		float B = (float) (rand.nextFloat() / 2f + 0.5);
		
		Color c = new Color(R,G,B);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(c);
		g2d.setStroke(new BasicStroke(8f));
		
		for(int k = 1;k <= nums;k++) {
			xchange = (int) (radius / nums * k *  Math.cos(degree));
			ychange = (int) (radius / nums * k *  Math.sin(degree));
			g2d.fillOval(x + xchange,y + ychange,width,height);
			g2d.fillOval(x + xchange * (k-2)/k, y + ychange * (k-2)/k, width,height);
			g2d.fillOval(x + xchange * (k-4)/k, y + ychange * (k-4)/k, width,height);
			try {
				Thread.sleep(20);
			} catch(Exception e) {
				
			}
			frame.repaint();
		}
		
//		frame.repaint();
		
	}
}
