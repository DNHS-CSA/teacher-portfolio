package model_socialdistancing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import view_control.SocialDistance;

public class Person {
	
	//position extents
	final int xExt = (int) (SocialDistance.frameX - SocialDistance.frameX*.03);
	final int yExt = (int) (SocialDistance.frameY - SocialDistance.frameY*.04);
	final int ovalWidth = SocialDistance.OvalW;
	final int ovalHeight = SocialDistance.OvalH;
	
	//location
	int x, y;
	
	//velocity
	int vx, vy;
	
	//health states
	enum virus {candidate, infected, recovered};
	virus state = virus.candidate;
	
	// simulation control
	final double estInfected = .02;			// % of population that has virus in simulation
	final double reqToRoam = .10;			// % population that required to roam in simulation
	final int msHealTimeMin = 5000;			// Minimum time to recover 5 seconds
	final int msHealTimeMax = 10000;		// Max time to recover 10 seconds
	//recoveryTime
	int recoveryTime;
	
	public static int numInfected = 0;
	
	//Constructor for the Person objects
	public Person() {
		
		//randomize the position of the Person object to be within the SocialDistance frame!
		x = (int)(Math.random()*(xExt)+0);
		y = (int)(Math.random()*(yExt)+0);
		
		//code to make 8% of the Person objects infected 
		if(Math.random() < estInfected) {
			state = virus.infected;
			numInfected++;
		}
		
		//social distancing part - when do the objects have movement vx and vy?
		//for instance 10% of the time the code below will run to give the objects a non-zero vx and vy
		//to simulate that 10% of instantiated objects are NOT practicing social distancing
		if(Math.random() < reqToRoam) {
			vx  = (int)(Math.random()*(10+1)+-5);	// velocity x
			vy  = (int)(Math.random()*(10+1)+-5);	// velocity y
		}
		
		//randomize how long it takes for the Person objects to recover!
		//for instance between 5-7 (between Min-Max) seconds (numbers are in milliseconds)
		recoveryTime = (int)(Math.random()*(msHealTimeMax-msHealTimeMin+1)+msHealTimeMin);
		
	}
	
	/**
	 * Collision between two person objects for "infections"
	 * If two Person objects collide they have a possibility of infecting!
	 * @param p2
	 */
	public void collision(Person p2) {
		
		//Represent the Person objects asa Rectangles for simple collision detection
		Rectangle per1 = new Rectangle(p2.x,p2.y, ovalWidth, ovalHeight);
		Rectangle per2 = new Rectangle(this.x,this.y, ovalWidth, ovalHeight);
		
		//collision check
		if(per1.intersects(per2)) {
			//infection only happens if one person is infected and the other has never
			//been infected before
			if (this.state == virus.infected && p2.state == virus.candidate) {
				p2.state = virus.infected;
				numInfected++; //add to total count of infected people
			}else if(this.state == virus.candidate && p2.state == virus.infected) {
				this.state = virus.infected;
				numInfected++; //add to total count of infected people
			}
				
		}

	}
		
	public void paint(Graphics g) {
		
		//set the color of the Person object based on the health status
		switch(state) {
			case candidate: //normal
				g.setColor(Color.LIGHT_GRAY);
				break;
			case infected: //infected
				g.setColor(Color.red);
				break;
			case recovered: //recovered
				g.setColor(Color.blue);
				
		}
		
		//If person is infected, they eventually recover so that they don't 
		//infect people forever. 
		if(state == virus.infected) {
			//recoveryTime update
			recoveryTime -= SocialDistance.timerValue;
			
			//once the person has been given enough time, they will be considered recovered
			if(recoveryTime<=0) {
				state = virus.recovered;
				numInfected--;
			}
		}
		
		//x and y components are updated based on their velocities
		x += vx;
		y += vy;
		
		//code to have the Person objects bounce off the borders
		if(x < 0 || x >= xExt) {
			vx *= -1;
		}
		
		//bounce off the top and bottom
		if(y < 0 || y >= yExt) {
			vy *= -1;
		}
		
		//draw the oval representing the Person object
		g.fillOval(x, y, ovalWidth, ovalHeight);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
