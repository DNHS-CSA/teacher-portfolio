package socialdistancing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Community extends Panel {
	private static final long serialVersionUID = 1L;

	ArrayList<Building> buildings; //the community of Person objects	

	//simulation control objects/values
	JFrame frame;
	Control control; //
	Timer timer; //Event control	
	int time = 0; //Track time as the simulation runs
	
	/* constructor will setup our main Graphic User Interface - a simple Frame! */
    public Community(Control c) {
		//link Community to control
    	this.control = c;

		//Setup the GUI
		frame = new JFrame(control.title);
		frame.setSize(control.frameX,control.frameY); //set the size
		
		//add this so that hitting the x button will actually end the program
		//the program will continue to run behind the scenes and you might end up with 10+ of them
		//without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make it visible
		frame.setVisible(true);
		frame.add(this); //add this class (JPanel) to the JFrame
		
	}
    
	//activation of Simulator separated from Constructor 
	public void activate() {
		
		
		//Prior to activation add objects to Community
        addBuildings();

		//Timer for animation
		//Argument 1: timerValue is a period in milliseconds to fire event
		//Argument 2:t any class that "implements ActionListener"
		timer = new Timer(control.timerValue, this); //timer constructor
		timer.restart(); //restart or start
		
		// frame becomes visible
		frame.setVisible(true);		
	}
	
	/* paint method for drawing the simulation and animation */
	@Override
	public void paint(Graphics g) {
		
		//tracking total time manually with the time variable
		time += control.timerValue;
		
		//events
		super.paintComponent(g); // a necessary call to the parent paint method, required for proper screen refreshing
		paintBuildings(g);
		control.paint(g);
	
	} 

    void addBuildings() {
    	//Setup the Buildings
		this.buildings = new ArrayList<Building>();

    	Building[] buildings = control.buildings();  //settings values
    	for (Building b: buildings) {
    		this.buildings.add(b);
    	}
    }
    
    public ArrayList<Building> getBuildings() {
    	return buildings;	
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
			b.drawImage(g, this);

		}

	}

}