package view_control;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model_socialdistancing.Person;
import model_socialdistancing.Point;

/* 
	SocialDistance extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 

	SocialDistance implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public class SocialDistance extends JPanel implements ActionListener{
	// serial suppresses warning
	private static final long serialVersionUID = 1L;
	
	//frame extents
	public final static int frameX = 800;
	public final static int frameY = 600;

	//simulation control values
	int time = 0; //track time as the simulation runs
	public final static int timerValue = 16;
	final int numPeople = 100;

	//store multiple Person and point objects
	ArrayList<Person> people = new ArrayList<Person>(); //the moving Person objects (circles)
	
	//for drawing the graph
	ArrayList<Point> points = new ArrayList<Point>();
	

	//runner for the simulation - You can also create a different runner/driver class
	public static void main(String[] arg) {
		//CFrame c = new CFrame();
		new SocialDistance();
	}
		
	/* constructor will setup our main Graphic User Interface - a simple Frame! */
	public SocialDistance() {
		
		//Setup the GUI
		JFrame frame = new JFrame("Simulation");
		frame.setSize(frameX,frameY); //set the size
		
		//add this so that hitting the x button will actually end the program
		//the program will continue to run behind the scenes and you might end up with 10+ of them
		//without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setup the Person objects in the list
		for(int i = 0; i < numPeople; i++) {
			//instantiate an Person object and add it to the ArrayList
			//this is the part that actually CREATES objects we can use
			people.add(new Person());
		}
		
		//Timer for animation
		Timer t = new Timer(timerValue, this); //timerValue is the period in ms. so the timer code runs every 16ms.
					       //second argument (parameter) can be any class that implements
						// ActionListener
		t.restart(); //restart or start
		
		//make it visible
		frame.add(this); //add this class (JPanel) to the JFrame
		frame.setVisible(true);		
		
	}

	/* paint method for drawing the simulation and animation */
	@Override
	public void paint(Graphics g) {
		//this method is invoked by the timer every 16ms. we're tracking the time manually with the time variable
		time += timerValue;
		
		//as time passes (X)
		//number infected at that time (Y). 
		//amplitude over time illustrate infection and recovery
		points.add(new Point(time/timerValue, Person.numInfected));
		
		super.paintComponent(g); // a necessary call to the parent paint method for proper screen refreshing
		
		//paint the Person objects!
		for(Person p: people) {
			p.paint(g); //each Person object has a paint method. We're passing g as the argument
		}
		
		//check for collision by generating unique pairs of people
		for(Person p1: people)
			for(Person p2: people)
				//for each unique pair invoke the collision detection code
				p1.collision(p2);
		
		//draw the points for the graph
		//to represent amplitude of infection
		g.setColor(Color.blue);
		for(Point p: points) {
			g.fillOval(p.time, (frameY - (int)(frameY*.05))-p.value, Point.OvalW, Point.OvalH);
		}		
		
	}
	
	/* This invoked by Timer per milliseconds in timerValue */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
