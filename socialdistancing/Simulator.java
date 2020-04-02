package socialdistancing;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/* 
	View extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 

	View implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public class View extends JPanel implements ActionListener{
	// serial suppresses warning
	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	Control ctl;
	
	//simulation control values
	int time = 0; //track time as the simulation runs
	
	/* constructor will setup our main Graphic User Interface - a simple Frame! */
	public View(Control ctl, String title) {
		// used for Control callback
		this.ctl = ctl;
		
		//Setup the GUI
		frame = new JFrame(title);
		frame.setSize(Control.frameX,Control.frameY); //set the size
		
		//add this so that hitting the x button will actually end the program
		//the program will continue to run behind the scenes and you might end up with 10+ of them
		//without realizing it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Timer for animation
		Timer t = new Timer(Control.timerValue, this); //timerValue is the period in ms. so the timer code runs every 16ms.
					       //second argument (parameter) can be any class that implements
						// ActionListener
		t.restart(); //restart or start
		
		//make it visible
		frame.add(this); //add this class (JPanel) to the JFrame
		
	}
	
	//activation separated from Constructor 
	public void setVisible() {
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
		time += Control.timerValue;
		
		super.paintComponent(g); // a necessary call to the parent paint method, required for proper screen refreshing	
		ctl.controlPaint(g); // repaint all objects in simulation
		
	}
	
	
}
