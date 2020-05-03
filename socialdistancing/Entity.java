package socialdistancing;
import java.awt.Rectangle;

public class Entity {
	int x, y, width, height;

	public Entity() {
		// default constructor initializes empty Fields
	}
		
    public Entity(int x, int y, int width, int height) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
	/**
	 * Collision detection between two entity objects
	 * @param p2
	 */
	public boolean collisionDetector(Entity e2) {
		//Represent the Person objects as Rectangles for simple collision detection
		Rectangle rect1 = new Rectangle(x, y, width, height);
		Rectangle rect2 = new Rectangle(e2.x, e2.y, e2.width, e2.height);

		return rect1.intersects(rect2);
	}
    
}
