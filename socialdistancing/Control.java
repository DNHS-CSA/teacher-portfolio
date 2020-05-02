package socialdistancing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Control {
		String title = "Social Distance Simulation";
		//Model and View
		ArrayList<Person> model; //the community of Person objects	
		ArrayList<Building> buildings; //the community of Person objects	

		Panel view; //JPanel graphics window
		
		// counters for "this" simulation instance
		public int numInfected = 0;
		public int numDied= 0;
		
		
		// simulation control values
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
			//Setup the Panel and Timer
			Panel view = new Panel(title, frameX, frameY);
		
			//Setup the Buildings
			buildings = new ArrayList<Building>();
			buildings.add(new Building("Sprouts",550,0,620,160));
			buildings.add(new Building("Scripps Medical",200,0,-25,160));
			buildings.add(new Building("Board and Brew",550,400,620,400));
			buildings.add(new Building("Mr M's House",200,400,-25,400));
			
			//Setup the People
			model = new ArrayList<Person>();
			for(int i = 0; i < numPeople; i++) {
				//instantiate Person object and add it to the ArrayList
				model.add(new Person(this));
			}
			
			// Start the Simulation
			view.activate(this);
		}
		
		/*
		 * Call back method from Panel to Control
		 */
		public void paint(Graphics g) {
			paintBuildings(g);
			paintPersons(g);
		}
		
		/*
		 * Draw method for Panel
		 * paints/repaints buildings in the frame 
		 */	
		private void paintBuildings(Graphics g) {	
			//sets text color
			g.setColor(Color.BLACK);
			g.setFont(new Font("Roboto", Font.BOLD, 20));
			
			for (Building b: buildings) {
				b.drawImage(g, view);

			}

		}
		
		/*
		 * Draw method for Panel
		 * paints/repaints model of graphic objects repressing person objects in the frame 
		 */
		private void paintPersons(Graphics g) {
			
			//get each Person from the Model!
			int index = 0;
			for(Person p1: model) {
				
				//Person colliding with others
				for(Person p2: model) {
					p1.collisionDetector(p2);
				}
				
				//person colliding with buildings
				for (Building b: buildings) {
					p1.wallCollision(b);
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
				g.fillOval(p1.x, p1.y, OvalW, OvalH);
				
				//paint/repaint the person oval in meter/bar indicator
				g.fillOval((frameX-(int)(frameX*.02)), (int)(frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
				index++;
				
			}
		}
				
		
}