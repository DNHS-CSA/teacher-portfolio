package socialdistancing;

// A person contains properties of Health
public class Person {

	//health states
	protected enum virus {candidate, infected, recovered, died};
	
	//recoveryTime
	protected virus state = virus.candidate;
	protected int sickTime;
	
	public Person() {
		//code to make percentage of the Person objects infected 
		if(Math.random() < Control.toBeInfected) {
			this.setInfected();
		}
	}
	
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
	
	public void setInfected() {
		state = virus.infected;
		Control.numInfected++;
	}
	
	public void healthManager() {
		
		//If person is infected, they eventually recover so that they don't 
		//infect people forever. 
		if(state == virus.infected) {
			//recoveryTime update
			sickTime -= Control.timerValue;
			
			//once the person has been given enough time, they will be considered recovered
			if(sickTime<=0) {
				if(Math.random() < Control.toDie) {
					state = virus.died;
					Control.numDied++;
				} else {
					state = virus.recovered;
				}
				Control.numInfected--;
			}
		}			
	}
	
	
}
