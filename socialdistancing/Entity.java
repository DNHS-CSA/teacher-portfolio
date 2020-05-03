package socialdistancing;
import java.awt.Rectangle;

public class Entity {
	int x, y, width, height;
	Rectangle rect;

	public Entity() {
		// default constructor initializes empty Fields
	}
		
    public Entity(int x, int y, int width, int height) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	
    	rect = new Rectangle(x,y,width,height);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Rectangle getBounds() {
        return rect;
    }
    
}
