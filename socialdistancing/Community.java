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
    public Community(String title, int frameX, int frameY) {
		
		//Setup the GUI
		frame = new JFrame(title);
		frame.setSize(frameX,frameY); //set the size
		
		//add this so that hitting the x button will actually end the program
		//the program will continue to run behind the scenes and you might end up with 10+ of them
		//without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make it visible
		frame.setVisible(true);
		frame.add(this); //add this class (JPanel) to the JFrame
		
        AddBuildings();

	}
    
	//activation of Simulator separated from Constructor 
	public void activate(Control c) {
		
		this.control = c;

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

    void AddBuildings() {
    	//Setup the Buildings
		buildings = new ArrayList<Building>();
		buildings.add(new Building("Sprouts",550,0,620,160));
		buildings.add(new Building("Scripps Medical",200,0,-25,160));
		buildings.add(new Building("Board and Brew",550,400,620,400));
		buildings.add(new Building("Mr M's House",200,400,-25,400));
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