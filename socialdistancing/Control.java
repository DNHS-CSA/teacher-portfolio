package socialdistancing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		String title = "Social Distance Simulation";
		//Model and View
		ArrayList<Person> model; //the community of Person objects	
		Simulator view; //JPanel graphics window
		
		// counters for simulation instance
		public int numInfected = 0;
		public int numDied= 0;
		
		//This sets defaults in case run with default constructor
		// simulation control starting values
		public int  numPeople = Settings.sNumPeople;			
		public double toRoam = Settings.sToRoam;			    
		public double toBeInfected = Settings.sToBeInfected;		
		public double toDie = Settings.sToDie;				
		public int sickTimeLow = Settings.sSickTimeLow;			
		public int sickTimeMax = Settings.sSickTimeMax;
		//frame extents
		public int frameX = Settings.sFrameX;
		public int frameY = Settings.sFrameY;
		//position extents, keep objects away from the edges
		public int xExt = Settings.sXExt;
		public int yExt = Settings.sYExt;
		//oval size, represents person in frame
		public int OvalW = Settings.sOvalW;	//Height
		public int OvalH = Settings.sOvalH;	//Width
		//refresh timer, also used to calculate time/age of infection
		public int timerValue = Settings.sTimerValue;
	
		/*
		 * Constructor call to a Control panel to setup Static values
		 */
		public Control(Settings sets) {
			//This constructor sets defaults from Settings actions/event
			// health settings
			numPeople = sets.numPeople;
			toRoam = sets.toRoam;
			toBeInfected = sets.toBeInfected;
			toDie = sets.toDie;
			sickTimeLow = sets.sickTimeLow;
			sickTimeMax = sets.sickTimeMax;
			// simulator settings
			frameX = sets.frameX;
			frameY = sets.frameY;
			yExt = sets.yExt;
			xExt = sets.xExt;
			OvalW = sets.OvalW;
			OvalH = sets.OvalH;
			timerValue = sets.timerValue;
		}
		
		/* 
		 * This method coordinates MVC for Simulation
		 * - The Simulation is managing People in Graphics frame to simulate a virus pandemic
		 */
		public void runSimulation() {
			//Prerequisite: control values are ready
			
			//Setup to the Simulation Panel
			Simulator view = new Simulator(this, title);
			
			//Setup the People
			model = new ArrayList<Person>();
			for(int i = 0; i < numPeople; i++) {
				//instantiate Person object and add it to the ArrayList
				model.add(new Person(this));
			}
			
			// Start Simulation
			view.setVisible();
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

