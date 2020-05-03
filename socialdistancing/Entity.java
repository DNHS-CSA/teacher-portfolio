package socialdistancing;
import java.awt.Rectangle;

/**
 * The primary purpose of Entity Class is to detect rectangle intersections in common fashion
 * 
 */
public class Entity {
	protected int x, y, width, height;

	/**
	 * Default constructor
	 */
	public Entity() {
		// default constructor initializes empty Fields
	}
	
	/**
	 * Primary constructor establishes values of an Entity
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param width - width of
	 * @param height - height of
	 */
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
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
	/**
	 * Collision detection between two entity objects
	 * @param e2
	 */
	public boolean collisionDetector(Entity e2) {
		//Represent the Person objects as Rectangles for simple collision detection
		Rectangle rect1 = new Rectangle(x, y, width, height);
		Rectangle rect2 = new Rectangle(e2.x, e2.y, e2.width, e2.height);

		return rect1.intersects(rect2);
	}
    
}
