package socialdistancing;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 
	Building extends JPanel so that we can override the paint method. The paint method is necessary to use the simple
	drawing tools of the library! 
	Simulator implements an ActionListener which adds the method actionPerformed. This method is invoked by the 
	animation timer every timerValue(16ms).
*/
public abstract class Panel extends JPanel implements ActionListener{
	// serial suppresses warning
	private static final long serialVersionUID = 1L;
	
	public Panel() {
		
	}
	
	/* This invoked by Timer per period in milliseconds in timerValue  */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Triggers paint call through polymorphism
		repaint();	
	}
	
	public abstract void paint(Graphics g);

			
}