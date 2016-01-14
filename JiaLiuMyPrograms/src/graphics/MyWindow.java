package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
 

public class MyWindow extends JFrame implements KeyListener{
	int width = 500;
	int height = 500;
	Hero boy;
	Hero john;
	BufferedImage landscape;
	boolean itemPickedUp;

	public static void main(String[] args) {
		new MyWindow();
	}
	
	public MyWindow(){
		//The Following are JFrame methods
		boy = new Hero("Link", "/images/heros/linkFoward.jpg",400,100);
		john = new Hero("John", "/images/heros/johnCena.png",0,100);
		itemPickedUp = false;
		
		//boy = new Hero("Link", "/images/heros/linkSheet.jpg",200,100);
		landscape = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		setVisible(true);
		setSize(width, height);//units in px
		setLocation(200,150);//200 px right, 150 px down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Static constant reference for special close operation
		addKeyListener(this);
	}
	
	private void paintLandscape(Graphics2D g2) {
		
	}

	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)g;//image.getGraphics();
		g2.setColor(Color.orange);
		g2.fillRect(0, 0, 500, 500);
		
		g2.drawImage(landscape, 0, 0, null);
		g2.drawImage(boy.getImage(), boy.getX(), boy.getY(), null);
		if(Math.abs(boy.getX()-john.getX()) + Math.abs(boy.getY()-john.getY()) < 10){
			itemPickedUp = true;
		}
		if(!itemPickedUp)g2.drawImage(john.getImage(), john.getX(), john.getY(), null);
	}
	
	public void paintStuff(){
//		g2.setColor(Color.pink);
//		g2.fillOval(50, 100, 50, 100);
//		g2.setColor(Color.yellow);
//		g2.drawOval(50, 100, 50, 100);
//		
//		g2.setColor(Color.pink);
//		g2.fillOval(200, 100, 50, 100);
//		g2.setColor(Color.yellow);
//		g2.drawOval(200, 100, 50, 100);
		
		//x,y,width,height,startDEG,lengthDEG
//		for(int i = 1; i < 2; i++){
//			if(i % 2 == 0){
//				g2.setColor(Color.black);
//				g2.drawArc(50, 300, 200, 100, 180, 180);
//			}
//			else{
//				g2.setColor(Color.black);
//				g2.fillArc(50, 300, 200, 100, 0, 360);
//			}	
//			if(i < 2){
//				i = 1;
//			}
//		}
		//String
		//g2.setFont()
//		g2.drawString("BOBO", 300, 300);
		
		//lines: startX, startY, endX, endY
//		g2.drawLine(0, 0, width, height);
//		g2.setColor(Color.pink);
		//g1.drawString("hi");
//		int squareD = 20;
//		int margin = 2;
//		int c = 1;
//		for(int x = 0; x < width; x+=squareD+margin){
//			for(int y = 0; y < height; y+=squareD + margin){
////				if(c < 255){
////					g2.setColor(new Color(0,0,c));
////					c++;
////				}
////				else{
////					g2.setColor(new Color(0,0,c));
////				}
//				if(c % 2 == 0){
//					g2.setColor(Color.red);
//				}
//				else{
//					g2.setColor(Color.black);
//				}
//				c++;
//				g2.fillRect(x, y, squareD, squareD);
//			}
//		}
		
		//draw the bufferedImage on the canvas
		//g.drawImage(g, 0, 0, null);
//		g1.drawImage(b, 0, 0, null);

	}

	
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			boy.moveUp();			
		}
		else if(key == KeyEvent.VK_DOWN){
			boy.moveDown();
		}
		else if(key == KeyEvent.VK_RIGHT){
			boy.moveRight();
		}
		else if(key == KeyEvent.VK_LEFT){
			boy.moveLeft();
		}
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
