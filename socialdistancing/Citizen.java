package socialdistancing;
import java.awt.Rectangle;


//A citizen is a Person and contains properties to support position and movement
public class Citizen extends Person {
		
	//location
	int x, y;

	//velocity
	protected int vx, vy;
	
	
	//Constructor for the Citizen objects
	public Citizen() {
		
		
		//randomize the position of the Person object to be within the SocialDistance frame!
		x = (int)(Math.random()*(Control.xExt)+0);
		y = (int)(Math.random()*(Control.yExt)+0);
		
		
		//social distancing part - when do the objects have movement vx and vy?
		//for instance 10% of the time the code below will run to give the objects a non-zero vx and vy
		//to simulate that 10% of instantiated objects are NOT practicing social distancing
		if(Math.random() < Control.toRoam) {
			vx  = (int)(Math.random()*(10+1)+-5);	// velocity x
			vy  = (int)(Math.random()*(10+1)+-5);	// velocity y
		}
		
		//randomize how long it takes for the Person objects to recover!
		//for instance between 5-7 (between Min-Max) seconds (numbers are in milliseconds)
		sickTime = (int)(Math.random()*(Control.sickTimeMax-Control.sickTimeLow+1)+Control.sickTimeLow);
		
	}
	
	/**
	 * Collision between two person objects for "infections"
	 * If two Person objects collide they have a possibility of infecting!
	 * @param p2
	 */
	public void collisionDetector(Citizen p2) {
		
		//Represent the Person objects asa Rectangles for simple collision detection
		Rectangle per1 = new Rectangle(p2.x,p2.y, Control.OvalW, Control.OvalH);
		Rectangle per2 = new Rectangle(this.x,this.y, Control.OvalW, Control.OvalH);
		
		//collision check
		if(per1.intersects(per2)) {
			//infection only happens if one person is infected and the other has never
			//been infected before
			if (this.isInfected() && p2.isCandidate()) {
				p2.setInfected();
			}else if(this.isCandidate() && p2.isInfected()) {
				this.setInfected();
			}				
		}
	}
	

	//Citizen velocity manager
	public void velocityManager() {
		
		// those that have recovered or died need to stop moving
		if (this.isRecovered() || this.isDead()) {
			vx = 0; vy = 0;
		}
		
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
	
	
}
