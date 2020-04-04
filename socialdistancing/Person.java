package socialdistancing;

// A person contains properties of Health
public class Person extends Resident {
	//health states
	protected enum virus {candidate, infected, recovered, died};
	
	//recoveryTime
	protected virus state = virus.candidate;
	protected int sickTime;
	
	//person constructed with or without virus, percentage used of infected used to prime simulation
	public Person(Control ctl) {
		super(ctl);
		
		//code to make percentage of the Person objects infected 
		if(Math.random() < ctl.toBeInfected) {
			this.setInfected();
		}
		
		//randomize how long it takes for the Person objects to recover!
		//for instance between 5-7 (between Min-Max) seconds (numbers are in milliseconds)
		sickTime = (int)(Math.random()*(ctl.sickTimeMax-ctl.sickTimeLow+1)+ctl.sickTimeLow);
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
		ctl.numInfected++;
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
				if(Math.random() < ctl.toDie) {
					state = virus.died;
					ctl.numDied++;
				} else {
					state = virus.recovered;
				}
				ctl.numInfected--;	// global infected reduced
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
	
	
}
