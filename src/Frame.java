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
	int level = 3;
	int totalMove;
	//ArrayList stored all the cards
	ArrayList<Card> cards = new ArrayList<>(); 
	//ArrayList stored the position of the card
    ArrayList<Point> shuffledPositions = new ArrayList<>();
	//ArrayList stored matched cards
	ArrayList<Card> usedCards = new ArrayList<>();

	//Checking matching
	Card card1 = null;
	Card card2 = null;
	
	
	Font myFont = new Font("Courier", Font.BOLD, 25);
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
	Level levels = new Level();
	Move move = new Move();
	Home home = new Home();
	GameOver gameOverBackGround = new GameOver();
	LoseGame loseGameBackGround = new LoseGame();
	//frame width/height
	int width = 700;
	int height = 800;	
	boolean changeBackground = false;
	boolean resetGame = false;
	boolean gameOver = false;
	boolean gameLose = false;
	//hii
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		if (resetGame) {
			background.paint(g);  
		} else if (changeBackground) {
			background2.paint(g);
			home.paint(g);
			levels.paint(g);
			move.paint(g);
			// ADD TEXT
			g.setFont(myFont);
			g.setColor(new Color(251, 173, 172));
			g.drawString("" + level, 673, 25);
			g.drawString("" + totalMove, 658, 55);
			for (Card card : cards) {
                card.paint(g);
            }
		}
		else{
			background.paint(g);  
		}
		if (gameOver) { 
			gameOverBackGround.paint(g);
		}  
		if(gameLose){
			loseGameBackGround.paint(g);
		}
	}
	
	public void changeBackground() {
		changeBackground = true;
	}

	public void resetGame(){
		cards.clear();
		usedCards.clear();
		shuffledPositions.clear();
		card1 = null;
		card2 = null;
		level = 1;
		totalMove = 20;
		createCards();
		generateShuffledPositions();
		assignShuffledPositions();
		resetGame = false;
		gameOver = false;
		changeBackground = false;
		gameLose = false;
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Ocean Matching Game!");
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
	private void createCards() {
		if(level == 1){
			cards.add(new Dolphin()); 
			cards.add(new Dolphin());
			cards.add(new BlueWhale()); 
			cards.add(new BlueWhale());
			cards.add(new Crab()); 
			cards.add(new Crab());
			cards.add(new Dory());
			cards.add(new Dory());
		}
		else if(level == 2){
			cards.add(new Dolphin()); 
			cards.add(new Dolphin());
			cards.add(new BlueWhale()); 
			cards.add(new BlueWhale());
			cards.add(new Crab()); 
			cards.add(new Crab());
			cards.add(new Dory());
			cards.add(new Dory());
			cards.add(new Fishy());
			cards.add(new Fishy());
			cards.add(new GreyWhale());
			cards.add(new GreyWhale());
			cards.add(new Jelly());
			cards.add(new Jelly());
			cards.add(new Nimo());
			cards.add(new Nimo());
		}
		else if (level == 3){
			cards.add(new Dolphin()); 
			cards.add(new Dolphin());
			cards.add(new BlueWhale()); 
			cards.add(new BlueWhale());
			cards.add(new Crab()); 
			cards.add(new Crab());
			cards.add(new Dory());
			cards.add(new Dory());
			cards.add(new DownShark());
			cards.add(new DownShark());
			cards.add(new Fishy());
			cards.add(new Fishy());
			cards.add(new GreyWhale());
			cards.add(new GreyWhale());
			cards.add(new Jelly());
			cards.add(new Jelly());
			cards.add(new Nimo());
			cards.add(new Nimo());
			cards.add(new Octopus());
			cards.add(new Octopus());
			cards.add(new Orca());
			cards.add(new Orca());
			cards.add(new Penguin());
			cards.add(new Penguin());
			cards.add(new Puffer());
			cards.add(new Puffer());
			cards.add(new SadFish());
			cards.add(new SadFish());
			cards.add(new SailFish());
			cards.add(new SailFish());
			cards.add(new Seal());
			cards.add(new Seal());
			cards.add(new UpShark());
			cards.add(new UpShark());
			cards.add(new Zebra());
			cards.add(new Zebra());
		}
    }

	private void generateShuffledPositions() {
        int cardWidth = 80;
        int cardHeight = 100;
        int padding = 20;
		int cols;
		int rows;

        shuffledPositions.clear();
		if (level == 1){
			rows = 2;
			cols = 4;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					int x = c * (cardWidth + padding) + 150;
					int y = r * (cardHeight + padding) + 300;
					shuffledPositions.add(new Point(x, y));
				}
			}
		}
		else if (level == 2){
			rows = 4;
			cols = 4;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					int x = c * (cardWidth + padding) + 150;
					int y = r * (cardHeight + padding) + 180;
					shuffledPositions.add(new Point(x, y));
				}
			}
		}
		else if (level == 3){
			rows = 6;
			cols = 6;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					int x = c * (cardWidth + padding) + 50;
					int y = r * (cardHeight + padding) + 60;
					shuffledPositions.add(new Point(x, y));
				}
			}
		}
        Collections.shuffle(shuffledPositions);
    }

	

	private void assignShuffledPositions() {
        for (int i = 0; i < cards.size(); i++) {
            Point p = shuffledPositions.get(i);
            cards.get(i).setX(p.x);
            cards.get(i).setY(p.y);
        }
    }

	private void checkedMatching(){
		if (card1.getName().equals(card2.getName()) && card1 != card2){ //this to prevent the layer click the same card twice
			System.out.println("Matching check!");
			usedCards.add(card1);
			usedCards.add(card2);
		}
		else{
			System.out.println("Does not match!");
			card1.switchDir();
			card2.switchDir();
		}
		//reset
		card1 = null;
		card2 = null;
		int currLevel = level;
		if (checkedWin()) {
			if (currLevel == 3) {
				gameOver = true;
			} else {
				newLevel();
			}
		}	
	}

	private void newLevel(){
		emptyUsedCards();
		cards.clear();
		shuffledPositions.clear();
		createCards(); 
		generateShuffledPositions(); 
		assignShuffledPositions(); 

		card1 = null;
		card2 = null;

		for (Card card : cards) {
			card.switchDir(); // ensure card is face down
			if (card.getDir() == 0) {
				card.switchDir(); // flip again if needed
			}
		}

		if(level == 1){
			totalMove = 20;
		}
		else if(level == 2){
			totalMove = 40;
		}
		else if(level == 3){
			totalMove = 80;
		}
	}

	private boolean checkedWin(){ //checked that all cards are checked
		if(level == 1 && usedCards.size() == 8){
			level = 2;
			return true;
			
		}
		else if(level == 2 && usedCards.size() == 16){
			level = 3;
			return true;
			
		}
		else if(level == 3 && usedCards.size() == 36){
			return true;
		}
		return false;
	}


	private void emptyUsedCards(){
		for (int i = usedCards.size() - 1; i >= 0; i--) {
			usedCards.remove(i);
		}
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

		if (mouseX >= home.getX() && mouseX <= home.getX() + home.getWidth() &&
                mouseY >= home.getY() + 30 && mouseY <= home.getY() + home.getHeight() + 30){
					resetGame();
		}

		for (Card card : cards) {
            int cardX = card.getX();
            int cardY = card.getY();
            if (mouseX >= cardX && mouseX <= cardX + card.getWidth() &&
                mouseY >= cardY + 30 && mouseY <= cardY + card.getHeight() + 30) {

               //Check to see is it matching or not
				if(card1 == null){ //if the 1st card hasn't selected yet, then the first card is the card that we selected 
					card1 = card; 
					card1.switchDir(); // flip it
					System.out.println(totalMove);
				}
				else if(card1 != null && card2 == null){ //if the first card already selected, then the second card is the card that we select after 
					card2 = card;
					card2.switchDir(); //flip
					totalMove--;
					System.out.println(totalMove);
					//Add the delay timer (Chatgpt helper method heheheheheheh <333333)
					Timer t = new Timer(1000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							checkedMatching();
							((Timer)e.getSource()).stop();
							if (totalMove <= 0 && !checkedWin()) {
								gameLose = true;
							}
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
			level = 1;
			newLevel();
			changeBackground();
		}
		else if(arg0.getKeyCode() == 32){
			if(gameOver){
				resetGame();
			}
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