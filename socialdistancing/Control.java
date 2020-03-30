package socialdistancing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		String title = "Social Distance Simulation";
		
		// global counters
		public static int numInfected = 0;
		public static int numDied= 0;
		
		// Citizen simulation control
		public static int numPeople = 100;	// people in the simulation
		public static double toRoam = .10;			    // % population that required to roam in simulation (essential workers, rule breakers)
		public static double toBeInfected = .02;			// % of population that has virus in simulation
		public static double toDie = .06;					// % population that would die out of those that get infected
		public static int sickTimeLow = 5000;				// Minimum time to recover 5 seconds
		public static int sickTimeMax = 10000;			// Max time to recover 10 seconds
		
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
		ArrayList<Citizen> model; //the community of objects	
		View view;
		
		public Control() {
			//Simulation setup
			//setup the Person objects in the list
			model = new ArrayList<Citizen>();
			for(int i = 0; i < Control.numPeople; i++) {
				//instantiate an Person object and add it to the ArrayList
				//this is the part that actually CREATES objects we can use
				model.add(new Citizen());
			}
			
			View view = new View(this, title);
			view.setVisible();	

		}
		
		// 
		public void modelPaint(Graphics g) {
			
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
				
				//draw the oval in the simulation frame
				g.fillOval(p.x, p.y, OvalW, OvalH);
				
				// draw the oval in meter
				g.fillOval((frameX-(int)(frameX*.02)), (int)(frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
				index++;
				
			}	
		}
		
}

