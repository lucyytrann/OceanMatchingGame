import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public abstract class Card {
    protected int x, y;
    protected int width, height;
    protected int dir;
    protected String name;

    public abstract void paint(Graphics g);
    public abstract void switchDir();

    public String getName(){
        return name;
    }

<<<<<<< HEAD
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
=======
    public int getDir() {
        return dir;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
>>>>>>> branch 'lucy-branch' of https://github.com/lucyytrann/OceanMatchingGame.git

    public int getWidth() {
    	return width; 
    }
    
    public int getHeight() { 
    	return height;
    }
    
    
}