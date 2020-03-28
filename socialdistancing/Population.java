package socialdistancing;

public class Population extends Person {
	
	// global counters
	public static int numInfected = 0;
	public static int numDied= 0;
	
	//position extents
	final int xExt = (int) (SocialDistanceFrame.frameX - SocialDistanceFrame.frameX*.03);
	final int yExt = (int) (SocialDistanceFrame.frameY - SocialDistanceFrame.frameY*.04);
	
	// simulation control
	static double individualsToDie = .06;			// % population that would die out of those that get sick
	static double individualsToBeInfected = .02;	// % of population that has virus in simulation
	static double individualsToRoam = .10;					// % population that required to roam in simulation
	int estSickTimeLow = 5000;						// Minimum time to recover 5 seconds
	int estSickTimeMax = 10000;						// Max time to recover 10 seconds
			
	//velocity
	protected int vx, vy;
		
	
	//Constructor for the Person objects
	public Population() {
		
		//randomize the position of the Person object to be within the SocialDistance frame!
		x = (int)(Math.random()*(xExt)+0);
		y = (int)(Math.random()*(yExt)+0);
		
		
		//social distancing part - when do the objects have movement vx and vy?
		//for instance 10% of the time the code below will run to give the objects a non-zero vx and vy
		//to simulate that 10% of instantiated objects are NOT practicing social distancing
		if(Math.random() < individualsToRoam) {
			vx  = (int)(Math.random()*(10+1)+-5);	// velocity x
			vy  = (int)(Math.random()*(10+1)+-5);	// velocity y
		}
		
		//randomize how long it takes for the Person objects to recover!
		//for instance between 5-7 (between Min-Max) seconds (numbers are in milliseconds)
		sickTime = (int)(Math.random()*(estSickTimeMax-estSickTimeLow+1)+estSickTimeLow);
		
	}
	
	public void areaManager() {
		
		// those that have died need to stop moving
		if (state == virus.recovered || state == virus.died) {
			vx = 0; vy = 0;
		}
		
		//x and y components are updated based on their velocities
		x += vx;
		y += vy;
		
		//code to reverse object when reaching left/right extents
		if(x < 0 || x >= SocialDistanceFrame.frameX) {
			vx *= -1;
		}
		
		//code to reverse object when reaching top/bottom extents
		if(y < 0 || y >= SocialDistanceFrame.frameY) {
			vy *= -1;
		}

	}
	
}
