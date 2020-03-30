package socialdistancing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		static String title = "Social Distance Simulation";
		
		// global counters
		public static int numInfected = 0;
		public static int numDied= 0;
		
		// Citizen simulation control
		static int numPeople = 100;			// people in the simulation
		static double toRoam = .10;			// % population that required to roam in simulation (essential workers, rule breakers)
		static double toBeInfected = .02;	// % of population that has virus in simulation
		static double toDie = .06;			// % population that would die out of those that get infected
		static int sickTimeLow = 5000;		// Minimum time to recover 5 seconds
		static int sickTimeMax = 10000;		// Max time to recover 10 seconds
		
		//frame extents
		public static final int frameX = 800;
		public static final int frameY = 600;
		//position extents
		public static final int xExt = (int) (frameX - frameX*.03);
		public static final int yExt = (int) (frameY - frameY*.04);
		//oval size, represents person
		public static final int OvalW = 10;	//Height
		public static final int OvalH = 10;	//Width
		
		
		//refresh timer, also used for age of infection
		public static final int timerValue = 16;

		
		//store multiple Person and point objects
		static ArrayList<Citizen> model = new ArrayList<Citizen>(); //the community of objects	
		
		
		//main loop for simulation
		public static void main(String[] args) {
			
			//Simulation setup
			//setup the Person objects in the list
			for(int i = 0; i < Control.numPeople; i++) {
				//instantiate an Person object and add it to the ArrayList
				//this is the part that actually CREATES objects we can use
				model.add(new Citizen());
			}
			new View(title);
		}
		
		// 
		static public void modelUpdate(Graphics g) {
			
			//paint the Citizen in the Simulation!
			int index = 0;
			for(Citizen p: model) {
				for(Citizen p2: model) {
					//for each unique pair invoke the collision detection code
					p.collisionDetector(p2);
				}
				
				p.healthManager();  // update each Persons properties based on collisions
				p.velocityManager();  // manage their Simulation values (xy and velocity)
				
				//set the color of the Person object based on the health status
				switch(p.state) {
					case candidate: //normal
						g.setColor(Color.LIGHT_GRAY);
						break;
					case infected: //infected
						g.setColor(Color.red);
						break;
					case recovered: //recovered
						g.setColor(Color.green);
						break;
					case died:
						g.setColor(Color.black);
						
				}
				
				//draw the oval representing the the object
				g.fillOval(p.x, p.y, OvalW, OvalH);
				
				// bar meter to show current state of all Citizens
				g.fillOval((frameX-(int)(frameX*.02)), (int)(frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
				index++;
				
			}	
		}
		
}

