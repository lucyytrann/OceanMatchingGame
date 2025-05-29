import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dolphin extends Card{
	private Image inFront, backWard, left, right; 	
	private AffineTransform tx;
	
	int dir = 1; 					//0-forward, 1-backward, 2-left, 3-right
									//always backward first
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = 2;		//change to scale image
	double scaleHeight = 2; 		//change to scale image

	public Dolphin() {
		inFront 	= getImage("/imgs/"+"dolphin.png"); //load the image for Tree
		backWard 	= getImage("/imgs/"+"backCard.png"); //load the image for Tree
		

		//alter these
		width = 80;
		height = 100;
		x = 560;
		y = 315;
		vx = 0;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}

	

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x+=vx;
		y+=vy;	
		
		init(x,y);
		
		switch(dir) {
		case 0:
			g2.drawImage(inFront, tx, null);
			break;
		case 1:
			g2.drawImage(backWard, tx, null);
			break;
		}
	}
	
	public void switchDir() {
		if(dir == 0) {
			dir = 1;
		}
		else if(dir == 1) {
			dir = 0;
		}
	}
	
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Dolphin.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
