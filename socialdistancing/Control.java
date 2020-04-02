package socialdistancing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		String title = "Social Distance Simulation";
		//Model and View
		ArrayList<Person> model; //the community of Person objects	
		Simulator view; //JPanel graphics window
		
		// global counters
		public static int numInfected = 0;
		public static int numDied= 0;
		
		// Person simulation control
		public static int numPeople = 100;				// people in the simulation
		public static double toRoam = .10;			    // % population that required to roam in simulation (essential workers, rule breakers)
		public static double toBeInfected = .02;		// % of population that has virus in simulation
		public static double toDie = .06;				// % population that would die out of those that get infected
		public static int sickTimeLow = 5000;			// Minimum time to recover 5 seconds
		public static int sickTimeMax = 10000;			// Max time to recover 10 seconds
		
		//frame extents
		public static final int frameX = 800;
		public static final int frameY = 600;
		//position extents, keep objects away from the edges
		public static final int xExt = (int) (frameX - frameX*.04);
		public static final int yExt = (int) (frameY - frameY*.03);
		//oval size, represents person in frame
		public static final int OvalW = 10;	//Height
		public static final int OvalH = 10;	//Width
		
		//refresh timer, also used to calculate time/age of infection
		public static final int timerValue = 16;
	
		//Control for list of citizens in graphic frame
		public Control() {
			//setup the Model
			model = new ArrayList<Person>();
			for(int i = 0; i < Control.numPeople; i++) {
				//instantiate Person object and add it to the ArrayList
				model.add(new Person());
			}
			//setup to View
			Simulator view = new Simulator(this, title);
			view.setVisible();	// activate the View
		}
		
		//paints/repaints model of citizens in the frame 
		public void controlPaint(Graphics g) {
			
			//paint the Person in the Simulation!
			int index = 0;
			for(Person p: model) {
				for(Person p2: model) {
					//for each unique pair invoke the collision detection code
					p.collisionDetector(p2);
				}
				
				p.healthManager(); //manage health values of the Person
				p.velocityManager(); //manage social distancing and/or roaming values of the Person
				
				//set the color of the object based on the health status of person
				switch(p.state) {
					case candidate:
						g.setColor(Color.LIGHT_GRAY);
						break;
					case infected:
						g.setColor(Color.red);
						break;
					case recovered:
						g.setColor(Color.green);
						break;
					case died:
						g.setColor(Color.black);
						
				}
				
				//draw the oval in the simulation frame
				g.fillOval(p.x, p.y, OvalW, OvalH);
				
				// draw the oval in meter/bar indicator
				g.fillOval((frameX-(int)(frameX*.02)), (int)(frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
				index++;
				
			}	
		}
		
}

