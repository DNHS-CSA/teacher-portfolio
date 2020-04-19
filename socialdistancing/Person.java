package socialdistancing;

import java.util.ArrayList;

// A person contains properties of Health
public class Person extends Resident {
	
	//health states
	protected enum virus {candidate, infected, recovered, died};
	
	//recoveryTime
	protected virus state = virus.candidate;
	protected int sickTime;
	
	//control variables
	double toRoam, toBeInfected, toDie;
	int sickTimeLow, sickTimeMax;

	/*
	 * Default Person constructor from Static values
	 */
	public Person() {
		toRoam = Settings.sToRoam;			    
		toBeInfected = Settings.sToBeInfected;		
		toDie = Settings.sToDie;				
		sickTimeLow = Settings.sSickTimeLow;			
		sickTimeMax = Settings.sSickTimeMax;
		
		this.init();
	}

	//Person constructed according to Control Panel settings
	public Person(Control ctl) {
		super(ctl);
		
		toRoam = ctl.toRoam;			    
		toDie = ctl.toDie;		
		toBeInfected = ctl.toBeInfected;
		sickTimeLow = ctl.sickTimeLow;
		sickTimeMax = ctl.sickTimeMax;

		this.init();
	}
		
	private void init() {
		
		//code to make percentage of the Person objects infected 
		if(Math.random() < toBeInfected) {
			this.setInfected();
		}
		
		//randomize how long it takes for the Person objects to recover!
		//for instance between 5-7 (between Min-Max) seconds (numbers are in milliseconds)
		sickTime = (int)(Math.random()*(sickTimeMax-sickTimeLow+1)+sickTimeLow);
	}
	
	//a series of getters to simplify code reading
	public boolean isCandidate() {
		return state == virus.candidate;
	}
	
	public boolean isInfected() {
		return state == virus.infected;
	}
	
	public boolean isRecovered() {
		return state == virus.recovered;
	}
	
	public boolean isDead() {
		return state == virus.died;
	}
	
	// infected setter and update to infected counter
	public void setInfected() {
		state = virus.infected;
		if (ctl != null) ctl.numInfected++;
	}
	
	//calculates health of person over time
	public void healthManager() {
		
		//If person is infected, they eventually recover or die so that they don't 
		//infect people forever. 
		if(state == virus.infected) {
			//recoveryTime update
			sickTime -= ctl.timerValue;
			
			//once the person has been given enough time, they will be considered recovered
			if(sickTime<=0) {
				if(Math.random() < toDie) {
					state = virus.died;
					if (ctl != null) ctl.numDied++;
				} else {
					state = virus.recovered;
				}
				if (ctl != null) ctl.numInfected--;
			}
		}			
	}
	
	/*
	 * Check if collision between two person objects has occurred
	*/
	@Override
	public void collisionDetector(Resident p2) {
		super.collisionDetector(p2);
	}
	
	/**
	 * Collision between two person objects has been detected
	 * If two Person objects collide they have a possibility of infecting!
	 * @param p2
	 */
	@Override
	public void collisionAction(Resident r2) {
	
		Person p2 = (Person)r2;
		//infection only happens if one person is infected and the other has never
		//been infected before
		if (this.isInfected() && p2.isCandidate()) {
			p2.setInfected();
		}else if(this.isCandidate() && p2.isInfected()) {
			this.setInfected();
		}				
	}
	
	/*
	 * Perform velocity manager updates on person
	*/
	@Override
	public void velocityManager() {
		if (isRoaming) {
			if (this.isRecovered() || this.isDead())
				super.velocityStop();
			else
				super.velocityManager();
		}
			
	}
	
	/*
	 * Key properties of person
	 */
	public String toString() {
		
		return ( "" + state + "\t" + sickTime + "\tx:" + x + "\t" + vx + "\ty:" + y + "\t" + vy ); 
	}
	
	/*
	 * Main Tester method
	 */
	public static void main (String[] args) {
		int numOfPeople = 25;
		
		ArrayList<Person> pl = new ArrayList<Person>();
		for (int i = 0; i < numOfPeople; i++) {
			Person p = new Person();
			pl.add(p);
		}
		for (Person p : pl) {
			System.out.println( p );
		}
	}
	
	
}