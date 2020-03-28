package view_control;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model_socialdistancing.Person;

/* 
	SocialDistance extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 

	SocialDistance implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public class SocialDistance extends JPanel implements ActionListener{
	// serial suppresses warning
	private static final long serialVersionUID = 1L;
	private String title="Social Distance Simulation";
	
	//frame extents
	public final static int frameX = 800;
	public final static int frameY = 600;
	
	//oval size
	public static final int OvalW = 10;	//Height
	public static final int OvalH = 10;	//Width

	//simulation control values
	int time = 0; //track time as the simulation runs
	public final static int timerValue = 16;
	final int numPeople = 100;

	//store multiple Person and point objects
	ArrayList<Person> people = new ArrayList<Person>(); //the moving Person objects (circles)	

	//runner for the simulation - You can also create a different runner/driver class
	public static void main(String[] arg) {
		//CFrame c = new CFrame();
		new SocialDistance();
	}
		
	/* constructor will setup our main Graphic User Interface - a simple Frame! */
	public SocialDistance() {
		
		//Setup the GUI
		JFrame frame = new JFrame(title);
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
	
	/* This invoked by Timer per milliseconds in timerValue */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	/* paint method for drawing the simulation and animation */
	@Override
	public void paint(Graphics g) {
		//this method is invoked by the timer every 16ms. we're tracking the time manually with the time variable
		time += timerValue;
		
		super.paintComponent(g); // a necessary call to the parent paint method for proper screen refreshing
		
		//paint the Person objects!
		int index = 0;
		for(Person p: people) {
			for(Person p2: people)
				//for each unique pair invoke the collision detection code
				p.collision(p2);
			p.paint(g); //each Person object has a paint method
			
			// bar meter to show current state of people, note: color is returned from p.paint
			g.fillOval((frameX-(int)(frameX*.02)), (int) (frameY-((numPeople-index)*OvalH)/1.67), OvalW, OvalH);
			index++;
		}	
		
	}
	
}
