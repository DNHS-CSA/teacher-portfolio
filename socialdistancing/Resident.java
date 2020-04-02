package socialdistancing;
import java.awt.Rectangle;


//A citizen is a Person and contains properties to support position and movement
public abstract class Resident {
		
	//location
	int x, y;

	//velocity
	protected boolean isRoaming = false;
	int vx, vy;
	
	
	//Constructor for the Citizen objects
	public Resident() {
				
		//randomize the position of the Person object to be within the SocialDistance frame!
		x = (int)(Math.random()*(Control.xExt)+0);
		y = (int)(Math.random()*(Control.yExt)+0);
				
		//social distancing part - when do the objects have movement vx and vy?
		//for instance 10% of the time the code below will run to give the objects a non-zero vx and vy
		//to simulate that 10% of instantiated objects are NOT practicing social distancing
		if(Math.random() < Control.toRoam) {
			vx  = (int)(Math.random()*(10+1)+-5);	// velocity x
			vy  = (int)(Math.random()*(10+1)+-5);	// velocity y
			isRoaming = true;
		}
		
	}

	
	/**
	 * Collision detection between two resident objects
	 * @param p2
	 */
	public void collisionDetector(Resident r2) {
		
		//Represent the Person objects asa Rectangles for simple collision detection
		Rectangle rect1 = new Rectangle(r2.x,r2.y, Control.OvalW, Control.OvalH);
		Rectangle rect2 = new Rectangle(this.x,this.y, Control.OvalW, Control.OvalH);
		
		//collision check
		if(rect1.intersects(rect2)) {
			this.collisionAction(r2);
		}
						
	}
	
	/**
	 * Collision detection action must be performed by extending class
	 * 
	 */
	public abstract void collisionAction(Resident r2);
	

	/**
	 * Velocity of an object is conditioned by settings in constructor
	 * 1. Move x, y position of resident object
	 * 2. Check if resident object boundary/frame extent is reached, then reflect
	 */
	public void velocityManager() {
		
		//x and y components are updated based on their velocities
		x += vx;
		y += vy;
		
		//code to reverse object when reaching left/right extents
		if(x < 0 || x >= Control.xExt) {
			vx *= -1;
		}
		
		//code to reverse object when reaching top/bottom extents
		if(y < 0 || y >= Control.yExt) {
			vy *= -1;
		}

	}
	
	/**
	 * Velocity of a roaming object is set to stationary
	 */
	public void velocityStop() {
		vx = 0; vy = 0;
		isRoaming = false;
	}
	
	
}
