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
import java.util.ArrayList;
import java.util.Collections;

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
	//ArrayList stored all the cards
	ArrayList<Card> cards = new ArrayList<>(); 
	//ArrayList stored the position of the card
    ArrayList<Point> shuffledPositions = new ArrayList<>();

	//Checking matching
	Card card1 = null;
	Card card2 = null;
	boolean delay = false;
	
	
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
	SadFish sadfish = new SadFish();
	Dolphin dolphin = new Dolphin();
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
			for (Card card : cards) {
                card.paint(g);
            }
			/* 
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
			sadfish.paint(g);
			dolphin.paint(g);
			*/
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

		generateShuffledPositions();
        createCards();
        assignShuffledPositions();

	
		
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

	private void generateShuffledPositions() {
        int cardWidth = 80;
        int cardHeight = 100;
        int padding = 20;
        int cols = 6;
        int rows = 6;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = c * (cardWidth + padding) + 60;
                int y = r * (cardHeight + padding) + 75;
                shuffledPositions.add(new Point(x, y));
            }
        }

        Collections.shuffle(shuffledPositions);
    }

	private void createCards() {
        cards.add(new Dolphin()); 
		cards.add(new Dolphin());
		cards.add(new BlueWhale()); 
		cards.add(new BlueWhale());
		cards.add(new Crab()); 
		cards.add(new Crab());
    }

	private void assignShuffledPositions() {
        for (int i = 0; i < cards.size(); i++) {
            Point p = shuffledPositions.get(i);
            cards.get(i).setX(p.x);
            cards.get(i).setY(p.y);
        }
    }

	private void checkedMatching(){
		if (card1.getName().equals(card2.getName())){
			System.out.println("Matching check!");
		
		}
		else{
			System.out.println("Does not match!");
		}
		//reset
		card1 = null;
		card2 = null;
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

		for (Card card : cards) {
            int cardX = card.getX();
            int cardY = card.getY();
            if (mouseX >= cardX && mouseX <= cardX + card.getWidth() &&
                mouseY >= cardY + 30 && mouseY <= cardY + card.getHeight() + 30) {

               //Check to see is it mathcing or not
				if(card1 == null){ //if the 1st card hasn't selected yet, then the first card is the card that we selected 
					card1 = card; 
					card1.switchDir(); // flip it
				}
				else if(card1 != null && card2 == null){ //if the first card already selected, then the second card is the card that we select after 
					card2 = card;
					card2.switchDir(); //flip
					//Add the delay timer (Chatgpt helper method heheheheheheh <333333)
					Timer t = new Timer(1000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							checkedMatching();
							((Timer)e.getSource()).stop();
						} 
					});
					t.setRepeats(false);
					t.start();
				}
			}
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