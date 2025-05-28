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


	Background background = new Background();
	Nimo nimo = new Nimo();
	Octopus octopus = new Octopus();
	Crab crab = new Crab();
	Dory dory = new Dory();
	Seal seal = new Seal();
	Orca orca = new Orca();
	SailFish sailfish = new SailFish();
	Zebra zebra	 = new Zebra();
	Puffer puffer = new Puffer();
	GreyWhale greywhale = new GreyWhale();
	Jelly jelly = new Jelly();
	BlueWhale bluewhale = new BlueWhale();
	Penguin penguin = new Penguin();
	UpShark upshark = new UpShark();
	DownShark downshark = new DownShark();
	Fishy fishy = new Fishy();
	Background2 background2 = new Background2();
	//frame width/height
	int width = 700;
	int height = 800;	
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
			dory.paint(g);
			seal.paint(g);
			sailfish.paint(g);
			orca.paint(g);
			zebra.paint(g);
			puffer.paint(g);
			greywhale.paint(g);
			jelly.paint(g);
			bluewhale.paint(g);
			penguin.paint(g);
			upshark.paint(g);
			downshark.paint(g);
			fishy.paint(g);
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
		if (mouseX >= dory.getX() && mouseX <= dory.getX() + dory.getWidth() &&
		        mouseY >= dory.getY()+30 && mouseY <= dory.getY() + dory.getHeight()+30) {
			dory.switchDir();
		}
		if (mouseX >= seal.getX() && mouseX <= seal.getX() + seal.getWidth() &&
		        mouseY >= seal.getY()+30 && mouseY <= seal.getY() + seal.getHeight()+30) {
			seal.switchDir();
		}
		if (mouseX >= sailfish.getX() && mouseX <= sailfish.getX() + sailfish.getWidth() &&
		        mouseY >= sailfish.getY()+30 && mouseY <= sailfish.getY() + sailfish.getHeight()+30) {
			sailfish.switchDir();
		}
		if (mouseX >= orca.getX() && mouseX <= orca.getX() + orca.getWidth() &&
		        mouseY >= orca.getY()+30 && mouseY <= orca.getY() + orca.getHeight()+30) {
			orca.switchDir();
		}
		if (mouseX >= zebra.getX() && mouseX <= zebra.getX() + zebra.getWidth() &&
		        mouseY >= zebra.getY()+30 && mouseY <= zebra.getY() + zebra.getHeight()+30) {
			zebra.switchDir();
		}
		if (mouseX >= puffer.getX() && mouseX <= puffer.getX() + puffer.getWidth() &&
		        mouseY >= puffer.getY()+30 && mouseY <= puffer.getY() + puffer.getHeight()+30) {
			puffer.switchDir();
		}
		if (mouseX >= greywhale.getX() && mouseX <= greywhale.getX() + greywhale.getWidth() &&
		        mouseY >= greywhale.getY()+30 && mouseY <= greywhale.getY() + greywhale.getHeight()+30) {
			greywhale.switchDir();
		}
		if (mouseX >= jelly.getX() && mouseX <= jelly.getX() + jelly.getWidth() &&
		        mouseY >= jelly.getY()+30 && mouseY <= jelly.getY() + jelly.getHeight()+30) {
			jelly.switchDir();
		}
		if (mouseX >= bluewhale.getX() && mouseX <= bluewhale.getX() + bluewhale.getWidth() &&
		        mouseY >= bluewhale.getY()+30 && mouseY <= bluewhale.getY() + bluewhale.getHeight()+30) {
			bluewhale.switchDir();
		}
		if (mouseX >= penguin.getX() && mouseX <= penguin.getX() + penguin.getWidth() &&
		        mouseY >= penguin.getY()+30 && mouseY <= penguin.getY() + penguin.getHeight()+30) {
			penguin.switchDir();
		}
		if (mouseX >= upshark.getX() && mouseX <= upshark.getX() + upshark.getWidth() &&
		        mouseY >= upshark.getY()+30 && mouseY <= upshark.getY() + upshark.getHeight()+30) {
			upshark.switchDir();
			
		}
		if (mouseX >= downshark.getX() && mouseX <= downshark.getX() + downshark.getWidth() &&
		        mouseY >= downshark.getY()+30 && mouseY <= downshark.getY() + downshark.getHeight()+30) {
			downshark.switchDir();
		}
		if (mouseX >= fishy.getX() && mouseX <= fishy.getX() + fishy.getWidth() &&
		        mouseY >= fishy.getY()+30 && mouseY <= fishy.getY() + fishy.getHeight()+30) {
			fishy.switchDir();
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