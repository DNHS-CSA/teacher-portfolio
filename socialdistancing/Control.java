package socialdistancing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		String title = "Social Distance Simulation";
		//Model and View
		ArrayList<Person> model; //the community of Person objects
		Community view;
		
		//counters for "this" simulation instance
		public int numInfected = 0;
		public int numDied= 0;
		
		//simulation control values
		public int  numPeople;			
		public double toRoam;			    
		public double toBeInfected;		
		public double toDie;				
		public int sickTimeLow;			
		public int sickTimeMax;
		//frame extents
		public int frameX;
		public int frameY;
		//position extents, keep objects away from the edges
		public int xExt;
		public int yExt;
		//oval size, represents person in frame
		public int OvalW;	//Height
		public int OvalH;	//Width
		//refresh timer, also used to calculate time/age of infection
		public int timerValue;
		
		//simulation properties for Buildings
		public Building[] buildings() {
			Building[] b = { 
					new Building("Rubber Chicken",550,0,620,160),
					new Building("Sprouts",200,0,-25,160),
					new Building("Wuhan",550,400,620,400),
					new Building("CollegeBoard",200,400,-25,400),
			};
			return b;
		}
	
		/*
		 * Default constructor uses Static/Default simulation values
		 */
		public Control() {
			//This sets defaults in case run with default constructor
			// simulation control starting values
			numPeople = Settings.sNumPeople;			
			toRoam = Settings.sToRoam;			    
			toBeInfected = Settings.sToBeInfected;		
			toDie = Settings.sToDie;				
			sickTimeLow = Settings.sSickTimeLow;			
			sickTimeMax = Settings.sSickTimeMax;
			//frame extents
			frameX = Settings.sFrameX;
			frameY = Settings.sFrameY;
			//position extents, keep objects away from the edges
			xExt = Settings.sXExt;
			yExt = Settings.sYExt;
			//oval size, represents person in frame
			OvalW = Settings.sOvalW;	//Height
			OvalH = Settings.sOvalH;	//Width
			//refresh timer, also used to calculate time/age of infection
			timerValue = Settings.sTimerValue;
		}

		/*
		 * This constructor uses user defined simulation Settings
		 */
		public Control(Settings sets) {
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
		 * Tester method to run simulation
		 */
		public static void main (String[] args) {
			Control c = new Control();
			c.simulation();
		}
		
		/* 
		 * This method coordinates MVC for Simulation
		 * - The Simulation is managing People in a Graphics frame to simulate a virus outbreak
		 * - Prerequisite: Control values from constructor are ready
		 */
		public void simulation() {
			//Setup the Community and Refresh Timer
			view = new Community(this);
		
			//Setup the People
			model = new ArrayList<Person>();
			for(int i = 0; i < numPeople; i++) {
				//instantiate Person object and add it to the ArrayList
				model.add(new Person(this));
			}
			
			// Start the Simulation
			view.activate();
		}
			
		/*
		 * Draw method for Panel
		 * paints/repaints model of objects representing person objects in the frame 
		 */
		public void paint(Graphics g) {
			
			//get each Person from the Model!
			int index = 0;
			for(Person p1: model) {
				
				//Person colliding with other persons
				for(Person p2: model) {
					if (p1.collisionDetector(p2))
						p1.collisionAction(p2);
				}
				
				//person colliding with buildings
				for (Building b: view.getBuildings()) {
					if (p1.collisionDetector(b.getVWall()))
						p1.collisionActionWithVerticalObstacle();

					if (p1.collisionDetector(b.getHWall()))
						p1.collisionActionWithHorizontalObstacle();
				}
				
				//update person health
				p1.healthManager(); //manage health values of the Person
				p1.velocityManager(); //manage social distancing and/or roaming values of the Person
				
				//set the color of the for the person oval based on the health status of person object
				switch(p1.state) {
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
				
				//paint/repaint the person oval in the simulation frame
				g.fillOval(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
				
				//paint/repaint the person oval in meter/bar indicator
				g.fillOval((frameX-(int)(frameX*.02)), (int)(frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
				index++;
				
			}
		}		
		
}