import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	//hi
	//please let me commit 
	//Timer related variables
	int waveTimer = 5; //each wave of enemies is 20s
	long ellapseTime = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	int level = 0;
	//hi jdasjfkhsdfjghdsajg
	
	
	Font myFont = new Font("Courier", Font.BOLD, 40);
	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("scifi.wav", false);
//	Music soundBang = new Music("bang.wav", false);
//	Music soundHaha = new Music("haha.wav", false);
//hiiiiii
//this is annoying
	
	
	
	//hi

	//kekeke
	Background background = new Background();
	Nimo nimo = new Nimo();
	Octopus octopus = new Octopus();
	Crab crab = new Crab();
	Background2 background2 = new Background2();
	//frame width/height
	int width = 600;
	int height = 600;	
	boolean changeBackground = false;
	//hii
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		background.paint(g);
		
		
		if(changeBackground) {
			background2.paint(g);
			nimo.paint(g);	
			octopus.paint(g);
			crab.paint(g);
		}
	}
	
	public void changeBackground() {
		changeBackground = true;
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Ocean Matching Game");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
	
		backgroundMusic.play();

	
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		/*setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("torch.png").getImage(),
				new Point(0,0),"custom cursor"));	
				*/
		
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		int mouseX = m.getX();
		int mouseY = m.getY();
		
		if (mouseX >= nimo.getX() && mouseX <= nimo.getX() + nimo.getWidth() &&
		        mouseY >= nimo.getY()+30 && mouseY <= nimo.getY() + nimo.getHeight()+30) {
		        nimo.switchDir();
		}
		
		if (mouseX >= octopus.getX() && mouseX <= octopus.getX() + octopus.getWidth() &&
		        mouseY >= octopus.getY()+30 && mouseY <= octopus.getY() + octopus.getHeight()+30) {
			octopus.switchDir();
		}
		if (mouseX >= crab.getX() && mouseX <= crab.getX() + crab.getWidth() &&
		        mouseY >= crab.getY()+30 && mouseY <= crab.getY() + crab.getHeight()+30) {
			crab.switchDir();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		if(arg0.getKeyCode() == 10 ) {
			changeBackground();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	
	}

}