package socialdistancing;
import java.awt.Rectangle;

public class Person {

	//health states
	protected enum virus {candidate, infected, recovered, died};
	
	//recoveryTime
	protected virus state = virus.candidate;
	protected int sickTime;
	
	//oval size
	public static final int OvalW = 10;	//Height
	public static final int OvalH = 10;	//Width
	//oval location
	protected int x, y;
	
	public Person() {
		//code to make percentage of the Person objects infected 
		if(Math.random() < Population.individualsToBeInfected) {
			state = virus.infected;
			Population.numInfected++;
		}
	}
	
	/**
	 * Collision between two person objects for "infections"
	 * If two Person objects collide they have a possibility of infecting!
	 * @param p2
	 */
	public void collision(Person p2) {
		
		//Represent the Person objects asa Rectangles for simple collision detection
		Rectangle per1 = new Rectangle(p2.x,p2.y, OvalW, OvalH);
		Rectangle per2 = new Rectangle(this.x,this.y, OvalW, OvalH);
		
		//collision check
		if(per1.intersects(per2)) {
			//infection only happens if one person is infected and the other has never
			//been infected before
			if (this.state == virus.infected && p2.state == virus.candidate) {
				p2.state = virus.infected;
				Population.numInfected++; //add to total count of infected people
			}else if(this.state == virus.candidate && p2.state == virus.infected) {
				this.state = virus.infected;
				Population.numInfected++; //add to total count of infected people
			}
				
		}

	}
	
	public void properties() {
		
		//If person is infected, they eventually recover so that they don't 
		//infect people forever. 
		if(state == virus.infected) {
			//recoveryTime update
			sickTime -= SocialDistanceFrame.timerValue;
			
			//once the person has been given enough time, they will be considered recovered
			if(sickTime<=0) {
				if(Math.random() < Population.individualsToDie) {
					state = virus.died;
					Population.numDied++;
				} else {
					state = virus.recovered;
				}
				Population.numInfected--;
			}
		}
			
	}
	
	
}
