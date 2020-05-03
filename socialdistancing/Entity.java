package socialdistancing;
import java.awt.Rectangle;

public abstract class Entity {
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
    
    /**
	 * Collision detection action must be performed by extending class
	 * 
	 */
	public abstract void collisionAction(Entity e);
	

    /**
	 * Collision detection between two entity objects
	 * @param p2
	 */
	public void collisionDetector(Entity e2) {
		
		//Represent the Person objects as Rectangles for simple collision detection
		Rectangle rect1 = new Rectangle(x, y, width, height);
		Rectangle rect2 = new Rectangle(e2.x, e2.y, e2.width, e2.height);

		//collision check
		if(rect1.intersects(rect2)) {
			this.collisionAction(e2);
		}
						
	}
	
	/**
	 * Collision detection between two entity objects
	 * @param p2
	 */
	public boolean collisionDetectorTF(Entity e2) {
		//Represent the Person objects as Rectangles for simple collision detection
		Rectangle rect1 = new Rectangle(x, y, width, height);
		Rectangle rect2 = new Rectangle(e2.x, e2.y, e2.width, e2.height);

		return rect1.intersects(rect2);
	}
    
}
