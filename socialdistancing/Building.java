package socialdistancing;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Building {	
	String name;
	int vx, vy, hx, hy;

	//Front facing walls of Building
	Wall vWall;
	Wall hWall;
		
    public Building(String name, int vx, int vy, int hx, int hy) {
    	this.name = name;
    	this.vx = vx;
    	this.vy = vy;
    	this.hx = hx;
    	this.hy = hy;
    	
    	vWall = new Wall(vx, vy, "SocialDistancingImages/wall2.png", true);
    	hWall = new Wall(hx, hy, "SocialDistancingImages/wall1.png", false);   	
    }
    
    public String getName() {
    	return name;
    }
    
    public Wall getVWall() {
    	return vWall;
    }
    
    public Wall getHWall() {
    	return hWall;
    }
     
    public void drawImage(Graphics g, Panel panel) {
    	//xoffset is orientation of wall from top or from bottom
    	int xoffset = vx < hx ? vx : hx;
		g.drawString(name, xoffset + 30 , vy + 50);
    	g.drawImage(vWall.getImage(), vWall.getX(), vWall.getY(), panel);
    	g.drawImage(hWall.getImage(), hWall.getX(), hWall.getY(), panel);

    }

}
